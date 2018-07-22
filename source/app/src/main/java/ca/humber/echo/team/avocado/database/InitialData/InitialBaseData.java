package ca.humber.echo.team.avocado.database.InitialData;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import ca.humber.echo.team.avocado.database.Entity.AccountSettings;
import ca.humber.echo.team.avocado.database.Entity.Budget;
import ca.humber.echo.team.avocado.database.Entity.Category;
import ca.humber.echo.team.avocado.database.Entity.User;

/**
 * Base data to set after the dataBase creation
 * This class must be used only at the first time (database creation event).
 * @author leonardootoni
 */
public class InitialBaseData {

    private List<Category> categories = new ArrayList<>();
    private List<Budget> budgetList = new ArrayList<>();
    private User defaultUser;
    private AccountSettings acctSettings;

    public InitialBaseData(){

        createBaseCategories();
        createBaseBudget();

        defaultUser = defaultUser =  new User(null,
                "Luke",
                "Skywalker",
                "luke@starwars.com");

        acctSettings = new AccountSettings(null,
                new Long(1),
                new Double(75.00),
                new Long(1),
                new Long (2));

    }

    public List<Category> getAllCategoryBaseData(){
        return categories;
    }
    public List<Budget> getAllBudgetBaseData() { return budgetList; }
    public User getDefaultUser() { return defaultUser; }
    public AccountSettings getAcctSettings() { return acctSettings; }


    private void createBaseCategories() {

        categories.add(new Category("Dwelling", null));
        categories.add(new Category("Recreation", null));
        categories.add(new Category("Food", null));

        //Dwelling
        categories.add(new Category("Mortgage", new Long(1) ));
        categories.add(new Category("Rental", new Long(1) ));
        categories.add(new Category("Hydro", new Long(1)  ));
        categories.add(new Category("Water", new Long(1) ));
        categories.add(new Category("Condominium Fee", new Long(1) ));

        //Recreation
        categories.add(new Category("Movie Theater", new Long(2) ));
        categories.add(new Category("Amusement Park", new Long(2)  ));
        categories.add(new Category("Pub", new Long(2) ));

        //Food
        categories.add(new Category("Restaurant", new Long(3) ));
        categories.add(new Category("Supermarket", new Long(3) ));
        categories.add(new Category("Grocery Store", new Long(3)  ));
        categories.add(new Category("Butchery", new Long(3)  ));

    }

    private void createBaseBudget() {

        //Dwelling budget
        budgetList.add(new Budget(null, new Double(1500.00), new Long(1)));

        //Recreation budget
        budgetList.add(new Budget(null, new Double(1500.00), new Long(2)));

        //Food budget
        budgetList.add(new Budget(null, new Double(1500.00), new Long(3)));

    }





}
