package ca.humber.echo.team.avocado.repository.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import ca.humber.echo.team.avocado.repository.model.Budget;

@Dao
public interface BudgetDAO {

    @Insert
    void insert(Budget budget);

    @Insert
    void inserAll(List<Budget> budgetList);

    @Update
    void update(Budget budget);

    @Delete
    void delete(Budget budget);

    @Query("SELECT * FROM BUDGET WHERE category_id=:categoryId")
    Budget getBudgetByCategory(long categoryId);

    @Query("SELECT * FROM BUDGET WHERE id=:budgetId")
    Budget getBudgetById(long budgetId);

    @Query("SELECT * FROM BUDGET")
    List<Budget> getAllBudget();

}
