package ca.humber.echo.team.avocado.database;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;

import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;
import android.support.annotation.NonNull;

import java.util.concurrent.Executors;

import ca.humber.echo.team.avocado.database.InitialData.InitialBaseData;
import ca.humber.echo.team.avocado.database.dao.CategoryDao;
import ca.humber.echo.team.avocado.database.dao.UserDao;
import ca.humber.echo.team.avocado.database.utils.Converter;
import ca.humber.echo.team.avocado.database.dao.AccountSettingsDao;
import ca.humber.echo.team.avocado.database.dao.BudgetDao;
import ca.humber.echo.team.avocado.database.dao.ExpenseDao;
import ca.humber.echo.team.avocado.database.Entity.AccountSettings;
import ca.humber.echo.team.avocado.database.Entity.Budget;
import ca.humber.echo.team.avocado.database.Entity.Category;
import ca.humber.echo.team.avocado.database.Entity.Expense;
import ca.humber.echo.team.avocado.database.Entity.User;

/***
 * Main app's database class definition.
 * @author leonardootoni
 */
@Database(
        entities = {
                AccountSettings.class,
                Budget.class,
                Category.class,
                Expense.class,
                User.class
        },
        version = 1)
@TypeConverters({Converter.class})
public abstract class AppDataBase extends RoomDatabase {

    private static AppDataBase instance;

    public static AppDataBase getInstance(Context context) {

        if(instance == null){
            synchronized (AppDataBase.class){
                if(instance == null){

                    instance = Room.databaseBuilder(context.getApplicationContext(),
                            AppDataBase.class, "avocado-database")
                            .addCallback(new Callback() {
                                @Override
                                public void onCreate(@NonNull SupportSQLiteDatabase db) {
                                    super.onCreate(db);
                                    Executors.newSingleThreadExecutor().execute(new Runnable() {
                                        @Override
                                        public void run() {
                                            InitialBaseData ibd = new InitialBaseData();
                                            //insert initial base data after the database creation
                                            instance.categoryDAO().insertAll(ibd.getAllCategoryBaseData());
                                            instance.budgetDAO().insertAll(ibd.getAllBudgetBaseData());
                                            instance.userDAO().insert(ibd.getDefaultUser());
                                            instance.accountSettingsDAO().insert(ibd.getAcctSettings());
                                        }
                                    });
                                }
                            })
                            .build();
                    // .allowMainThreadQueries()
                }
            }
        }

        return instance;

    }

    public static void destroyInstance(){
        instance = null;
    }

    public abstract AccountSettingsDao accountSettingsDAO();
    public abstract BudgetDao budgetDAO();
    public abstract CategoryDao categoryDAO();
    public abstract ExpenseDao expenseDAO();
    public abstract UserDao userDAO();
}
