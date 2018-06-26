package ca.humber.echo.team.avocado.repository.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.Date;
import java.util.List;

import ca.humber.echo.team.avocado.repository.model.Expense;

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
    Expense getExpenseById(long id);

    @Query("SELECT * FROM EXPENSE WHERE category_id=:categoryId")
    List<Expense> getAllExpensesByCategory(long categoryId);

    @Query("SELECT * FROM EXPENSE WHERE subcategory_id=:subcategoryId")
    List<Expense> getAllExpensesBySubCategory(long subcategoryId);

    @Query("SELECT * FROM EXPENSE WHERE date=:date")
    List<Expense> getAllExpensesByDate(Date date);

    @Query("SELECT * FROM EXPENSE WHERE date BETWEEN :dateIni and :dateEnd")
    List<Expense> getAllExpensesByPeriod(Date dateIni, Date dateEnd);


}
