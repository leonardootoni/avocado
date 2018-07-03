package ca.humber.echo.team.avocado.database;

import android.arch.persistence.room.Database;

import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;

import ca.humber.echo.team.avocado.database.utils.Converter;
import ca.humber.echo.team.avocado.database.dao.AccountSettingsDAO;
import ca.humber.echo.team.avocado.database.dao.BudgetDAO;
import ca.humber.echo.team.avocado.database.dao.CategoryDAO;
import ca.humber.echo.team.avocado.database.dao.ExpenseDAO;
import ca.humber.echo.team.avocado.database.dao.UserDAO;
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

    public abstract AccountSettingsDAO accountSettingsDAO();
    public abstract BudgetDAO budgetDAO();
    public abstract CategoryDAO categoryDAO();
    public abstract ExpenseDAO expenseDAO();
    public abstract UserDAO userDAO();
}
