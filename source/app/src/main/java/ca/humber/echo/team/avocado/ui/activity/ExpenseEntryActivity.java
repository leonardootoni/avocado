package ca.humber.echo.team.avocado.ui.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import ca.humber.echo.team.avocado.R;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expense_entry);

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
