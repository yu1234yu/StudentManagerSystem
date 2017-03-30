package com.example.a00687560.mdtug001;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

public class ForgotPassword1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password1);

        getWindow().
                getDecorView().
                setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);

        //Intent intent =getIntent();
        //String message =intent.getStringExtra(SignInActivity.EXTRA_MESSAGE);

        /**
         * 为返回上个Activity的btn_back设置监听事件
         */
        Toolbar toolbar =(Toolbar) findViewById(R.id.for_password_toolbar);
        setSupportActionBar(toolbar);

        //后台设置ToolBar的图标，传递给对象toolbar
        toolbar.setNavigationIcon(R.drawable.btn_back);
        //让原始toolBar的title不显示。
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar.setNavigationOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                //Toast.makeText(ForgotPassword1Activity.this,"你返回了上一界面",Toast.LENGTH_SHORT).show();

                    onBackPressed();
            }
        });


    }
}



