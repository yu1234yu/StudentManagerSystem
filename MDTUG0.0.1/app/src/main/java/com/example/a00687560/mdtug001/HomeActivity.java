package com.example.a00687560.mdtug001;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private FragmentManager fManager;
    private GridLayout gridLayout;
    private LinearLayout linear_tag;
    private ImageView up;
    private Button menu_6,menu_1,menu_2,menu_3,menu_4,menu_5;
    private boolean isButton=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        /**
         * 以下为滑动侧菜单效果
         */
        Toolbar toolbar = (Toolbar) findViewById(R.id.home_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        navigationView.setItemIconTintList(null);//去除默认navigationItem的图标

        /**
         * 以下为默认隐藏顶部网格图标，点击更多后 显示，并隐藏文字标签
         */
        gridLayout =(GridLayout) findViewById(R.id.gridlayout);
        menu_6 =(Button)findViewById(R.id.menu_6);
        up =(ImageView)findViewById(R.id.up);
        linear_tag =(LinearLayout)findViewById(R.id.linear_tag);
        menu_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isButton) {
                    gridLayout.setVisibility(View.VISIBLE);
                    if (isButton) {
                        linear_tag.setVisibility(View.GONE);
                        isButton = false;
                }
                    isButton=false;
                } else {
                        gridLayout.setVisibility(View.GONE);
                        isButton = true;
                    }
            }
        });
        up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isButton) {
                    gridLayout.setVisibility(View.VISIBLE);
//                    if (isButton) {
//                        linear_tag.setVisibility(View.GONE);
//                        isButton = false;
                    isButton=false;
                } else {
                    gridLayout.setVisibility(View.GONE);
                    isButton = true;
                    if (isButton) {
                        linear_tag.setVisibility(View.VISIBLE);
                    }
                }
            }
        });



    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.my_book) {
            // Handle the camera action
            Intent intent = new Intent(this,MyBookActivity.class);
            startActivity(intent);
            //跳转到 我的订阅
        } else if (id == R.id.my_collection) {
            Intent intent = new Intent(this,MyCollectionActivity.class);
            startActivity(intent);
            //跳转到 我的收藏
        } else if (id == R.id.my_like) {
            Intent intent = new Intent(this,MyLikeActivity.class);
            startActivity(intent);
            //跳转到 我的爱好
        } else if (id == R.id.setting) {
            Intent intent = new Intent(this,SettingActivity.class);
            startActivity(intent);
            //跳转到 设置
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}
