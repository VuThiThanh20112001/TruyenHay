package com.vuthanh.truyenhay.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.vuthanh.truyenhay.Model.Selected;
import com.vuthanh.truyenhay.R;

import java.util.List;

public class SelectedAdapter extends ArrayAdapter<Selected> {

    public SelectedAdapter(@NonNull Context context, int resource, @NonNull List<Selected> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_selected,parent,false);
        TextView tv_selected = convertView.findViewById(R.id.tv_selected);

        Selected selected = this.getItem(position);
        if(selected != null){
            tv_selected.setText(selected.getPhanquyen());
        }
        return convertView;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_phanquyen,parent,false);
        TextView tv_phanquyen = convertView.findViewById(R.id.tv_phanquyen);

        Selected selected = this.getItem(position);
        if(selected != null){
            tv_phanquyen.setText(selected.getPhanquyen());
        }
        return convertView;
    }
}
