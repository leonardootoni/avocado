package ca.humber.echo.team.avocado.ui.fragment.ReportsAdapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import ca.humber.echo.team.avocado.R;

public class LargeCategoryNameAdapter extends RecyclerView.Adapter<LargeCategoryNameAdapter.LargeCategoryNameViewHolder> {
    class LargeCategoryNameViewHolder extends RecyclerView.ViewHolder {
        private final TextView reportsItemView;

        private LargeCategoryNameViewHolder(View itemView) {
            super(itemView);
            reportsItemView = itemView.findViewById(R.id.textView);
        }
    }

    private final LayoutInflater reportInflater;

    private List<String> largestCategoryName;

    public LargeCategoryNameAdapter(Context context) { reportInflater = LayoutInflater.from(context); }

    @Override
    public LargeCategoryNameViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = reportInflater.inflate(R.layout.recyclerview_item, parent, false);
        return new LargeCategoryNameViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(LargeCategoryNameViewHolder holder, int position) {
        if (largestCategoryName != null) {
            String largeCategoryName = largestCategoryName.get(position);
            holder.reportsItemView.setText(largeCategoryName.toString());
        } else {
            // Covers the case of data not being ready yet.
            holder.reportsItemView.setText("No Data");
        }


    }

    public void setLargestCategoryName(List<String> expenseName){
        largestCategoryName = expenseName;
        notifyDataSetChanged();
    }


    @Override
    public int getItemCount() {
        if (largestCategoryName != null)
            return largestCategoryName.size();
        else return 0;
    }

}