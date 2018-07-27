package ca.humber.echo.team.avocado.ui.fragment.ReportsAdapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import ca.humber.echo.team.avocado.R;

public class LargeSubCategoryNameAdapter extends RecyclerView.Adapter<LargeSubCategoryNameAdapter.LargeSubCategoryNameViewHolder> {
    class LargeSubCategoryNameViewHolder extends RecyclerView.ViewHolder {
        private final TextView reportsItemView;

        private LargeSubCategoryNameViewHolder(View itemView) {
            super(itemView);
            reportsItemView = itemView.findViewById(R.id.textView);
        }
    }

    private final LayoutInflater reportInflater;

    private List<String> largestSubCategoryName;

    public LargeSubCategoryNameAdapter(Context context) { reportInflater = LayoutInflater.from(context); }

    @Override
    public LargeSubCategoryNameViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = reportInflater.inflate(R.layout.recyclerview_item, parent, false);
        return new LargeSubCategoryNameViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(LargeSubCategoryNameViewHolder holder, int position) {
        if (largestSubCategoryName != null) {
            String largeSubCategoryName = largestSubCategoryName.get(position);
            holder.reportsItemView.setText(largeSubCategoryName.toString());
        } else {
            // Covers the case of data not being ready yet.
            holder.reportsItemView.setText("No Data");
        }
    }

    public void setLargestSubCategoryName(List<String> expenseName){
        largestSubCategoryName = expenseName;
        notifyDataSetChanged();
    }


    @Override
    public int getItemCount() {
        if (largestSubCategoryName != null)
            return largestSubCategoryName.size();
        else return 0;
    }

}