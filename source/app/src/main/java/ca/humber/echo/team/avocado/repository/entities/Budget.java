package ca.humber.echo.team.avocado.repository.entities;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

/**
 * Entity Java Bean class
 */
@Entity(tableName = "BUDGET",
        foreignKeys = {@ForeignKey(entity = Category.class, parentColumns = "id", childColumns = "category_id")})
public class Budget {

    @NonNull
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private Long id;

    @NonNull
    @ColumnInfo(name = "name")
    private String name;

    @NonNull
    @ColumnInfo(name = "category_id")
    private Long referenceId;

    public Budget(Long id, String name, Long referenceId) {
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

    @NonNull
    public Long getReferenceId() {
        return referenceId;
    }
}
