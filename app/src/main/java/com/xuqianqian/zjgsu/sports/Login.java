package com.xuqianqian.zjgsu.sports;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {


        private EditText mAccount;
        private EditText mPwd;
        private Button mRegisterButton;
        private Button mLoginButton;
        private CheckBox mRememberCheck;

        private SharedPreferences login_sp;
        private String userNameValue,passwordValue;


        private TextView mChangepwdText;
        private UserDataManager mUserDataManager;


        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_login);
            mAccount = (EditText) findViewById(R.id.account);
            mPwd = (EditText) findViewById(R.id.pwd);
            mRegisterButton = (Button) findViewById(R.id.register);
            mLoginButton = (Button) findViewById(R.id.login);

            mChangepwdText = (TextView) findViewById(R.id.change_pwd);

            mRememberCheck = (CheckBox) findViewById(R.id.Login_Remember);

            login_sp = getSharedPreferences("userInfo", 0);
            String name=login_sp.getString("USER_NAME", "");
            String pwd =login_sp.getString("PASSWORD", "");
            boolean choseRemember =login_sp.getBoolean("mRememberCheck", false);

            if(choseRemember){
                mAccount.setText(name);
                mPwd.setText(pwd);
                mRememberCheck.setChecked(true);
            }

            mRegisterButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent_Login_to_Register = new Intent(com.xuqianqian.zjgsu.sports.Login.this,Register.class) ;
                    startActivity(intent_Login_to_Register);
                    finish();
                }
            });
            mLoginButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    login();
                }
            });

            mChangepwdText.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent_Login_to_reset = new Intent(com.xuqianqian.zjgsu.sports.Login.this,Resetpwd.class) ;
                    startActivity(intent_Login_to_reset);
                    finish();
                }
            });


            if (mUserDataManager == null) {
                mUserDataManager = new UserDataManager(this);
                mUserDataManager.openDataBase();
            }
        }


        public void login() {
            if (isUserNameAndPwdValid()) {
                String userName = mAccount.getText().toString();
                String userPwd = mPwd.getText().toString();
                SharedPreferences.Editor editor =login_sp.edit();
                int result=mUserDataManager.findUserByNameAndPwd(userName, userPwd);
                if(result==1){

                    editor.putString("USER_NAME", userName);
                    editor.putString("PASSWORD", userPwd);


                    if(mRememberCheck.isChecked()){
                        editor.putBoolean("mRememberCheck", true);
                    }else{
                        editor.putBoolean("mRememberCheck", false);
                    }
                    editor.commit();

                    Intent intent = new Intent(com.xuqianqian.zjgsu.sports.Login.this,MainActivity.class) ;
                    startActivity(intent);
                    finish();
                    Toast.makeText(this, "登录成功",Toast.LENGTH_SHORT).show();
                }else if(result==0){
                    Toast.makeText(this, "登录失败，请重新输入用户名和密码",Toast.LENGTH_SHORT).show();
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
            }
            return true;
        }

        @Override
        protected void onResume() {
            if (mUserDataManager == null) {
                mUserDataManager = new UserDataManager(this);
                mUserDataManager.openDataBase();
            }
            super.onResume();
        }

        @Override
        protected void onDestroy() {

            super.onDestroy();
        }

        @Override
        protected void onPause() {
            if (mUserDataManager != null) {
                mUserDataManager.closeDataBase();
                mUserDataManager = null;
            }
            super.onPause();
        }
    }
