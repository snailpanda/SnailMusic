package com.snail.administrator.snailmusic;

import android.media.MediaPlayer;

/**
 * Music帮助类
 * Created by Administrator on 2016/9/3.
 */
public class MusicUtil {
    public static MediaPlayer player = null;
    public static MediaPlayer getMediaPlayer() {
        if (player!=null) {
            return player;
        } else {
            return null;
        }
    }

}
