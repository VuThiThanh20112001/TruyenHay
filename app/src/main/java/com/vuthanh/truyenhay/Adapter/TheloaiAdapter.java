package com.vuthanh.truyenhay.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.vuthanh.truyenhay.Model.Theloai;
import com.vuthanh.truyenhay.R;

import java.util.List;

public class TheloaiAdapter extends BaseAdapter {
    private Context context;
    private List<Theloai> listTheloai;

    public TheloaiAdapter(Context context, int list_theloai, List<Theloai> listTheloai) {
        this.context = context;
        this.listTheloai = listTheloai;
    }

    @Override
    public int getCount() {
        return listTheloai.size();
    }

    @Override
    public Object getItem(int position) {
        return listTheloai.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public static class ViewHolder{
        TextView txtTheloai;
        ImageView imgTheloai;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        viewHolder = new ViewHolder();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.list_theloai, null);

        viewHolder.txtTheloai = convertView.findViewById(R.id.txttheloai);
        viewHolder.imgTheloai = convertView.findViewById(R.id.img_hinhtheloai);
        convertView.setTag(viewHolder);

        Theloai theloai = listTheloai.get(position);
        viewHolder.txtTheloai.setText(theloai.getTenTL());
        viewHolder.imgTheloai.setImageResource(theloai.getHinhTL());

        return convertView;
    }
}
