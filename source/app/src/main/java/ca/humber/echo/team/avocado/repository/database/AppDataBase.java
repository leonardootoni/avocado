package ca.humber.echo.team.avocado.repository.database;

import android.arch.persistence.room.Database;

import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;
import ca.humber.echo.team.avocado.repository.dao.AccountSettingsDAO;
import ca.humber.echo.team.avocado.repository.dao.BudgetDAO;
import ca.humber.echo.team.avocado.repository.dao.CategoryDAO;
import ca.humber.echo.team.avocado.repository.dao.ExpenseDAO;
import ca.humber.echo.team.avocado.repository.dao.UserDAO;
import ca.humber.echo.team.avocado.repository.model.AccountSettings;
import ca.humber.echo.team.avocado.repository.model.Budget;
import ca.humber.echo.team.avocado.repository.model.Category;
import ca.humber.echo.team.avocado.repository.model.Expense;
import ca.humber.echo.team.avocado.repository.model.User;
import ca.humber.echo.team.avocado.utils.Converter;

/***
 * Main app's database class definition.
 */
@Database(entities = {  AccountSettings.class,
                        Budget.class,
                        Category.class,
                        Expense.class,
                        User.class},
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
                            .allowMainThreadQueries()
                            .build();
                }
            }
        }

        return instance;

    }

    public static void destroyInstance(){
        instance = null;
    }

    public abstract AccountSettingsDAO accountSettingsDAO();
    public abstract BudgetDAO budgetDAO();
    public abstract CategoryDAO categoryDAO();
    public abstract ExpenseDAO expenseDAO();
    public abstract UserDAO userDAO();
}
