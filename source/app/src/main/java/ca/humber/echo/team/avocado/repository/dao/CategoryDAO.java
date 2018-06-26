package ca.humber.echo.team.avocado.repository.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import ca.humber.echo.team.avocado.repository.model.Category;

@Dao
public interface CategoryDAO {

    @Insert
    void insert(Category category);

    @Insert
    void insertAll(List<Category> categoryItems);

    @Update
    void update(Category category);

    @Delete
    void delete(Category category);

    @Query("SELECT * FROM CATEGORY WHERE id=:id")
    Category getCategoryById(long id);

    @Query("SELECT * FROM CATEGORY")
    List<Category> getAllCategories();

    @Query("SELECT * FROM CATEGORY WHERE reference_id=:categoryId")
    List<Category> getSubCategories(long categoryId);



}
