package frenchdonuts.tasty.standard;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by pamelactan on 12/7/15.
 */
public class NamesItemAdapter extends RecyclerView.Adapter<NamesItemAdapter.ViewHolder> {
    FragmentTransactor fragmentTransactor;
    List<String> names;

    public NamesItemAdapter(FragmentTransactor fragmentTransactor) {
        this.fragmentTransactor = fragmentTransactor;
    }

    public void setNames(List<String> names) {
        this.names = names;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.name_item, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tvName.setText(names.get(position));

        holder.itemView.setOnClickListener((view) -> {
            fragmentTransactor.toNameFragment(names.get(position));
        });
    }

    @Override
    public int getItemCount() {
        return names == null ? 0 : names.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;

        View itemView;
        public ViewHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;
            tvName = (TextView) itemView.findViewById(R.id.tvName);
        }
    }
}
