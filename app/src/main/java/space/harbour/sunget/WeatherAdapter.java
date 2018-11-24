package space.harbour.sunget;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.RealmQuery;
import io.realm.RealmResults;

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.ViewHolder> {
    private RealmResults<Weather> dataSet;
    Realm realm;

    public WeatherAdapter() {
        realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        dataSet = realm.where(Weather.class).findAll();
        realm.commitTransaction();
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
