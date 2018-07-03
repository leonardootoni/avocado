package ca.humber.echo.team.avocado.ui.activity;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

import ca.humber.echo.team.avocado.R;
import ca.humber.echo.team.avocado.database.Entity.Category;
import ca.humber.echo.team.avocado.database.Entity.User;
import ca.humber.echo.team.avocado.repository.ExpenseRepository;
import ca.humber.echo.team.avocado.viewmodel.ExpenseViewModel;

/**
 * ExpensesEntry Activity Class
 * @author leonardootoni
 */
public class ExpenseEntryActivity extends AppCompatActivity {

    Class mainActivity = MainActivity.class; //Defines the main activity to redirect

    EditText editTextValue;
    Spinner spinnerCategory;
    Spinner spinnerSubCategory;
    EditText editTextDate;
    EditText editTextDescription;
    Button buttonCancel;
    Button buttonSave;

    ExpenseViewModel evm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expense_entry);

        setUIComponents();

        //Gets the ViewModel using Android Architecture Classes
        evm = ViewModelProviders.of(this).get(ExpenseViewModel.class);

        try{
            LiveData<List<Category>> categories = evm.getAllCategories();

            ExpenseRepository rep = new ExpenseRepository(getApplication());
            //LiveData<List<Category>> list = rep.getAllCategories();
            User user = new User("Leo", "Otoni", "leo@google.com");
            evm.insert(user);
        } catch(Exception ex){
            String a = ex.getMessage();
        }

    }

    /**
     * Set all UI Components and define the listener handlers.
     */
    private void setUIComponents() {

        editTextValue = findViewById(R.id.editTextValue);
        spinnerCategory = findViewById(R.id.spinnerCategory);
        spinnerSubCategory = findViewById(R.id.spinnerSubcategory);
        editTextDate = findViewById(R.id.editTextDate);
        editTextDescription = findViewById(R.id.editTextDescription);

        buttonCancel = findViewById(R.id.buttonCancel);
        buttonCancel.setOnClickListener( (View view) -> {
            returnToMainActivity();
        });

        buttonSave = findViewById(R.id.buttonSave);
        buttonSave.setOnClickListener( (View view) -> {

            try{
                Toast.makeText(getApplicationContext(), R.string.exp_entry_success_saving_msg, Toast.LENGTH_SHORT).show();
                returnToMainActivity();
            }catch (Exception ex){
                Toast.makeText(getApplicationContext(), R.string.exp_entry_error_saving_msg, Toast.LENGTH_SHORT).show();
            }

        });
    }

    /**
     * Generic entry point to redirect to the main activity
     */
    private void returnToMainActivity(){
        Intent intent = new Intent(getApplicationContext(), mainActivity);
        startActivity(intent);
    }
}
