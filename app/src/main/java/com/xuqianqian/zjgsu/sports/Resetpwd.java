package com.xuqianqian.zjgsu.sports;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Resetpwd extends AppCompatActivity {

    private EditText mAccount;
    private EditText mPwd_old;
    private EditText mPwd_new;
    private EditText mPwdCheck;
    private Button mSureButton;
    private Button mCancelButton;
    private UserDataManager mUserDataManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resetpwd);

        mAccount = (EditText) findViewById(R.id.resetpwd_name);
        mPwd_old = (EditText) findViewById(R.id.resetpwd_pwd_old);
        mPwd_new = (EditText) findViewById(R.id.resetpwd_pwd_new);
        mPwdCheck = (EditText) findViewById(R.id.resetpwd_pwd_check);

        mSureButton = (Button) findViewById(R.id.resetpwd_btn_sure);
        mCancelButton = (Button) findViewById(R.id.resetpwd_btn_cancel);

        mSureButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetpwd_check();
            }
        });
        mCancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_Resetpwd_to_Login = new Intent(Resetpwd.this,Login.class) ;
                startActivity(intent_Resetpwd_to_Login);
                finish();
            }
        });


        if (mUserDataManager == null) {
            mUserDataManager = new UserDataManager(this);
            mUserDataManager.openDataBase();
        }

    }

    public void resetpwd_check() {
        if (isUserNameAndPwdValid()) {
            String userName = mAccount.getText().toString();
            String userPwd_old = mPwd_old.getText().toString();
            String userPwd_new = mPwd_new.getText().toString();
            String userPwdCheck = mPwdCheck.getText().toString();
            int result=mUserDataManager.findUserByNameAndPwd(userName, userPwd_old);
            if(result==1){
                if(userPwd_new.equals(userPwdCheck)==false){
                    Toast.makeText(this, "密码确认不正确，请重新输入",Toast.LENGTH_SHORT).show();
                    return ;
                } else {
                    UserData mUser = new UserData(userName, userPwd_new);
                    mUserDataManager.openDataBase();

                    boolean flag = mUserDataManager.updateUserData(mUser);
                    if (flag == false) {
                        Toast.makeText(this, "密码修改失败，请重新尝试",Toast.LENGTH_SHORT).show();
                    }else{

                        Toast.makeText(this, "密码修改成功",Toast.LENGTH_SHORT).show();

                        mUser.pwdresetFlag=1;
                        Intent intent_Register_to_Login = new Intent(Resetpwd.this,Login.class) ;
                        startActivity(intent_Register_to_Login);
                        finish();
                    }
                }
            }else if(result==0){
                Toast.makeText(this, "密码不正确，请重新输入",Toast.LENGTH_SHORT).show();
                return;
            }




        }
    }
    public boolean isUserNameAndPwdValid() {
        String userName = mAccount.getText().toString();

        int count=mUserDataManager.findUserByName(userName);

        if(count<=0){
            Toast.makeText(this,"用户名不存在，请重新输入",Toast.LENGTH_SHORT).show();
            return false;
        }
        if (mAccount.getText().toString().equals("")) {
            Toast.makeText(this, "用户名为空，请重新输入",Toast.LENGTH_SHORT).show();
            return false;
        } else if (mPwd_old.getText().toString().equals("")) {
            Toast.makeText(this, "密码为空，请重新输入",Toast.LENGTH_SHORT).show();
            return false;
        } else if (mPwd_new.getText().toString().equals("")) {
            Toast.makeText(this, "新密码为空，请重新输入",Toast.LENGTH_SHORT).show();
            return false;
        }else if(mPwdCheck.getText().toString().equals("")) {
            Toast.makeText(this, "密码确认为空，请重新输入",Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

}
