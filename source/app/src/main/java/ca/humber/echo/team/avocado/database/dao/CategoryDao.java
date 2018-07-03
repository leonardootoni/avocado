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
 * Category and Sub-category DAO class
 * @author leonardootoni
 */
@Dao
public interface CategoryDao extends BaseDao<Category> {

    @Query("SELECT * FROM CATEGORY WHERE id=:id")
    LiveData<Category> getCategoryById(long id);

    @Query("SELECT * FROM CATEGORY")
    LiveData<List<Category>> getAllCategories();

    @Query("SELECT * FROM CATEGORY WHERE reference_id=:categoryId")
    LiveData<List<Category>> getSubCategories(long categoryId);

}
