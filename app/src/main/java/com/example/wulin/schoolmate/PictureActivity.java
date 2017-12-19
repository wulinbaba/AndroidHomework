package com.example.wulin.schoolmate;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

public class PictureActivity extends Activity implements View.OnClickListener{

    private Button btn_take_photo,btn_pick_photo, btn_cancel;
    private RelativeLayout relLay;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture);
        intent = getIntent();
        btn_take_photo = (Button)findViewById(R.id.拍照);
        btn_pick_photo = (Button)findViewById(R.id.相册选取);
        btn_cancel = (Button)findViewById(R.id.取消);
        relLay = (RelativeLayout)findViewById(R.id.照片弹出框);

        btn_take_photo.setOnClickListener(this);
        btn_pick_photo.setOnClickListener(this);
        btn_cancel.setOnClickListener(this);
        relLay.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.拍照:
                try {
                    //拍照我们用Action为MediaStore.ACTION_IMAGE_CAPTURE，
                    //有些人使用其他的Action但我发现在有些机子中会出问题，所以优先选择这个
                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(intent, 1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case R.id.相册选取:
                try {
                    Intent intent = new Intent();
                    intent.setType("image/*");
                    intent.setAction(Intent.ACTION_GET_CONTENT);
                    startActivityForResult(intent, 2);
                } catch (ActivityNotFoundException e) {

                }
                break;
            case R.id.取消:
                finish();
                break;
            default:
                break;
        }
    }

    @Override  //startActivityResult()后调用的这下面方法
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {   // 拍照,或者选择图片后调用的方法
        if (resultCode != RESULT_OK) {
            return;
        }
        //选择完或者拍完照后会在这里处理，然后我们继续使用setResult返回Intent以便可以传递数据和调用
        if (data.getExtras() != null)
            intent.putExtras(data.getExtras());   //拍照得到的图片
        if (data.getData()!= null)
            intent.setData(data.getData());   //选择图片得到的数据, 里面有uri
        setResult(1, intent);     // 返回到下面的, MainActivity
        finish();

    }
}
