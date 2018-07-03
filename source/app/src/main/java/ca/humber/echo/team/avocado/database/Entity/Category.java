package ca.humber.echo.team.avocado.database.Entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

/**
 * Entity Java Bean class
 * @author leonardootoni
 */
@Entity(tableName = "CATEGORY",
        foreignKeys = {@ForeignKey(entity = Category.class, parentColumns = "id", childColumns = "reference_id")},
        indices = { @Index(name = "IDX_FK_CATEGORY_REFERENCE_ID", value = {"reference_id"})})
public class Category {

    @NonNull
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private Long id;

    @NonNull
    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "reference_id")
    private Long referenceId;

    //Constructor during the initial load
    @Ignore
    public Category(@NonNull String name, Long subcategory){
        this.name = name;
        this.referenceId = subcategory;
    }

    public Category(@NonNull long id, @NonNull String name, long referenceId) {
        this.id = id;
        this.name = name;
        this.referenceId = referenceId;
    }

    @NonNull
    public Long getId() {
        return id;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public Long getReferenceId() {
        return referenceId;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", referenceId=" + referenceId +
                '}';
    }

    public void setId(@NonNull long id) {
        this.id = id;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    public void setReferenceId(long referenceId) {
        this.referenceId = referenceId;
    }
}
