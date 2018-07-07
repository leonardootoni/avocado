package ca.humber.echo.team.avocado.ui.activity;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import ca.humber.echo.team.avocado.R;
import ca.humber.echo.team.avocado.database.Entity.Category;
import ca.humber.echo.team.avocado.database.Entity.Expense;
import ca.humber.echo.team.avocado.interfaces.IDatePickerDialogSelectedDate;
import ca.humber.echo.team.avocado.ui.fragment.DatePickerDialogFragment;
import ca.humber.echo.team.avocado.viewmodel.ExpenseViewModel;

/**
 * ExpensesEntry Activity Class
 * @author leonardootoni
 */
public class ExpenseEntryActivity extends AppCompatActivity
        implements IDatePickerDialogSelectedDate {

    Class mainActivity = MainActivity.class; //Defines the main activity to redirect
    ExpenseViewModel viewModel; //Defines the ViewModel Class to retrieve data.

    EditText editTextValue;
    EditText editTextDescription;
    Spinner spinnerCategory;
    Spinner spinnerSubCategory;
    TextView textViewCurrentDate;
    Button buttonCancel;
    Button buttonSave;

    Date expenseDate; //used to validate the User date selection

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expense_entry);

        //Bind the Activity to the ViewModel class
        viewModel = ViewModelProviders.of(this).get(ExpenseViewModel.class);
        expenseDate = Calendar.getInstance().getTime();
        setUIComponents();
        defineObservers();

    }

    /**
     * Define observers, according to the ViewModel Android Architecture Component, to populate
     * the spinners with Category and SubCategory Data.
     */
    private void defineObservers() {


        //Bind the CategoryList object to the CategorySpinner
        viewModel.getCategoryList().observe(this, new Observer<List<Category>>() {
            @Override
            public void onChanged(@NonNull final List<Category> categoryList) {
                loadCategorySpinner(categoryList);
            }
        });

        //Bind the subCategoryList object to the subCategorySpinner
        viewModel.getSubCategoryList().observe(this, new Observer<List<Category>>() {
            @Override
            public void onChanged(@Nullable List<Category> subCategoryList) {
                loadSubCategorySpinner(subCategoryList);
            }
        });


        //Forces to uodate the subCategories according to the selected category
        spinnerCategory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                List<Category> subCategoryList = viewModel.getSubCategoryList().getValue();
                loadSubCategorySpinner(subCategoryList);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    /**
     * Load into the subCategory spinner all subcategories that refer to the main category.
     * @param subCategoryList
     */
    private void loadSubCategorySpinner(List<Category> subCategoryList) {

        if(spinnerCategory.getSelectedItem() != null){
            Category category = (Category) spinnerCategory.getSelectedItem();

            List<Category> filteredSubCategoryList = new ArrayList<>();
            for ( Category subCategory: subCategoryList ) {
                if(subCategory.getReferenceId().equals(category.getId())){
                    filteredSubCategoryList.add(subCategory);
                }
            }

            spinnerSubCategory.setAdapter(new ArrayAdapter<>(
                    this,
                    R.layout.spinner_item, //custom layout
                    filteredSubCategoryList
            ));
        }
    }

    /**
     * Load into the Category Spinner, all categories provided by the ViewModel
     * @param categoryList
     */
    private void loadCategorySpinner(List<Category> categoryList) {

        spinnerCategory.setAdapter(new ArrayAdapter<>(
                this,
                R.layout.spinner_item, //custom layout
                categoryList
        ));

    }

    /**
     * Set all UI Components and define the listener handlers.
     * Method called by the OnCreate event
     */
    private void setUIComponents() {

        editTextValue = findViewById(R.id.editTextValue);

        spinnerCategory = findViewById(R.id.spinnerCategory);
        spinnerSubCategory = findViewById(R.id.spinnerSubcategory);

        textViewCurrentDate = findViewById(R.id.textViewCurrentDate);
        textViewCurrentDate.setText(formatDateToText(new Date()));
        textViewCurrentDate.setOnClickListener((View view) ->{
            showDatePicker();
        });

        editTextDescription = findViewById(R.id.editTextDescription);

        buttonCancel = findViewById(R.id.buttonCancel);
        buttonCancel.setOnClickListener( (View view) -> {
            returnToMainActivity();
        });

        buttonSave = findViewById(R.id.buttonSave);
        buttonSave.setOnClickListener( (View view) -> {

            if(isValidExpenseEntry()) {
                saveExpense();
                Toast.makeText(getApplicationContext(),
                        R.string.exp_entry_success_saving_msg,
                        Toast.LENGTH_SHORT).show();

                returnToMainActivity();
                returnToMainActivity();
            }
        });
    }

    /**
     * Create an Expense object and pass it to the ViewModel class to save it into the database.
     */
    private void saveExpense() {
        Expense expense = new Expense(null,
                    Double.parseDouble(editTextValue.getText().toString()),
                    editTextDescription.getText().toString(),
                    expenseDate,
                    ((Category)spinnerCategory.getSelectedItem()).getId(),
                    ((Category)spinnerSubCategory.getSelectedItem()).getId()

                );

        viewModel.insert(expense);
    }

    /**
     * Performs the form validation and shows a dialog message in case of inconsistencies.
     * @return
     */
    private boolean isValidExpenseEntry(){


        String message = "";
        if(expenseDate.getTime() > Calendar.getInstance().getTime().getTime()){
            message += getResources().getString(R.string.exp_entry_dialog_date_message) + "\n";
        }

        Double expenseValue;
        try{
            expenseValue = Double.parseDouble(editTextValue.getText().toString());
        }catch (NumberFormatException ex){
            expenseValue = null;
        }

        if(editTextValue.getText().toString().isEmpty()  ||
                expenseValue == null ||
                expenseValue <= 0){
            message += getResources().getString(R.string.exp_entry_dialog_value_message) + "\n";
        }


        if(editTextDescription.getText().toString().trim().isEmpty()){
            message += getResources().getString(R.string.exp_entry_dialog_description_message) + "\n";
        }

        if(!message.isEmpty()){
            AlertDialog alertDialog = new AlertDialog.Builder(this).create();
            alertDialog.setTitle(R.string.exp_entry_dialog_title);
            alertDialog.setMessage(message);
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL,
                    getResources().getString(R.string.exp_entry_dialog_ok_button),
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            alertDialog.show();
            return false;
        }else{
            return true;
        }

    }

    /**
     * Exhibit a datePicker Calendar Fragment (popup)
     */
    private void showDatePicker() {
        DatePickerDialogFragment newFragment = new DatePickerDialogFragment();
        newFragment.show(getSupportFragmentManager(), "date picker");
    }

    /**
     * Generic entry point to redirect to the main activity
     */
    private void returnToMainActivity(){
        Intent intent = new Intent(getApplicationContext(), mainActivity);
        startActivity(intent);
    }

    /**
     * Format a given date into a text String following the format:
     * 2018, Tue, July 15
     * @param date
     * @return
     */
    public String formatDateToText(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy, EEE, MMMM dd");
        return sdf.format(date);
    }

    /**
     * Implementation of the DatePickerDialogFragment interface.
     * Method used to receive data from the fragment.
     * @param date
     */
    @Override
    public void onSelectedDate(Date date) {
        textViewCurrentDate.setText(formatDateToText(date));
        expenseDate = date;
    }

}
