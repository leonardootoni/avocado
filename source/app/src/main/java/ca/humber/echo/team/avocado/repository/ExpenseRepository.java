package ca.humber.echo.team.avocado.repository;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

import ca.humber.echo.team.avocado.database.AppDataBase;
import ca.humber.echo.team.avocado.database.Entity.Category;
import ca.humber.echo.team.avocado.database.Entity.Expense;
import ca.humber.echo.team.avocado.database.dao.CategoryDao;
import ca.humber.echo.team.avocado.database.dao.ExpenseDao;

/**
 * Class that abstract access to multiple datasources and handle data operations.
 * It manages query threads and allows the use of multiple backends.
 *
 * More at: https://codelabs.developers.google.com/codelabs/android-room-with-a-view/#7
 *
 * @author leonardootoni
 */
public class ExpenseRepository {

    private ExpenseDao expenseDAO;
    private CategoryDao categoryDAO;

    public ExpenseRepository(Application application){
        AppDataBase appDataBase = AppDataBase.getInstance(application);
        expenseDAO = appDataBase.expenseDAO();
        categoryDAO = appDataBase.categoryDAO();
    }

    public void insert(Expense expense){
        new InsertAsyncTask(expenseDAO).execute(expense);
    }

    public LiveData<List<Category>> getAllCategories() {

        return categoryDAO.getAllCategories();

    }


    /**
     * Starts an asynchronous thread to save a data away from the main thread.
     */
    private static class InsertAsyncTask extends AsyncTask<Expense, Void, Void> {

        private ExpenseDao mAsyncTaskDao;

        InsertAsyncTask(ExpenseDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Expense... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;

        }
    }
}
