package com.snail.administrator.snailmusic;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;
import android.view.ViewGroup.LayoutParams;
import java.io.IOException;

/**
 * 播放界面
 */
public class PlayActivity extends AppCompatActivity {
    String musicPath;
    boolean playingOrNot = false;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        musicPath = getIntent().getStringExtra("musicPath");

    }

    /**
     * 事件处理
     */
    public void myClick(View view) {
        switch (view.getId()) {
            case R.id.mBtnPause://暂停
                pause();
                break;
            case R.id.mBtnPlay://播放
                play();
                break;
            case R.id.mBtnStop://停止
                stop();
                break;
            case R.id.mIvBack://后退到音乐列表界面
                back();
            case R.id.mIvShare://分享
                share();
                break;
        }
    }

    /**
     * 暂停
     */
    private void pause() {
        if (MusicUtil.getMediaPlayer()!=null&&MusicUtil
                .getMediaPlayer().isPlaying()) {
            MusicUtil.getMediaPlayer().pause();
            playingOrNot = true;
        }
    }

    /**
     * 播放
     */
    private void play() {
        if(playingOrNot) {
            if(MusicUtil.getMediaPlayer()!=null) {
                MusicUtil.getMediaPlayer().start();
            }
        } else {
            try {
                MusicUtil.player = new MediaPlayer();
                MusicUtil.getMediaPlayer().setDataSource(musicPath);
                MusicUtil.getMediaPlayer().prepare();
                MusicUtil.getMediaPlayer().start();
                playingOrNot = true;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 停止
     */
    private void stop() {
        if(MusicUtil.getMediaPlayer()!=null&&MusicUtil
                .getMediaPlayer().isPlaying()) {
            MusicUtil.getMediaPlayer().stop();
            MusicUtil.player = null;
            playingOrNot = false;
        }
    }

    /**
     * 返回
     */
    private void back() {
        Intent intent = new Intent(PlayActivity.this,LocalMusicActivity.class);
        startActivity(intent);
        finish();
    }

    /**
     * 分享
     */
    private void share() {
        PopupWindow popupWindow = popupWindow=new PopupWindow(PlayActivity.this);
        popupWindow.setHeight(LayoutParams.WRAP_CONTENT);
        popupWindow.setWidth(LayoutParams.WRAP_CONTENT);
        popupWindow.setFocusable(true);
        popupWindow.setOutsideTouchable(true);
        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.popupwindow_list,null);
        popupWindow.setContentView(view);
        popupWindow.showAtLocation(getWindow().getDecorView(), Gravity.NO_GRAVITY,450,160);
    }

}
