package ca.humber.echo.team.avocado.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import java.util.List;

import ca.humber.echo.team.avocado.database.Entity.Expense;
import ca.humber.echo.team.avocado.repository.ReportsRepository;

public class ReportsViewModel extends AndroidViewModel {
    private ReportsRepository reportsRepository;

    private LiveData<List<Expense>> expenses;
    private LiveData<List<String>> largestExpenseName;
    private LiveData<List<Double>> largestExpenseValue;
    private LiveData<List<String>> largestEntryCategoryName;
    private LiveData<List<Integer>> largestEntryCategoryCount;
    private LiveData<List<String>> largestEntrySubCategoryName;
    private LiveData<List<Integer>> largestEntrySubCategoryCount;
    private LiveData<List<String>> largestEntryDescriptionName;
    private LiveData<List<Integer>> largestEntryDescriptionCount;

    public ReportsViewModel (Application application) {
        super(application);
        reportsRepository = new ReportsRepository(application);
        expenses = reportsRepository.getAllExpenses();
        largestExpenseName = reportsRepository.getLargestExpenseName();
        largestExpenseValue = reportsRepository.getLargestExpenseValue();
        largestEntryCategoryName = reportsRepository.getLargestEntryCategoryName();
        largestEntryCategoryCount = reportsRepository.getLargestEntryCategoryCount();
        largestEntrySubCategoryName = reportsRepository.getLargestEntrySubCategoryName();
        largestEntrySubCategoryCount = reportsRepository.getLargestEntrySubCategoryCount();
        largestEntryDescriptionName = reportsRepository.getLargestEntryDescriptionName();
        largestEntryDescriptionCount = reportsRepository.getLargestEntryDescriptionCount();
    }

    public LiveData<List<Expense>> getAllExpenses() {
        return expenses;
    }
    public LiveData<List<String>> getLargestExpenseName() {
        return largestExpenseName;
    }
    public LiveData<List<Double>> getLargestExpenseValue() {
        return largestExpenseValue;
    }
    public LiveData<List<String>> getLargestEntryCategoryName() { return largestEntryCategoryName; }
    public LiveData<List<Integer>> getLargestEntryCategoryCount() { return largestEntryCategoryCount; }
    public LiveData<List<String>> getLargestEntrySubCategoryName() { return largestEntrySubCategoryName; }
    public LiveData<List<Integer>> getLargestEntrySubCategoryCount() { return largestEntrySubCategoryCount; }
    public LiveData<List<String>> getLargestEntryDescriptionName() { return largestEntryDescriptionName; }
    public LiveData<List<Integer>> getLargestEntryDescriptionCount() { return largestEntryDescriptionCount; }

    public void insert(Expense expense) {
        reportsRepository.insert(expense);
    }
}
