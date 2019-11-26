package com.lzy.logisticsinfotest;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;


public class MessListAdapter extends BaseAdapter {
    //allContent就是所有物流信息的list
    private List<MessContent.TracesBean> list;
    private Context context;
    private LayoutInflater layoutInflater;


    public MessListAdapter(Context context, List<MessContent.TracesBean> list) {
        this.list = list;
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = layoutInflater.inflate(R.layout.item_express_data, null);
            holder.viewTopLine = convertView.findViewById(R.id.view_top_line);
            holder.view_buttom_line = convertView.findViewById(R.id.view_buttom_line);
            holder.ivExpresSpot = (ImageView) convertView.findViewById(R.id.iv_expres_spot);
            holder.tvExpressText = (TextView) convertView.findViewById(R.id.tv_express_text);
            holder.tvExpressTime = (TextView) convertView.findViewById(R.id.tv_express_time);

            //将ViewHolder与convertView进行绑定
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        MessContent.TracesBean bean = list.get(position);

        //设置数据颜色，防止view 复用，必须每个设置
        if (position == 0) {  //上顶部背景透明，点是灰色,字体是绿色
            holder.viewTopLine.setBackgroundColor(Color.TRANSPARENT);
            holder.view_buttom_line.setBackgroundColor(context.getResources().getColor(R.color.colorPrimary));
            holder.ivExpresSpot.setBackgroundResource(R.drawable.shape_button_title_circle);
            holder.tvExpressText.setTextColor(context.getResources().getColor(R.color.colorPrimary));
            holder.tvExpressTime.setTextColor(context.getResources().getColor(R.color.colorPrimary));
        } else {
            holder.ivExpresSpot.setBackgroundResource(R.drawable.shape_circle_gray);
            holder.tvExpressText.setTextColor(context.getResources().getColor(R.color.gray));
            holder.tvExpressTime.setTextColor(context.getResources().getColor(R.color.color_deep_default));
        }

        holder.tvExpressText.setText(bean.getAcceptStation());
        holder.tvExpressTime.setText(bean.getAcceptTime());


        return convertView;
    }


    public class ViewHolder {
        public View viewTopLine;
        public View view_buttom_line;
        private ImageView ivExpresSpot;
        private TextView tvExpressText;
        private TextView tvExpressTime;

    }


}
