package ca.humber.echo.team.avocado.database.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import ca.humber.echo.team.avocado.database.Entity.Category;

/**
 * Category DAO Class
 * Public interface that defines all queries submited to the database.
 * The Interface implementation is made by Room automatically, on the application build process.
 * @author leonardootoni
 */
@Dao
public interface CategoryDao extends BaseDao<Category> {

    @Query("SELECT * FROM CATEGORY WHERE id=:id")
    LiveData<Category> getCategoryById(long id);

    @Query("SELECT * FROM CATEGORY WHERE reference_id IS NULL ORDER BY NAME")
    LiveData<List<Category>> getAllCategories();

    @Query("SELECT * FROM CATEGORY WHERE reference_id IS NOT NULL ORDER BY NAME")
    LiveData<List<Category>> getAllSubCategories();

    @Query("SELECT * FROM CATEGORY WHERE reference_id=:categoryId ORDER BY NAME")
    LiveData<List<Category>> getSubCategories(long categoryId);

}
