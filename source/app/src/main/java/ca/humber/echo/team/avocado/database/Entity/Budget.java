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
        indices = { @Index(name = "IDX_FK_BUDGET_CATEGORY_ID", value = {"category_id"})})
public class Budget {

    @NonNull
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private long id;

    @NonNull
    @ColumnInfo(name = "name")
    private String name;

    @NonNull
    @ColumnInfo(name = "category_id")
    private long referenceId;

    public Budget(@NonNull long id, @NonNull String name, @NonNull long referenceId) {
        this.id = id;
        this.name = name;
        this.referenceId = referenceId;
    }

    @NonNull
    public long getId() {
        return id;
    }

    @NonNull
    public String getName() {
        return name;
    }

    @NonNull
    public long getReferenceId() {
        return referenceId;
    }

    @Override
    public String toString() {
        return "Budget{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", referenceId=" + referenceId +
                '}';
    }
}
