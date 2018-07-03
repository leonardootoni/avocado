package ca.humber.echo.team.avocado.database.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.Date;
import java.util.List;

import ca.humber.echo.team.avocado.database.Entity.Expense;

/**
 * Expense DAO class
 * @author leonardootoni
 */
@Dao
public interface ExpenseDAO {

    @Insert
    void insert(Expense expense);

    @Insert
    void insertAll(List<Expense> expenseList);

    @Update
    void update(Expense expense);

    @Delete
    void delete(Expense expense);

    @Query("SELECT * FROM EXPENSE WHERE id=:id")
    LiveData<Expense> getExpenseById(long id);

    @Query("SELECT * FROM EXPENSE WHERE category_id=:categoryId ORDER BY date DESC")
    LiveData<List<Expense>> getAllExpensesByCategory(long categoryId);

    @Query("SELECT * FROM EXPENSE WHERE subcategory_id=:subcategoryId ORDER BY date DESC")
    LiveData<List<Expense>> getAllExpensesBySubCategory(long subcategoryId);

    @Query("SELECT * FROM EXPENSE WHERE date=:date  ORDER BY date DESC")
    LiveData<List<Expense>> getAllExpensesByDate(Date date);

    @Query("SELECT * FROM EXPENSE WHERE date BETWEEN :dateIni and :dateEnd ORDER BY date DESC")
    LiveData<List<Expense>> getAllExpensesByPeriod(Date dateIni, Date dateEnd);


}
