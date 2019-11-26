package com.lzy.logisticsinfotest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class HistoryAdapter extends BaseAdapter {
    private Context context;
    private List<kdbean> kdList;
    private LayoutInflater layoutInflater;

    public HistoryAdapter(Context context, List<kdbean> list) {
        this.kdList = list;
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return kdList.size();
    }

    @Override
    public Object getItem(int position) {
        return kdList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = layoutInflater.inflate(R.layout.item_history, null);

            viewHolder.kdname = convertView.findViewById(R.id.kdname);
            viewHolder.kdnum=convertView.findViewById(R.id.kdnum);

            //将ViewHolder与convertView进行绑定
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        kdbean kd = kdList.get(position);

        viewHolder.kdnum.setText(kd.getKdnum());
        viewHolder.kdname.setText(kd.getKdname());

        return convertView;
    }

    public class ViewHolder {
        private TextView kdname;
        private TextView kdnum;

    }
}
