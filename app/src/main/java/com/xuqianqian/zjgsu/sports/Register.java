package com.xuqianqian.zjgsu.sports;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {

   
        private EditText mAccount;
        private EditText mPwd;
        private EditText mPwdCheck;
        private Button mSureButton;
        private Button mCancelButton;
        private UserDataManager mUserDataManager;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_register);
            mAccount = (EditText) findViewById(R.id.name);
            mPwd = (EditText) findViewById(R.id.pwd_old);
            mPwdCheck = (EditText) findViewById(R.id.pwd_new);

            mSureButton = (Button) findViewById(R.id.register_btn_sure);
            mCancelButton = (Button) findViewById(R.id.register_btn_cancel);

            mSureButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    register_check();
                }
            });
            mCancelButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent_Register_to_Login = new Intent(com.xuqianqian.zjgsu.sports.Register.this,Login.class) ;
                    startActivity(intent_Register_to_Login);
                    finish();
                }
            });

            if (mUserDataManager == null) {
                mUserDataManager = new UserDataManager(this);
                mUserDataManager.openDataBase();
            }

        }

        public void register_check() {
            if (isUserNameAndPwdValid()) {
                String userName = mAccount.getText().toString();
                String userPwd = mPwd.getText().toString();
                String userPwdCheck = mPwdCheck.getText().toString();

                int count=mUserDataManager.findUserByName(userName);

                if(count>0){
                    Toast.makeText(this, "用户名已存在，请重新输入",Toast.LENGTH_SHORT).show();
                    return ;
                }
                if(userPwd.equals(userPwdCheck)==false){
                    Toast.makeText(this, "密码确认不正确，请重新输入",Toast.LENGTH_SHORT).show();
                    return ;
                } else {
                    UserData mUser = new UserData(userName, userPwd);
                    mUserDataManager.openDataBase();
                    long flag = mUserDataManager.insertUserData(mUser);
                    if (flag == -1) {
                        Toast.makeText(this, "注册用户失败，请重新尝试",Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(this, "注册成功",Toast.LENGTH_SHORT).show();
                        Intent intent_Register_to_Login = new Intent(com.xuqianqian.zjgsu.sports.Register.this,Login.class) ;
                        startActivity(intent_Register_to_Login);
                        finish();
                    }
                }
            }
        }
        public boolean isUserNameAndPwdValid() {
            if (mAccount.getText().toString().equals("")) {
                Toast.makeText(this, "用户名为空，请重新输入", Toast.LENGTH_SHORT).show();
                return false;
            } else if (mPwd.getText().toString().equals("")) {
                Toast.makeText(this, "密码为空，请重新输入", Toast.LENGTH_SHORT).show();
                return false;
            }else if(mPwdCheck.getText().toString().equals("")) {
                Toast.makeText(this,"密码确认为空，请重新输入", Toast.LENGTH_SHORT).show();
                return false;
            }
            return true;
        }
    }
