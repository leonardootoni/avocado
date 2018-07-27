package ca.humber.echo.team.avocado.ui.fragment;

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
    private List<Expense> tempExpenses; // Cached copy of words

    ReportsAdapter(Context context) { reportInflater = LayoutInflater.from(context); }

    @Override
    public ReportsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = reportInflater.inflate(R.layout.recyclerview_item, parent, false);
        return new ReportsViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ReportsViewHolder holder, int position) {
        if (tempExpenses != null) {
            Expense current = tempExpenses.get(position);
            holder.reportsItemView.setText(current.getDescription());
        } else {
            // Covers the case of data not being ready yet.
            holder.reportsItemView.setText("No Data");
        }
    }

    void setExpenses(List<Expense> expense){
        tempExpenses = expense;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if (tempExpenses != null)
            return tempExpenses.size();
        else return 0;
    }

}