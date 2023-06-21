package com.vuthanh.truyenhay.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.vuthanh.truyenhay.Model.Truyen;
import com.vuthanh.truyenhay.Model.TruyenTC;
import com.vuthanh.truyenhay.R;

import java.util.ArrayList;
import java.util.List;

public class TruyenAdapter extends BaseAdapter {

    private Context context;
    private List<Truyen> listTruyen;

    public TruyenAdapter(Context context, List<Truyen> listTruyen) {
        this.context = context;
        this.listTruyen = listTruyen;
    }

    @Override
    public int getCount() {
        return listTruyen.size();
    }

    @Override
    public Object getItem(int position) {
        return listTruyen.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public void filterList(ArrayList<Truyen> filteredlist) {
        listTruyen = filteredlist;
        notifyDataSetChanged();
    }

    public class ViewHolder{
        TextView txtTenTruyen;
        ImageView imgtruyen;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        viewHolder = new ViewHolder();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.list_truyen, null);

        viewHolder.txtTenTruyen = convertView.findViewById(R.id.txttruyen);
        viewHolder.imgtruyen = convertView.findViewById(R.id.imgtruyen);
        convertView.setTag(viewHolder);

        Truyen truyen = listTruyen.get(position);
        viewHolder.txtTenTruyen.setText(truyen.getTieude());
       // viewHolder.imgtruyen.setImageResource(truyen.getHinh());

        return convertView;
    }

}
