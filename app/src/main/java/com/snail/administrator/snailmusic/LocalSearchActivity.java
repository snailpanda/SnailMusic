package com.snail.administrator.snailmusic;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by Administrator on 2016/9/16.
 * 本地搜索界面
 */
public class LocalSearchActivity extends AppCompatActivity {
    ImageView localBackImageView;//本地音乐返回上一级按钮
    ImageView localSearchImageView;//本地搜索按钮
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_local_search);
        findView();//寻找id
        setListener();//设置监听
    }

    /**
     * 寻找id
     */
    private void findView() {
        localBackImageView = (ImageView) findViewById(R.id.ivBack);//本地音乐返回上一级
        localSearchImageView = (ImageView) findViewById(R.id.search);//本地搜索
    }

    /**
     * 设置监听
     */
    private void setListener() {
        localBackImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
