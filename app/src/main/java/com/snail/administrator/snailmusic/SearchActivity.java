package com.snail.administrator.snailmusic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

/**
 * 在线搜索
 */
public class SearchActivity extends AppCompatActivity {

    ImageView ivBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        init();//初始化
    }

    private void init() {
        findView();//寻找控件
        setListener();//设置监听
    }

    /**
     * 寻找控件
     */
    private void findView() {
        ivBack = (ImageView) findViewById(R.id.ivBack);//返回键
    }

    /**
     * 设置监听
     */
    private void setListener() {
        /**
         * 返回键
         */
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
