package ca.humber.echo.team.avocado.ui.fragment.ReportsAdapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import ca.humber.echo.team.avocado.R;
import ca.humber.echo.team.avocado.database.Entity.Expense;

public class ReportsAdapter extends RecyclerView.Adapter<ReportsAdapter.ReportsViewHolder> {
    class ReportsViewHolder extends RecyclerView.ViewHolder {
        private final TextView reportsItemView;

        private ReportsViewHolder(View itemView) {
            super(itemView);
            reportsItemView = itemView.findViewById(R.id.textView);
        }
    }

    private final LayoutInflater reportInflater;
    private List<Expense> tempExpenses;

    private List<String> largestExpenseName;
    private List<Double> largestExpenseValue;
    private List<String> largestEntryCategoryName;
    private List<Integer> largestEntryCategoryCount;
    private List<String> largestEntrySubCategoryName;
    private List<Integer> largestEntrySubCategoryCount;
    private List<String> largestEntryDescriptionName;
    private List<Integer> largestEntryDescriptionCount;


    ReportsAdapter(Context context) { reportInflater = LayoutInflater.from(context); }

    @Override
    public ReportsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = reportInflater.inflate(R.layout.recyclerview_item, parent, false);
        return new ReportsViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ReportsViewHolder holder, int position) {
//        if (largestExpenseName != null) {
//            String largeExpenseName = largestExpenseName.get(position);
//            holder.reportsItemView.setText(largeExpenseName.toString());
//        } else {
//            // Covers the case of data not being ready yet.
//            holder.reportsItemView.setText("No Data");
//        }

        if (largestExpenseValue != null) {
            Double largeExpenseValue = largestExpenseValue.get(position);
            holder.reportsItemView.setText(largeExpenseValue.toString());
        } else {
            // Covers the case of data not being ready yet.
            holder.reportsItemView.setText("No Data");
        }

//        if (largestEntryCategoryName != null) {
//            String largeCategoryName = largestEntryCategoryName.get(position);
//            holder.reportsItemView.setText(largeCategoryName.toString());
//        } else {
//            // Covers the case of data not being ready yet.
//            holder.reportsItemView.setText("No Data");
//        }
//
//        if (largestEntryCategoryCount != null) {
//            Integer largeCategoryCount = largestEntryCategoryCount.get(position);
//            holder.reportsItemView.setText(largeCategoryCount.toString());
//        } else {
//            // Covers the case of data not being ready yet.
//            holder.reportsItemView.setText("No Data");
//        }
//
//        if (largestEntrySubCategoryName != null) {
//            String largeSubCategoryName = largestEntrySubCategoryName.get(position);
//            holder.reportsItemView.setText(largeSubCategoryName.toString());
//        } else {
//            // Covers the case of data not being ready yet.
//            holder.reportsItemView.setText("No Data");
//        }
//
//        if (largestEntrySubCategoryCount != null) {
//            Integer largeSubCategoryCount = largestEntrySubCategoryCount.get(position);
//            holder.reportsItemView.setText(largeSubCategoryCount.toString());
//        } else {
//            // Covers the case of data not being ready yet.
//            holder.reportsItemView.setText("No Data");
//        }
//
//        if (largestEntryDescriptionName != null) {
//            String largeDescriptionName = largestEntryDescriptionName.get(position);
//            holder.reportsItemView.setText(largeDescriptionName.toString());
//        } else {
//            // Covers the case of data not being ready yet.
//            holder.reportsItemView.setText("No Data");
//        }
//
//        if (largestEntryDescriptionCount != null) {
//            Integer largeDescriptionCount = largestEntryDescriptionCount.get(position);
//            holder.reportsItemView.setText(largeDescriptionCount.toString());
//        } else {
//            // Covers the case of data not being ready yet.
//            holder.reportsItemView.setText("No Data");
//        }
    }

//    void setExpenses(List<Expense> expense){
//        tempExpenses = expense;
//        notifyDataSetChanged();
//    }
//
//    void setLargestExpenseName(List<String> expenseName){
//        largestExpenseName = expenseName;
//        notifyDataSetChanged();
//    }

    public void setLargestExpenseValue(List<Double> expenseValue){
        largestExpenseValue = expenseValue;
        notifyDataSetChanged();
    }

//    void setLargestEntryCategoryName(List<String> expenseCategory){
//        largestEntryCategoryName = expenseCategory;
//        notifyDataSetChanged();
//    }
//
//    void setLargestEntryCategoryCount(List<Integer> categoryCount){
//        largestEntryCategoryCount = categoryCount;
//        notifyDataSetChanged();
//    }
//
//    void setLargestEntrySubCategoryName(List<String> expenseSubCategory){
//        largestEntrySubCategoryName = expenseSubCategory;
//        notifyDataSetChanged();
//    }
//
//    void setlargestEntrySubCategoryCount(List<Integer> subCategoryCount){
//        largestEntrySubCategoryCount = subCategoryCount;
//        notifyDataSetChanged();
//    }
//
//    void setLargestEntryDescriptionName(List<String> descriptionName){
//        largestEntryDescriptionName = descriptionName;
//        notifyDataSetChanged();
//    }
//
//    void setLargestEntryDescriptionCount(List<Integer> descriptionCount){
//        largestEntryDescriptionCount = descriptionCount;
//        notifyDataSetChanged();
//    }

    @Override
    public int getItemCount() {
        if (largestExpenseValue != null)
            return largestExpenseValue.size();
        else return 0;
    }

}