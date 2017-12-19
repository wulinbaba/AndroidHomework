package com.example.wulin.schoolmate;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class AnnounceActivity extends Activity implements View.OnClickListener {

    private Button btn_slt_ph;
    private ImageView photo;

    private TextView tabHome;
    private TextView tabPost;
    private TextView tabDialog;
    private TextView tabUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_announce);
        btn_slt_ph = (Button) findViewById(R.id.点击选取);
        photo = (ImageView)findViewById(R.id.img_发布);
        btn_slt_ph.setOnClickListener(this);
        bindView();
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.txt_home:
                selected2();
                //tabHome.setSelected(true);
                Intent intent = new Intent(AnnounceActivity.this, HomeActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivity(intent);
                break;

            case R.id.txt_post:
                selected2();
                //tabPost.setSelected(true);

                break;

            case R.id.txt_dialog:
                selected2();
                //tabDialog.setSelected(true);
                Intent intent2 = new Intent(AnnounceActivity.this, DialogActivity.class);
                intent2.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivity(intent2);
                break;

            case R.id.txt_user:
                selected2();
                Intent intent3 = new Intent(AnnounceActivity.this, UserActivity.class);
                intent3.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivity(intent3);
                //tabUser.setSelected(true);
                break;

            case R.id.点击选取:
                startActivityForResult(new Intent(AnnounceActivity.this, PictureActivity.class), 1);
                break;
        }

    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        switch (resultCode) {
            case 1:
                if (data != null) {
                    //取得返回的Uri,基本上选择照片的时候返回的是以Uri形式，但是在拍照中有的机子Uri是空的，所以要特别注意
                    Uri mImageCaptureUri = data.getData();  //选择图片有uri
                    //返回的Uri不为空时，那么图片信息数据都会在Uri中获得。如果为空，那么我们就进行下面的方式获取
                    if (mImageCaptureUri != null) {
                        Bitmap image;
                        try {
                            //这个方法是根据Uri获取Bitmap图片的静态方法
                            image = MediaStore.Images.Media.getBitmap(this.getContentResolver(), mImageCaptureUri);
                            if (image != null) {
                                photo.setImageBitmap(image);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else {
                        Bundle extras = data.getExtras(); //拍照没有uri
                        if (extras != null) {
                            //这里是有些拍照后的图片是直接存放到Bundle中的所以我们可以从这里面获取Bitmap图片
                            Bitmap image = extras.getParcelable("data");
                            if (image != null) {
                                photo.setImageBitmap(image);
                            }
                        }
                    }

                }
                break;
            default:
                break;

        }
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
        tabPost.setSelected(true);
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
        tabPost.setSelected(true);
        tabDialog.setSelected(false);
        tabUser.setSelected(false);
    }

}
