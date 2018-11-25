package space.harbour.sunget;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.ViewHolder> {
    private List<Weather> dataSet = Collections.emptyList();

    public WeatherAdapter() { }

    public void setData(List<Weather> dataSet) {
        if (dataSet == null) {
            dataSet = Collections.emptyList();
        }
        this.dataSet = dataSet;
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView cityTextView;
        public TextView tempTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cityTextView = itemView.findViewById(R.id.city);
            tempTextView = itemView.findViewById(R.id.temp);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.weather_element, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.cityTextView.setText(dataSet.get(position).location.city);
        holder.tempTextView.setText(dataSet.get(position).item.condition.temp);
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

}
