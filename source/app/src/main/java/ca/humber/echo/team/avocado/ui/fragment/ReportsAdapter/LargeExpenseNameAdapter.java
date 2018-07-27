package ca.humber.echo.team.avocado.ui.fragment.ReportsAdapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import ca.humber.echo.team.avocado.R;

public class LargeExpenseNameAdapter extends RecyclerView.Adapter<LargeExpenseNameAdapter.LargeExpenseNameViewHolder> {
    class LargeExpenseNameViewHolder extends RecyclerView.ViewHolder {
        private final TextView reportsItemView;

        private LargeExpenseNameViewHolder(View itemView) {
            super(itemView);
            reportsItemView = itemView.findViewById(R.id.textView);
        }
    }

    private final LayoutInflater reportInflater;

    private List<String> largestExpenseName;

    public LargeExpenseNameAdapter(Context context) { reportInflater = LayoutInflater.from(context); }

    @Override
    public LargeExpenseNameViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = reportInflater.inflate(R.layout.recyclerview_item, parent, false);
        return new LargeExpenseNameViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(LargeExpenseNameViewHolder holder, int position) {
        if (largestExpenseName != null) {
            String largeExpenseName = largestExpenseName.get(position);
            holder.reportsItemView.setText(largeExpenseName.toString());
        } else {
            // Covers the case of data not being ready yet.
            holder.reportsItemView.setText("No Data");
        }


    }

    public void setLargestExpenseName(List<String> expenseName){
        largestExpenseName = expenseName;
        notifyDataSetChanged();
    }


    @Override
    public int getItemCount() {
        if (largestExpenseName != null)
            return largestExpenseName.size();
        else return 0;
    }

}