package ca.humber.echo.team.avocado.repository;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

import ca.humber.echo.team.avocado.database.AppDataBase;
import ca.humber.echo.team.avocado.database.Entity.Expense;
import ca.humber.echo.team.avocado.database.dao.CategoryDao;
import ca.humber.echo.team.avocado.database.dao.ExpenseDao;

public class ReportsRepository {
    private ExpenseDao expenseDAO;
    private CategoryDao categoryDAO;
    private LiveData<List<Expense>> allReports;

    public ReportsRepository(Application application){
        AppDataBase appDataBase = AppDataBase.getInstance(application); //Gets the DATABASE instance
        expenseDAO = appDataBase.expenseDAO();
        categoryDAO = appDataBase.categoryDAO();
        allReports = expenseDAO.getAllExpenses();
    }

    public void insert(Expense expense){

        new ReportsRepository.InsertAsyncTask(expenseDAO).execute(expense);
    }


    public LiveData<List<Expense>> getAllExpenses() {
        return expenseDAO.getAllExpenses();
    }

    public LiveData<List<String>> getLargestExpenseName() {
        return expenseDAO.getLargestExpenseName();
    }

    public LiveData<List<Double>> getLargestExpenseValue() {
        return expenseDAO.getLargestExpenseValue();
    }

    public LiveData<List<String>> getLargestEntryCategoryName() {
        return expenseDAO.getLargestEntryCategoryName();
    }

    public LiveData<List<Integer>> getLargestEntryCategoryCount() {
        return expenseDAO.getLargestEntryCategoryCount();
    }

    public LiveData<List<String>> getLargestEntrySubCategoryName() {
        return expenseDAO.getLargestEntrySubCategoryName();
    }

    public LiveData<List<Integer>> getLargestEntrySubCategoryCount() {
        return expenseDAO.getLargestEntrySubCategoryCount();
    }

    public LiveData<List<String>> getLargestEntryDescriptionName() {
        return expenseDAO.getLargestEntryDescriptionName();
    }

    public LiveData<List<Integer>> getLargestEntryDescriptionCount() {
        return expenseDAO.getLargestEntryDescriptionCount();
    }


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
