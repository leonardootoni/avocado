package ca.humber.echo.team.avocado.ui.fragment.ReportsAdapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import ca.humber.echo.team.avocado.R;

public class LargeDescriptionNameAdapter extends RecyclerView.Adapter<LargeDescriptionNameAdapter.LargeDescriptionNameViewHolder> {
    class LargeDescriptionNameViewHolder extends RecyclerView.ViewHolder {
        private final TextView reportsItemView;

        private LargeDescriptionNameViewHolder(View itemView) {
            super(itemView);
            reportsItemView = itemView.findViewById(R.id.textView);
        }
    }

    private final LayoutInflater reportInflater;

    private List<String> largestDescriptionName;

    public LargeDescriptionNameAdapter(Context context) { reportInflater = LayoutInflater.from(context); }

    @Override
    public LargeDescriptionNameViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = reportInflater.inflate(R.layout.recyclerview_item, parent, false);
        return new LargeDescriptionNameViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(LargeDescriptionNameViewHolder holder, int position) {
        if (largestDescriptionName != null) {
            String largeDescriptionName = largestDescriptionName.get(position);
            holder.reportsItemView.setText(largeDescriptionName.toString());
        } else {
            // Covers the case of data not being ready yet.
            holder.reportsItemView.setText("No Data");
        }
    }

    public void setLargestDescriptionName(List<String> expenseName){
        largestDescriptionName = expenseName;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if (largestDescriptionName != null)
            return largestDescriptionName.size();
        else return 0;
    }
}