package com.xuqianqian.zjgsu.sports;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static com.xuqianqian.zjgsu.sports.R.id.item_me;


public class SettingActivity extends AppCompatActivity implements View.OnClickListener{

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_setting);
            TextView textView_set1 = (TextView) findViewById(R.id.textView_set1);
            textView_set1.setOnClickListener(this);
            TextView textView_set2 = (TextView) findViewById(R.id.textView_set2);
            textView_set2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(SettingActivity.this, DataActivity.class);
                    startActivity(intent);

                }
            });
            Button button_set = (Button) findViewById(R.id.button_set);
            button_set.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(SettingActivity.this, Login.class);
                    startActivity(intent);

                }
            });


        }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.textView_set1:
                    AlertDialog.Builder dialog = new AlertDialog.Builder(SettingActivity.this);
                    dialog.setTitle("版本");
                    dialog.setMessage("当前版本已是最新");
                    dialog.setNegativeButton("BACK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    dialog.show();
                    break;
                default:
                    break;

            }

        }

    }



