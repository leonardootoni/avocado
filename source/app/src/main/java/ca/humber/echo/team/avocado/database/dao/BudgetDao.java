package ca.humber.echo.team.avocado.database.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import ca.humber.echo.team.avocado.database.Entity.Budget;

/**
 * Budget DAO class
 * @author leonardootoni
 */
@Dao
public interface BudgetDao extends BaseDao<Budget> {

    @Query("SELECT * FROM BUDGET WHERE category_id=:categoryId")
    LiveData<Budget> getBudgetByCategory(long categoryId);

    @Query("SELECT * FROM BUDGET WHERE id=:budgetId")
    LiveData<Budget> getBudgetById(long budgetId);

    @Query("SELECT * FROM BUDGET")
    LiveData<List<Budget>> getAllBudget();

}
