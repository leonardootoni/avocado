package ca.humber.echo.team.avocado.ui.fragment.ReportsAdapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import ca.humber.echo.team.avocado.R;

public class LargeExpenseValueAdapter extends RecyclerView.Adapter<LargeExpenseValueAdapter.LargeExpenseValueViewHolder> {
    class LargeExpenseValueViewHolder extends RecyclerView.ViewHolder {
        private final TextView reportsItemView;

        private LargeExpenseValueViewHolder(View itemView) {
            super(itemView);
            reportsItemView = itemView.findViewById(R.id.textView);
        }
    }

    private final LayoutInflater reportInflater;

    private List<Double> largestExpenseValue;

    public LargeExpenseValueAdapter(Context context) { reportInflater = LayoutInflater.from(context); }

    @Override
    public LargeExpenseValueViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = reportInflater.inflate(R.layout.recyclerview_item, parent, false);
        return new LargeExpenseValueViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(LargeExpenseValueViewHolder holder, int position) {
        if (largestExpenseValue != null) {
            Double largeExpenseValue = largestExpenseValue.get(position);
            holder.reportsItemView.setText(largeExpenseValue.toString());
        } else {
            // Covers the case of data not being ready yet.
            holder.reportsItemView.setText("No Data");
        }


    }

    public void setLargestExpenseValue(List<Double> expenseValue){
        largestExpenseValue = expenseValue;
        notifyDataSetChanged();
    }


    @Override
    public int getItemCount() {
        if (largestExpenseValue != null)
            return largestExpenseValue.size();
        else return 0;
    }

}