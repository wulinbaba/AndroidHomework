package com.example.wulin.schoolmate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.io.ObjectInputValidation;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener{

    private List<Object> objectList = new ArrayList<>();

    private TextView tabHome;
    private TextView tabPost;
    private TextView tabDialog;
    private TextView tabUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initFruit();
        bindView();
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        ObjectAdapter adapter = new ObjectAdapter(objectList);
        recyclerView.setAdapter(adapter);

    }



    private void initFruit(){

            Object thing1 = new Object("name1",R.drawable.zhuangxiu1,"1小时前","thing1","111元","一张剑桥雅思1-11的听力光碟，质量没问题，一对剑桥雅思7的正版听力光碟。",R.drawable.zhuangxiu1,R.drawable.zhuangxiu2,R.drawable.zhuangxiu3);
            objectList.add(thing1);
            Object thing2 = new Object("name2",R.drawable.zhuangxiu2,"1小时前","thing1","111元","一张剑桥雅思1-11的听力光碟，质量没问题，一对剑桥雅思7的正版听力光碟。",R.drawable.zhuangxiu1,R.drawable.zhuangxiu2,R.drawable.zhuangxiu3);
            objectList.add(thing2);
            Object thing3 = new Object("name3",R.drawable.zhuangxiu3,"1小时前","thing1","111元","一张剑桥雅思1-11的听力光碟，质量没问题，一对剑桥雅思7的正版听力光碟。",R.drawable.zhuangxiu1,R.drawable.zhuangxiu2,R.drawable.zhuangxiu3);
            objectList.add(thing3);
            Object thing4 = new Object("name4",R.drawable.zhuangxiu4,"1小时前","thing1","111元","一张剑桥雅思1-11的听力光碟，质量没问题，一对剑桥雅思7的正版听力光碟。",R.drawable.zhuangxiu1,R.drawable.zhuangxiu2,R.drawable.zhuangxiu3);
            objectList.add(thing4);
            Object thing5 = new Object("name5",R.drawable.zhuangxiu5,"1小时前","thing1","111元","一张剑桥雅思1-11的听力光碟，质量没问题，一对剑桥雅思7的正版听力光碟。",R.drawable.zhuangxiu1,R.drawable.zhuangxiu2,R.drawable.zhuangxiu3);
            objectList.add(thing5);
            Object thing6 = new Object("name6",R.drawable.zhuangxiu6,"1小时前","thing1","111元","一张剑桥雅思1-11的听力光碟，质量没问题，一对剑桥雅思7的正版听力光碟。",R.drawable.zhuangxiu1,R.drawable.zhuangxiu2,R.drawable.zhuangxiu3);
            objectList.add(thing6);

    }

    //UI组件初始化与事件绑定
    private void bindView() {
        tabHome = (TextView)this.findViewById(R.id.txt_home);
        tabPost = (TextView)this.findViewById(R.id.txt_post);
        tabDialog = (TextView)this.findViewById(R.id.txt_dialog);
        tabUser = (TextView)this.findViewById(R.id.txt_user);

        tabHome.setOnClickListener(this);
        tabPost.setOnClickListener(this);
        tabDialog.setOnClickListener(this);
        tabUser.setOnClickListener(this);
        tabHome.setSelected(true);
    }

    //重置所有文本的选中状态
    public void selected(){
        tabHome.setSelected(false);
        tabPost.setSelected(false);
        tabDialog.setSelected(false);
        tabUser.setSelected(false);
    }

    public void selected2(){
        tabHome.setSelected(true);
        tabPost.setSelected(false);
        tabDialog.setSelected(false);
        tabUser.setSelected(false);
    }

    @Override
    public void onClick(View v) {

        switch(v.getId()){
            case R.id.txt_home:
                selected2();
                tabHome.setSelected(true);
                break;

            case R.id.txt_post:

                tabPost.setSelected(true);
                Intent intent2 = new Intent(HomeActivity.this, AnnounceActivity.class);
                intent2.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivity(intent2);
                selected2();
                break;

            case R.id.txt_dialog:
                tabDialog.setSelected(true);
                Intent intent3 = new Intent(HomeActivity.this, DialogActivity.class);
                intent3.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivity(intent3);
                selected2();
                break;

            case R.id.txt_user:
                Intent intent4 = new Intent(HomeActivity.this, UserActivity.class);
                intent4.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivity(intent4);
                tabUser.setSelected(true);
                selected2();

        }
    }



}
