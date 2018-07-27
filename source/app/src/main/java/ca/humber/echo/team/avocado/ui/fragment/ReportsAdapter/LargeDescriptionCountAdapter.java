package ca.humber.echo.team.avocado.ui.fragment.ReportsAdapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import ca.humber.echo.team.avocado.R;

public class LargeDescriptionCountAdapter extends RecyclerView.Adapter<LargeDescriptionCountAdapter.LargeDescriptionCountViewHolder> {
    class LargeDescriptionCountViewHolder extends RecyclerView.ViewHolder {
        private final TextView reportsItemView;

        private LargeDescriptionCountViewHolder(View itemView) {
            super(itemView);
            reportsItemView = itemView.findViewById(R.id.textView);
        }
    }

    private final LayoutInflater reportInflater;

    private List<Integer> largestDescriptionCount;

    public LargeDescriptionCountAdapter(Context context) { reportInflater = LayoutInflater.from(context); }

    @Override
    public LargeDescriptionCountViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = reportInflater.inflate(R.layout.recyclerview_item, parent, false);
        return new LargeDescriptionCountViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(LargeDescriptionCountViewHolder holder, int position) {
        if (largestDescriptionCount != null) {
            Integer largeDescriptionCount = largestDescriptionCount.get(position);
            holder.reportsItemView.setText(largeDescriptionCount.toString());
        } else {
            // Covers the case of data not being ready yet.
            holder.reportsItemView.setText("No Data");
        }
    }

    public void setLargestDescriptionCount(List<Integer> categoryCount){
        largestDescriptionCount = categoryCount;
        notifyDataSetChanged();
    }


    @Override
    public int getItemCount() {
        if (largestDescriptionCount != null)
            return largestDescriptionCount.size();
        else return 0;
    }
}