package com.example.a00687560.mdtug001;


import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.a00687560.model.LibsInfo;

import org.litepal.crud.DataSupport;
import org.litepal.tablemanager.Connector;

import java.util.List;


public class MyBookActivity extends AppCompatActivity implements View.OnClickListener{

    private RecyclerView mRecyclerView;
    private MyAdapter Adapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private List<LibsInfo> libsInFoList;
    private Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_book);

        mRecyclerView =(RecyclerView)findViewById(R.id.my_book_recycler_view);
        //以下，如果可以确定每个Item的高度是固定的，设置这个选项可以提高性能
        mRecyclerView.setHasFixedSize(true);
        //以下，创建默认的线性LayoutManager
        mLayoutManager= new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        btnAdd=(Button)findViewById(R.id.btn_add);
        btnAdd.setOnClickListener(this);
        SQLiteDatabase db=Connector.getDatabase();

        //获取全部图书信息
        List<LibsInfo>libsInFoList= DataSupport.select("lib_name").find(LibsInfo.class);
        //Toast.makeText(MyBookActivity.this, libsInFoList.get(0).getId()+"",0).show();

        //以下，创建并设置Adapter
        Adapter = new MyAdapter(this,libsInFoList);
        mRecyclerView.setAdapter(Adapter);

    }


    //点击删除按钮监听
    public void onClick(View v){
                //普通存储
                Intent i = new Intent(MyBookActivity.this, AddBookActivity.class);
                startActivityForResult(i, 1);

    }


    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        //根据返回的resultCode判断是通过哪种操作返回的，并提示相关信息；
        switch (requestCode){
            case 0:
                if (resultCode==1)
                    Toast.makeText(this,"修改成功",Toast.LENGTH_SHORT).show();
                if (resultCode==2)
                    Toast.makeText(this,"已删除",Toast.LENGTH_SHORT).show();
                break;
            case 1:
                if (resultCode==RESULT_OK)
                    Toast.makeText(this,"添加成功",Toast.LENGTH_SHORT).show();
                break;
        }
        /**
         * 如果这里仅仅使用adapter.notifyDataSetChanged()是不会刷新界面ListView的，
         * 因为此时adapter中传入的studentList并没有给刷新，即adapter也没有被刷新，所以你可以
         * 重新获取studentList后再改变adapter，我这里通过调用onCreate()重新刷新了整个界面
         */

        Adapter = new MyAdapter(this,libsInFoList);
        mRecyclerView.setAdapter(Adapter);
      //onCreate(null);
    }



}
