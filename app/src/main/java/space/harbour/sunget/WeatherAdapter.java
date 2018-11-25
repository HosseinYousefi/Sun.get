package space.harbour.sunget;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

/**
 * Public class WeatherAdapter extends the RecyclerView
 * enabling an UI with smooth scrolling.
 * This class loads the data which will be displayed
 * in the UI to the user.
 */
public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.ViewHolder> {
    private List<Weather> dataSet = Collections.emptyList();
    Context context;

    public WeatherAdapter(Context context) {
        this.context = context;
    }

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
        public TextView codeTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cityTextView = itemView.findViewById(R.id.city);
            tempTextView = itemView.findViewById(R.id.temp);
            codeTextView = itemView.findViewById(R.id.code);
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
        String propertyName = "wi_yahoo_" + dataSet.get(position).item.condition.code;
        String codeText = context.getResources().getString(context.getResources().getIdentifier(propertyName, "string", context.getPackageName()));
        holder.codeTextView.setText(codeText);
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

}
