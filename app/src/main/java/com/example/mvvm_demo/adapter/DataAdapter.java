package com.example.mvvm_demo.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvvm_demo.R;
import com.example.mvvm_demo.model.DataItem;

import java.util.ArrayList;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.myViewHolder> {

    ArrayList<DataItem> itemList = new ArrayList<>();

    public void setItemList(ArrayList<DataItem> itemList) {
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public DataAdapter.myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.row_item_data,parent,false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DataAdapter.myViewHolder holder, int position) {
        holder.tvData.setText(itemList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public static class myViewHolder extends RecyclerView.ViewHolder {

        TextView tvData;
        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            tvData = itemView.findViewById(R.id.tvItemData);
        }
    }
}
