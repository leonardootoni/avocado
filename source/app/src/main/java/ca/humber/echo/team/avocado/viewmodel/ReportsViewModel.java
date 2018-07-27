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
    private LiveData<String> largestExpenseName;
    private LiveData<Double> largestExpenseValue;
    private LiveData<String> largestEntryCategoryName;
    private LiveData<Integer> largestEntryCategoryCount;
    private LiveData<String> largestEntrySubCategoryName;
    private LiveData<Integer> largestEntrySubCategoryCount;
    private LiveData<String> largestEntryDescriptionName;
    private LiveData<Integer> largestEntryDescriptionCount;

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
    public LiveData<String> getLargestExpenseName() {
        return largestExpenseName;
    }
    public LiveData<Double> getLargestExpenseValue() {
        return largestExpenseValue;
    }
    public LiveData<String> getLargestEntryCategoryName() { return largestEntryCategoryName; }
    public LiveData<Integer> getLargestEntryCategoryCount() {
        return largestEntryCategoryCount;
    }
    public LiveData<String> getLargestEntrySubCategoryName() {
        return largestEntrySubCategoryName;
    }
    public LiveData<Integer> getLargestEntrySubCategoryCount() { return largestEntrySubCategoryCount; }
    public LiveData<String> getLargestEntryDescriptionName() {
        return largestEntryDescriptionName;
    }
    public LiveData<Integer> getLargestEntryDescriptionCount() { return largestEntryDescriptionCount; }

    public void insert(Expense expense) {
        reportsRepository.insert(expense);
    }
}
