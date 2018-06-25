package ca.humber.echo.team.avocado.repository.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.util.Date;

/**
 * Entity Java Bean class
 */
@Entity(tableName = "EXPENSE",
        foreignKeys = {@ForeignKey(entity = Category.class, parentColumns = "id", childColumns = "category_id"),
                       @ForeignKey(entity = Category.class, parentColumns = "id", childColumns = "subcategory_id")},
        indices = {@Index(name = "IDX_EXPENSE_DATE", value = {"date"})})
public class Expense {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "id")
    private Long id;

    @NonNull
    @ColumnInfo(name = "value")
    private Double value;

    @NonNull
    @ColumnInfo(name = "description")
    private String description;

    @NonNull
    @ColumnInfo(name = "date")
    private Date date;

    @NonNull
    @ColumnInfo(name = "category_id")
    private Long categoryId;

    @NonNull
    @ColumnInfo(name = "subcategory_id")
    private Long subcategoryId;

    public Expense(Long id, Double value, String description, Date date, Long categoryId, Long subcategoryId) {
        this.id = id;
        this.value = value;
        this.description = description;
        this.date = date;
        this.categoryId = categoryId;
        this.subcategoryId = subcategoryId;
    }

    @NonNull
    public Long getId() {
        return id;
    }

    @NonNull
    public Double getValue() {
        return value;
    }

    @NonNull
    public String getDescription() {
        return description;
    }

    @NonNull
    public Date getDate() {
        return date;
    }

    @NonNull
    public Long getCategoryId() {
        return categoryId;
    }

    @NonNull
    public Long getSubcategoryId() {
        return subcategoryId;
    }
}
