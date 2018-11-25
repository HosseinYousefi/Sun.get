package space.harbour.sunget;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

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

    /**
     * Public class ViewHolder extending the
     * RecyclerView in order to support additional
     * methods below requiring the detailed weather
     * information / detailed view of each individual
     * city.
     */
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView cityTextView;
        public TextView tempTextView;
        public TextView codeTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cityTextView = itemView.findViewById(R.id.city);
            tempTextView = itemView.findViewById(R.id.temp);
            codeTextView = itemView.findViewById(R.id.code);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            if (position != RecyclerView.NO_POSITION) { // Check if an item was deleted, but the user clicked it before the UI removed it
                Weather weather = dataSet.get(position);
                Context ctx = view.getContext();
                Intent intent = new Intent(ctx, WeatherInfoActivity.class);
                intent.putExtra("city", weather.location.city);
                intent.putExtra("temp", weather.item.condition.temp);
                intent.putExtra("code", weather.item.condition.code);
                ctx.startActivity(intent);
            }
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.weather_element, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Deciding which text color to use in each weather item
    public static int getContrastColor(int colorIntValue) {
        int red = Color.red(colorIntValue);
        int green = Color.green(colorIntValue);
        int blue = Color.blue(colorIntValue);
        double lum = (((0.299 * red) + ((0.587 * green) + (0.114 * blue))));
        return lum > 186 ? 0x99000000 : 0x99FFFFFF;
    }


    /**
     * This method helps to set the right color
     * for the UI based on the weather condition
     * of the specific city.
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String colorName = "color_" + dataSet.get(position).item.condition.code;
        int color = context.getColor(context.getResources().getIdentifier(colorName, "color", context.getPackageName()));
        holder.itemView.setBackgroundColor(color);

        holder.cityTextView.setText(dataSet.get(position).location.city);
        holder.tempTextView.setText(dataSet.get(position).item.condition.temp);

        // Finding the icon for the corresponding weather status
        String propertyName = "wi_yahoo_" + dataSet.get(position).item.condition.code;
        String codeText = context.getResources().getString(context.getResources().getIdentifier(propertyName, "string", context.getPackageName()));
        holder.codeTextView.setText(codeText);

        int textColor = getContrastColor(color);

        holder.codeTextView.setTextColor(textColor);
        holder.tempTextView.setTextColor(textColor);
        holder.cityTextView.setTextColor(textColor);

    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

}
