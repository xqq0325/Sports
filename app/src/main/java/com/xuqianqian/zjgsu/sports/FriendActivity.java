package com.xuqianqian.zjgsu.sports;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class FriendActivity extends AppCompatActivity {

    private List<Friend> friendList = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends_list);
        initFriends();
        FriendAdapter adapter = new FriendAdapter(FriendActivity.this, R.layout.item, friendList);
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Friend friend = friendList.get(position);
                Intent intent = new Intent(FriendActivity.this, ChatActivity.class);
                startActivity(intent);
            }
        });

    }

    private void initFriends() {
        for (int i = 0; i < 1; i++) {
            Friend gt = new Friend("光头", R.drawable.image_1);
            friendList.add(gt);
            Friend lx = new Friend("刘希", R.drawable.image_2);
            friendList.add(lx);
            Friend tt = new Friend("图图", R.drawable.image_3);
            friendList.add(tt);
            Friend dt = new Friend("大头", R.drawable.image_4);
            friendList.add(dt);
            Friend ll = new Friend("拉拉", R.drawable.image_5);
            friendList.add(ll);
            Friend lj = new Friend("李杰", R.drawable.image_6);
            friendList.add(lj);
            Friend wx = new Friend("王欣", R.drawable.image_7);
            friendList.add(wx);
            Friend hh = new Friend("花花", R.drawable.image_8);
            friendList.add(hh);
            Friend ds = new Friend("大山", R.drawable.image_1);
            friendList.add(ds);
        }
    }
}




