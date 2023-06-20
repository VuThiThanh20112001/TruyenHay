package com.vuthanh.truyenhay.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import com.vuthanh.truyenhay.Activity.AdminActivity;
import com.vuthanh.truyenhay.Model.Admin;
import com.vuthanh.truyenhay.R;

import java.util.ArrayList;

public class AdminAdapter extends BaseAdapter {

    private AdminActivity context;
    private ArrayList<Admin> adminArrayList;

    public AdminAdapter(AdminActivity context, ArrayList<Admin> adminArrayList) {
        this.context = context;
        this.adminArrayList = adminArrayList;
    }

    @Override
    public int getCount() {
        return adminArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return adminArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        convertView = inflater.inflate(R.layout.admin, null);

        TextView txtTaiKhoan = convertView.findViewById(R.id.textviewTenTaiKhoan);

        ImageButton imgHienThi = convertView.findViewById(R.id.imghienthi);
        ImageButton imgSua = convertView.findViewById(R.id.imgsua);
        ImageButton imgXoa = convertView.findViewById(R.id.imgxoa);

        Admin admin = adminArrayList.get(position);

        txtTaiKhoan.setText(admin.getTenadmin()+"");

        int id = admin.getId();

        imgHienThi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.information(id);

            }
        });

        imgSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.update(id);


            }
        });

        imgXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.delete(id);
            }
        });
        return convertView;
    }
}
