package ca.humber.echo.team.avocado.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;

import ca.humber.echo.team.avocado.database.Entity.Expense;
import ca.humber.echo.team.avocado.repository.ExpenseRepository;

/**
 * class is designed to store and manage UI-related data in a lifecycle conscious way.
 * The ViewModel class allows data to survive configuration changes such as screen rotations.
 *
 * More at:
 * https://codelabs.developers.google.com/codelabs/android-room-with-a-view/#8
 * https://developer.android.com/topic/libraries/architecture/viewmodel
 *
 * @author leonardootoni
 */
public class ExpenseViewModel extends AndroidViewModel{

    private ExpenseRepository expenseRepository;

    public ExpenseViewModel(Application application){
        super(application);
        expenseRepository = new ExpenseRepository(application);
    }

    public void insert(Expense expense){
        expenseRepository.insert(expense);
    }

}
