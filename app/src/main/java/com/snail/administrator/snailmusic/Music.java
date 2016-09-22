package com.snail.administrator.snailmusic;

import android.view.animation.Animation;

import java.io.Serializable;

/**
 * Music封装类
 * Created by Administrator on 2016/9/3.
 */
public class Music implements Serializable {
    private String title;//专辑的名称
    private String artist;//歌手名称
    private String size;//歌曲的大小
    private String duration;//歌曲的长度
    private String musicName;//歌曲的名称
    private String musicPath;//歌曲的路径
    private String album;//专辑

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getMusicName() {
        return musicName;
    }

    public void setMusicName(String musicName) {
        this.musicName = musicName;
    }

    public String getMusicPath() {
        return musicPath;
    }

    public void setMusicPath(String musicPath) {
        this.musicPath = musicPath;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public Music() {

    }

    public Music(String title, String artist, String size, String duration, String musicName, String musicPath, String album) {
        this.title = title;
        this.artist = artist;
        this.size = size;
        this.duration = duration;
        this.musicName = musicName;
        this.musicPath = musicPath;
        this.album = album;

    }
}
