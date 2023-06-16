package com.vuthanh.truyenhay.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.vuthanh.truyenhay.Model.Admin;
import com.vuthanh.truyenhay.Model.ChuyenMuc;
import com.vuthanh.truyenhay.Model.TaiKhoan;
import com.vuthanh.truyenhay.R;

import java.util.List;

public class AdminAdapter extends BaseAdapter {

    private Context context;

    private List<Admin> adminList;

    public AdminAdapter(Context context, List<Admin> adminList) {
        this.context = context;
        this.adminList = adminList;
    }

    @Override
    public int getCount() {
         return adminList.size();
    }

    @Override
    public Object getItem(int position) {
        return adminList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class ViewHolder{
        TextView txtTenTaiKhoan;
        ImageView imgEdit;
        ImageView imgDelete;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder = null;
        viewHolder = new ViewHolder();

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.admin, null);

        viewHolder.txtTenTaiKhoan = convertView.findViewById(R.id.textviewTenTaiKhoan);
        viewHolder.imgEdit = convertView.findViewById(R.id.imgsua);
        viewHolder.imgDelete = convertView.findViewById(R.id.imgxoa);


        Admin ad = adminList.get(position);
        viewHolder.txtTenTaiKhoan.setText(ad.getTenadmin());

        viewHolder.imgEdit.setImageResource(ad.getHinhanhadminSua());
        viewHolder.imgDelete.setImageResource(ad.getHinhanhadminXoa());
        return convertView;
    }
}
