package com.xuqianqian.zjgsu.sports;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ChatActivity extends AppCompatActivity {

    private ListView talkView;
    private Button messageButton;
    private EditText messageText;
    private ArrayList<ChatMsg> list = new ArrayList<ChatMsg>();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        System.out.println("AAAAAAAAAA");
        talkView = (ListView) findViewById(R.id.list);
        messageButton = (Button) findViewById(R.id.button_send);
        messageText = (EditText) findViewById(R.id.editText);
        messageButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String  name = getName(R.string.myDisplayName);
                String  date  =getDate();
                String  msgText  =getText();
                int RIdA = R.layout.list_me;
                ChatMsg   newMsg = new ChatMsg(name,date,msgText,RIdA);
                list.add(newMsg);
                int RIdB = R.layout.item_other;
                String  othername = getName(R.string.otherDisplayName);
                ChatMsg   backMsg = new ChatMsg(othername,date,"自动回复(for test!)",RIdB);
                list.add(backMsg);
                talkView.setAdapter(new ChatMsgViewAdapter(ChatActivity.this,list));
                messageText.setText("");
            }
        }) ;
    }


    private  String getName(int id){
        return getResources().getString(id);
    }
    private   String  getDate(){
        SimpleDateFormat sdf  =new SimpleDateFormat("MM-dd HH:mm");
        Date d = new Date();
        return   sdf.format(d);
    }
    private  String  getText(){
        return messageText.getText().toString();
    }
    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();
    }
}