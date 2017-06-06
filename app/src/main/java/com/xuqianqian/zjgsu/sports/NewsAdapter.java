package com.xuqianqian.zjgsu.sports;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by z on 2017/5/31.
 */

public class NewsAdapter extends BaseAdapter {
    private ArrayList<NewsBean> list;
    private Context context;

    public NewsAdapter(Context context, ArrayList<NewsBean> list) {
        this.list = list;
        this.context = context;
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
        View view = null;
        if(convertView != null){
            view = convertView;
        }else {

            view = View.inflate(context, R.layout.item_news_layout, null);
        }

        ImageView item_img_icon = (ImageView) view.findViewById(R.id.item_img_icon);
        TextView item_tv_des = (TextView) view.findViewById(R.id.item_tv_des);
        TextView item_tv_title = (TextView) view.findViewById(R.id.item_tv_title);
        TextView item_tv_time = (TextView) view.findViewById(R.id.item_tv_time);

        NewsBean newsBean = list.get(position);

        item_img_icon.setImageDrawable(newsBean.icon);
        item_tv_title.setText(newsBean.title);
        item_tv_des.setText(newsBean.des);
        item_tv_time.setText(newsBean.time);

        return view;
    }


}


