package ca.humber.echo.team.avocado.ui.fragment.ReportsAdapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import ca.humber.echo.team.avocado.R;

public class LargeCategoryCountAdapter extends RecyclerView.Adapter<LargeCategoryCountAdapter.LargeCategoryCountViewHolder> {
    class LargeCategoryCountViewHolder extends RecyclerView.ViewHolder {
        private final TextView reportsItemView;

        private LargeCategoryCountViewHolder(View itemView) {
            super(itemView);
            reportsItemView = itemView.findViewById(R.id.textView);
        }
    }

    private final LayoutInflater reportInflater;

    private List<Integer> largestCategoryCount;

    public LargeCategoryCountAdapter(Context context) { reportInflater = LayoutInflater.from(context); }

    @Override
    public LargeCategoryCountViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = reportInflater.inflate(R.layout.recyclerview_item, parent, false);
        return new LargeCategoryCountViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(LargeCategoryCountViewHolder holder, int position) {
        if (largestCategoryCount != null) {
            Integer largeCategoryCount = largestCategoryCount.get(position);
            holder.reportsItemView.setText(largeCategoryCount.toString());
        } else {
            // Covers the case of data not being ready yet.
            holder.reportsItemView.setText("No Data");
        }
    }

    public void setLargestCategoryCount(List<Integer> categoryCount){
        largestCategoryCount = categoryCount;
        notifyDataSetChanged();
    }


    @Override
    public int getItemCount() {
        if (largestCategoryCount != null)
            return largestCategoryCount.size();
        else return 0;
    }
}