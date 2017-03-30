package com.example.a00687560.mdtug001;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.TextView;


public class SignInActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        // 删除navigationBar
        getWindow().
                getDecorView().
                setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);

        /**
         * 点击 忘记密码 文本跳转
         */
        //借助SpannableString类实现超链接文字
        TextView tv_link = (TextView) findViewById(R.id.tv_link);
        tv_link.setText(getClickable());
        //设置超链接可点击
        tv_link.setMovementMethod(LinkMovementMethod.getInstance());
    }
        /**
         * 定义getClickable方法可点击
         */

    public SpannableString getClickable() {
        SpannableString spannableString = new SpannableString("忘记密码");
        //设置下划线文字
        spannableString.setSpan(new UnderlineSpan(), 0, 4, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        //设置文字的单击事件
        spannableString.setSpan(new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                //本界面弹框提示“忘记密码”
                //Toast.makeText(SignInActivity.this, "忘记密码", Toast.LENGTH_SHORT).getView();


            }
        }, 0, 4, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        //设置文字的前景色
        spannableString.setSpan(new ForegroundColorSpan(getColor(R.color.colorPrimary)), 0, 4, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        return spannableString;

    }

    //当用户点击TextView 调用,不传参数跳转
    public void textView(View view){
        Intent intent =new Intent(this,ForgotPassword1Activity.class);
        //TextView textView =(TextView) findViewById(R.id.tv_link);
        //String message =textView.getText().toString();
        //intent.putExtra(EXTRA_MESSAGE,message);
        startActivity(intent);
    }

    //当用户点击Button 调用，不惨参数跳转
    public  void signIn(View view){
        Intent intent = new Intent(this,HomeActivity.class);

        startActivity(intent);
    }


}
