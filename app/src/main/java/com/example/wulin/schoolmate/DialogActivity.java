package com.example.wulin.schoolmate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DialogActivity extends AppCompatActivity  implements View.OnClickListener{

    private TextView tabHome;
    private TextView tabPost;
    private TextView tabDialog;
    private TextView tabUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        bindView();
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
        tabDialog.setSelected(true);
    }

    //重置所有文本的选中状态
    public void selected(){
        tabHome.setSelected(false);
        tabPost.setSelected(false);
        tabDialog.setSelected(false);
        tabUser.setSelected(false);
    }

    public void selected2(){
        tabHome.setSelected(false);
        tabPost.setSelected(false);
        tabDialog.setSelected(true);
        tabUser.setSelected(false);
    }

    @Override
    public void onClick(View v) {

        switch(v.getId()){
            case R.id.txt_home:
                selected2();
                //tabHome.setSelected(true);

                Intent intent = new Intent(DialogActivity.this, HomeActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivity(intent);
                break;

            case R.id.txt_post:
                selected2();
                //tabPost.setSelected(true);
                Intent intent2 = new Intent(DialogActivity.this, AnnounceActivity.class);
                intent2.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivity(intent2);
                break;

            case R.id.txt_dialog:
                selected2();
                //tabDialog.setSelected(true);

                break;

            case R.id.txt_user:
                selected2();
                Intent intent3 = new Intent(DialogActivity.this, UserActivity.class);
                intent3.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivity(intent3);
                //tabUser.setSelected(true);
        }
    }
}
