package com.xuqianqian.zjgsu.sports;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * Created by z on 2017/6/3.
 */

public class ChatMsgViewAdapter extends BaseAdapter {
    private static final String TAG = ChatMsgViewAdapter.class.getSimpleName();

    private ArrayList<ChatMsg> list;
    private Context context;
    public ChatMsgViewAdapter(Context  context, ArrayList<ChatMsg>  list) {
        this.context = context;
        this.list =    list;
    }
    public boolean areAllItemsEnabled() {
        return false;
    }

    public boolean isEnabled(int arg0) {
        return false;
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
    public int getItemViewType(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ChatMsg   msg = list.get(position);
        int itemlayout = msg.getLayoutID();
        LinearLayout layout = new LinearLayout(context);
        LayoutInflater vi = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        vi.inflate(itemlayout, layout,true);
        TextView tvName = (TextView) layout.findViewById(R.id.name);
        tvName.setText(msg.getName());
        TextView tvDate  =(TextView) layout.findViewById(R.id.date);
        tvDate.setText(msg.getDate());
        TextView  tvText  =(TextView) layout.findViewById(R.id.text);
        tvText.setText(msg.getText());
        return layout;
    }
    public int getViewTypeCount() {
        return list.size();
    }

    public boolean hasStableIds() {
        return false;
    }

    public boolean isEmpty() {
        return false;
    }

    public void registerDataSetObserver(DataSetObserver observer) {
    }

    public void unregisterDataSetObserver(DataSetObserver observer) {
    }
}

