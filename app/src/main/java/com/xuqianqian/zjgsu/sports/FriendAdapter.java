package com.xuqianqian.zjgsu.sports;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by z on 2017/6/3.
 */


public class FriendAdapter extends ArrayAdapter {
    private int resourceId;

    public FriendAdapter(Context context, int textViewResourceId,
                         List<Friend> objects) {
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Friend friend = (Friend) getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
        ImageView picture = (ImageView) view.findViewById(R.id.image);
        TextView person_name = (TextView) view.findViewById(R.id.friend_name);
        picture.setImageResource(friend.getImage());
        person_name.setText(friend.getName());
        return view;
    }

}




