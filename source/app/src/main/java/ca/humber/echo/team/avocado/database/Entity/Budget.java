package ca.humber.echo.team.avocado.database.Entity;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

/**
 * Entity Java Bean class
 * @author leonardootoni
 */
@Entity(tableName = "BUDGET",
        foreignKeys = {@ForeignKey(entity = Category.class, parentColumns = "id", childColumns = "category_id")},
        indices = { @Index(name = "IDX_FK_BUDGET_CATEGORY_ID", value = {"category_id"}, unique = true)})
public class Budget {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private Long id;

    @NonNull
    @ColumnInfo(name = "value")
    private Double value;

    /**
     * This column has an unique index to restrict at the database level that only one budget can
     * be set to a given category.
     */
    @NonNull
    @ColumnInfo(name = "category_id")
    private Long referenceId;

    public Budget(Long id, @NonNull Double value, @NonNull Long referenceId) {
        this.id = id;
        this.value = value;
        this.referenceId = referenceId;
    }

    public Long getId() {
        return id;
    }

    @NonNull
    public Double getValue() {
        return value;
    }

    @NonNull
    public Long getReferenceId() {
        return referenceId;
    }

    @Override
    public String toString() {
        return "Budget{" +
                "id=" + id +
                ", value='" + value + '\'' +
                ", referenceId=" + referenceId +
                '}';
    }
}
