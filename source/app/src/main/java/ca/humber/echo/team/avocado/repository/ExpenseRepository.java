package ca.humber.echo.team.avocado.repository;

import android.accounts.Account;
import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.util.Log;

import java.util.Calendar;
import java.util.List;

import ca.humber.echo.team.avocado.AvocadoApplication;
import ca.humber.echo.team.avocado.R;
import ca.humber.echo.team.avocado.database.AppDataBase;
import ca.humber.echo.team.avocado.database.Entity.Category;
import ca.humber.echo.team.avocado.database.Entity.Expense;
import ca.humber.echo.team.avocado.database.Entity.User;
import ca.humber.echo.team.avocado.database.dao.CategoryDao;
import ca.humber.echo.team.avocado.database.dao.ExpenseDao;
import ca.humber.echo.team.avocado.database.pojos.TotalExpensesByBudget;
import ca.humber.echo.team.avocado.helper.NotificationHelper;

/**
 * Class that abstract access to multiple datasources and handle data operations.
 * It manages query threads and allows the use of multiple backends.
 *
 * More at: https://codelabs.developers.google.com/codelabs/android-room-with-a-view/#7
 *
 * @author leonardootoni
 */
public class ExpenseRepository {

    //DAOs used by this repository
    private ExpenseDao expenseDAO;
    private CategoryDao categoryDAO;

    public ExpenseRepository(Application application){
        AppDataBase appDataBase = AppDataBase.getInstance(application); //gets the database instance
        expenseDAO = appDataBase.expenseDAO();
        categoryDAO = appDataBase.categoryDAO();
    }

    /**
     * Save an expense into the database.
     * @param expense - An Expense instance object
     */
    public void insert(Expense expense){

        new InsertAsyncTask(expenseDAO).execute(expense);
    }

    public LiveData<List<Category>> getAllCategories() {
        return categoryDAO.getAllCategories();
    }

    public LiveData<List<Category>> getAllSubCategories(){
        return categoryDAO.getAllSubCategories();
    }

    public LiveData<List<Category>> getSubCategories(long categoryId){
        return categoryDAO.getSubCategories(categoryId);
    }


    /**
     * Starts an asynchronous thread to save a data away from the main thread.
     *
     */
    private static class InsertAsyncTask extends AsyncTask<Expense, Void, Void> {

        private ExpenseDao mAsyncTaskDao;
        private Long idCategory;
        private TotalExpensesByBudget tebb;

        private static String TOKEN = "${TOKEN}";
        private static String CATEGORY = "${CATEGORY}";
        private static String BUDGET = "${BUDGET}";
        private static String EXPENDITURE = "${EXPENDITURE}";

        InsertAsyncTask(ExpenseDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Expense... params) {
            idCategory = params[0].getCategoryId();
            mAsyncTaskDao.insert(params[0]);

            //fetch the expenseTotal and budget set for a given category
            tebb = mAsyncTaskDao.getTotalExpensesByBudget(idCategory, Calendar.getInstance().getTime());
            return null;

        }

        @Override
        protected void onPostExecute(Void aVoid) {

            if(tebb != null){ //has a budget and alert range set

                if(tebb.isBudgetInAlertRange() && !tebb.isBustedBudget()){

                    String[] message = formatAlertMessage(tebb);
                    NotificationHelper.getInstance()
                            .emmitNotification(message[0], message[1]);

                }else if(tebb.isBustedBudget()){

                    //Notifiy the user that the budget for a given category just busted
                    String[] message =  formatBustedBudgetMessage(tebb);
                    NotificationHelper.getInstance()
                            .emmitNotification( message[0], message[1]);
                }

            }

        }

        /**
         * Format a busted budget message do display as a notification
         * @param tebb - TotalExpensesByBudget POJO
         * @return String[]{messageTitle, message}
         */
        private String[] formatBustedBudgetMessage(TotalExpensesByBudget tebb) {

            String messageTitle = AvocadoApplication.getContext().getResources()
                    .getString(R.string.notifications_title_budget_busted);

            String message = AvocadoApplication.getContext().getResources()
                    .getString(R.string.notif_msg_budget_busted);

            message = message
                    .replace(TOKEN, tebb.getPercentAchievedToString())
                    .replace(CATEGORY, tebb.getCategoryName())
                    .replace(BUDGET, tebb.getTotalBudgetToString())
                    .replace(EXPENDITURE, tebb.getTotalExpensesToString());

            return new String[]{messageTitle, message};

        }

        /**
         * Format an alert message do display as a notification
         * @param tebb - TotalExpensesByBudget POJO
         * @return String[]{messageTitle, message}
         */
        private String[] formatAlertMessage(TotalExpensesByBudget tebb) {

            //Emit alert to inform that the expense totatl is in the alert range
            String messageTitle = AvocadoApplication.getContext().getResources()
                    .getString(R.string.notifications_title_budget_alert);

            String message = AvocadoApplication.getContext().getResources()
                    .getString(R.string.notif_msg_budget_in_alert_range);

            message = message
                    .replace(TOKEN, tebb.getPercentAchievedToString())
                    .replace(CATEGORY, tebb.getCategoryName())
                    .replace(BUDGET, tebb.getTotalBudgetToString())
                    .replace(EXPENDITURE, tebb.getTotalExpensesToString());

            return new String[]{messageTitle, message};

        }
    }
}
