package ca.humber.echo.team.avocado.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Update;

import java.util.List;

/**
 * Base Interface for generic DAO methods
 * @author leonardootoni
 */
@Dao
public interface BaseDao<T> {

    @Insert
    void insert(T entity);

    @Insert
    void insertAll(List<T> entityList);

    @Update
    void update(T entity);

    @Update
    void updateAll(List<T> entity);

    @Delete
    void delete(T entity);

    @Delete
    void deleteAll(List<T> entity);
}
