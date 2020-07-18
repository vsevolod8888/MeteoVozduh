package com.example.meteovozduh;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import java.util.ArrayList;
import java.util.List;

public class OurAdapter extends RecyclerView.Adapter<OurAdapter.MyViewHolder> {
    private List<OnePlaceData>onePlaceDataList = new ArrayList<>();   // лист из объектов OnePlaceData(он из jsona)
    public void setItems(List<OnePlaceData>onePlaceDataList){ //о
        this.onePlaceDataList = onePlaceDataList;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.weather_list,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.textView.setText(onePlaceDataList.get(position).getAqi());
        holder.tvStation.setText(onePlaceDataList.get(position).getStation().getName());

    }


    @Override
    public int getItemCount() {
        return onePlaceDataList.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        TextView tvStation;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = (TextView)itemView.findViewById(R.id.tw1);
            tvStation = (TextView)itemView.findViewById(R.id. tw0);
        }
    }

}
