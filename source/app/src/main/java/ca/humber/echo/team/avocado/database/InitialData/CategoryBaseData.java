package ca.humber.echo.team.avocado.database.InitialData;

import java.util.ArrayList;
import java.util.List;

import ca.humber.echo.team.avocado.database.Entity.Category;

/**
 * Base data to set after the dataBase creation
 * This class must be used only on the first time.
 * @author leonardootoni
 */
public class CategoryBaseData {

    private List<Category> categories = new ArrayList<>();

    public CategoryBaseData(){
        createBaseCategories();
    }

    public List<Category> getAllCategoryBaseData(){
        return categories;
    }

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


}
