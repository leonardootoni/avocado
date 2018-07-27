package ca.humber.echo.team.avocado.ui.fragment.ReportsAdapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import ca.humber.echo.team.avocado.R;

public class LargeSubCategoryCountAdapter extends RecyclerView.Adapter<LargeSubCategoryCountAdapter.LargeSubCategoryCountViewHolder> {
    class LargeSubCategoryCountViewHolder extends RecyclerView.ViewHolder {
        private final TextView reportsItemView;

        private LargeSubCategoryCountViewHolder(View itemView) {
            super(itemView);
            reportsItemView = itemView.findViewById(R.id.textView);
        }
    }

    private final LayoutInflater reportInflater;

    private List<Integer> largestSubCategoryCount;

    public LargeSubCategoryCountAdapter(Context context) { reportInflater = LayoutInflater.from(context); }

    @Override
    public LargeSubCategoryCountViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = reportInflater.inflate(R.layout.recyclerview_item, parent, false);
        return new LargeSubCategoryCountViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(LargeSubCategoryCountViewHolder holder, int position) {
        if (largestSubCategoryCount != null) {
            Integer largeSubCategoryCount = largestSubCategoryCount.get(position);
            holder.reportsItemView.setText(largeSubCategoryCount.toString());
        } else {
            // Covers the case of data not being ready yet.
            holder.reportsItemView.setText("No Data");
        }


    }

    public void setLargestSubCategoryCount(List<Integer> expenseName){
        largestSubCategoryCount = expenseName;
        notifyDataSetChanged();
    }


    @Override
    public int getItemCount() {
        if (largestSubCategoryCount != null)
            return largestSubCategoryCount.size();
        else return 0;
    }

}