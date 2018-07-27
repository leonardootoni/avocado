package ca.humber.echo.team.avocado.database.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import java.util.Date;
import java.util.List;

import ca.humber.echo.team.avocado.database.Entity.Expense;
import ca.humber.echo.team.avocado.database.pojos.TotalExpensesByBudget;

/**
 * Expense DAO class
 * @author leonardootoni
 */
@Dao
public interface ExpenseDao extends BaseDao<Expense> {

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

    @Query("SELECT SUM(e.value) AS totalExpenses, " +
            "b.value AS totalBudget, " +
            "a.alert_budget_percent_limit AS percentLimit, " +
            "ROUND((SUM(e.value) / b.value) * 100, 2) as percentAchieved, " +
            "c.name AS categoryName " +
            "FROM EXPENSE e, " +
            "BUDGET b on e.CATEGORY_ID = b.CATEGORY_ID, " +
            "CATEGORY c on b.category_id = c.id, " +
            "(SELECT  * FROM ACCOUNT_SETTINGS WHERE ROWID = 1) a " +
            "WHERE strftime('%m', e.date) = strftime('%m', :systemTime) " +
            "AND e.category_id = :idCategory " +
            "GROUP BY b.value, a.alert_budget_percent_limit, c.name ")
    TotalExpensesByBudget getTotalExpensesByBudget(Long idCategory, Date systemTime);

//  REPORTS QUERY
    @Query("SELECT * FROM EXPENSE ORDER BY value DESC")
    LiveData<List<Expense>> getAllExpenses();

//    @Query("SELECT description, value FROM EXPENSE ORDER BY value DESC LIMIT 1")
//    LiveData<List<String>> getLargestExpense();
//
//    @Query("SELECT c.name, COUNT(e.category_id) FROM EXPENSE e JOIN CATEGORY c ON e.category_id = c.id GROUP BY e.category_id ORDER BY COUNT(e.category_id) DESC LIMIT 1")
//    LiveData<List<String>> getLargestEntriesCategory();
//
//    @Query("SELECT c.name, COUNT(e.subcategory_id) FROM EXPENSE e JOIN CATEGORY c ON e.subcategory_id = c.id GROUP BY e.category_id ORDER BY COUNT(e.subcategory_id) DESC LIMIT 1")
//    LiveData<List<String>> getLargestEntriesSubCategory();
//
//    @Query("SELECT description, COUNT(description) FROM EXPENSE GROUP BY description ORDER BY COUNT(description) DESC LIMIT 1")
//    LiveData<List<String>> getLargestEntriesDescription();



    @Query("SELECT description FROM EXPENSE ORDER BY value DESC LIMIT 1")
    LiveData<String> getLargestExpenseName();

    @Query("SELECT value FROM EXPENSE ORDER BY value DESC LIMIT 1")
    LiveData<Double> getLargestExpenseValue();

    @Query("SELECT c.name FROM EXPENSE e JOIN CATEGORY c ON e.category_id = c.id GROUP BY e.category_id ORDER BY COUNT(e.category_id) DESC LIMIT 1")
    LiveData<String> getLargestEntryCategoryName();

    @Query("SELECT COUNT(e.category_id) FROM EXPENSE e JOIN CATEGORY c ON e.category_id = c.id GROUP BY e.category_id ORDER BY COUNT(e.category_id) DESC LIMIT 1")
    LiveData<Integer> getLargestEntryCategoryCount();

    @Query("SELECT c.name FROM EXPENSE e JOIN CATEGORY c ON e.subcategory_id = c.id GROUP BY e.category_id ORDER BY COUNT(e.subcategory_id) DESC LIMIT 1")
    LiveData<String> getLargestEntrySubCategoryName();

    @Query("SELECT COUNT(e.subcategory_id) FROM EXPENSE e JOIN CATEGORY c ON e.subcategory_id = c.id GROUP BY e.category_id ORDER BY COUNT(e.subcategory_id) DESC LIMIT 1")
    LiveData<Integer> getLargestEntrySubCategoryCount();

    @Query("SELECT description FROM EXPENSE GROUP BY description ORDER BY COUNT(description) DESC LIMIT 1")
    LiveData<String> getLargestEntryDescriptionName();

    @Query("SELECT COUNT(description) FROM EXPENSE GROUP BY description ORDER BY COUNT(description) DESC LIMIT 1")
    LiveData<Integer> getLargestEntryDescriptionCount();
}
