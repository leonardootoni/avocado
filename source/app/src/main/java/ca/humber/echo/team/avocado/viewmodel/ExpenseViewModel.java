package ca.humber.echo.team.avocado.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import java.util.List;

import ca.humber.echo.team.avocado.database.Entity.Category;
import ca.humber.echo.team.avocado.database.Entity.Expense;
import ca.humber.echo.team.avocado.database.Entity.User;
import ca.humber.echo.team.avocado.repository.ExpenseRepository;
import ca.humber.echo.team.avocado.repository.UserRepository;

/**
 * This class is designed to get and manage UI-related data in a lifecycle conscious way.
 * The ViewModel class allows data to survive configuration changes such as screen rotations.
 *
 * More at:
 * https://codelabs.developers.google.com/codelabs/android-room-with-a-view/#8
 * https://developer.android.com/topic/libraries/architecture/viewmodel
 *
 * @author leonardootoni
 */
public class ExpenseViewModel extends AndroidViewModel{


    private LiveData<List<Category>> categoryList;
    private LiveData<List<Category>> subCategoryList;

    private ExpenseRepository expenseRepository;

    public ExpenseViewModel(Application application){
        super(application);

        //UserRepository ur = new UserRepository(application);
        //ur.insert(new User("Leo", "otoni", "l@gmail.com"));

        expenseRepository = new ExpenseRepository(application);
        categoryList = expenseRepository.getAllCategories();
        subCategoryList = expenseRepository.getAllSubCategories();

    }

    /**
     * Insert an expense into the database
     * @param expense - The Expense object from the form
     */
    public void insert(Expense expense){
        expenseRepository.insert(expense);
    }

    public void insert(User user) { new UserRepository(getApplication()).insert(user);}

    /**
     * Provide a category list object
     * @return - A LiveData Category List that will be observable
     */
    public LiveData<List<Category>> getCategoryList(){
        return categoryList;
    }

    /**
     * Provide a sub-category list object
     * @return - A LiveData Sub-Category List that will be observable
     */
    public LiveData<List<Category>> getSubCategoryList( ){
        return subCategoryList;
    }

}
