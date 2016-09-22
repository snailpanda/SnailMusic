package com.snail.administrator.snailmusic;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

/**
 * 本地音乐界面(ListView)
 */
public class LocalMusicActivity extends AppCompatActivity {
    List<Music> musics=new ArrayList<>();
    ListView mListView;
    MyAdapter adapter;
    ImageView backImageView;//返回上一级按钮
    ImageView localSearchImageView;//本地搜索按钮
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_local_music);
        findView();//寻找控件
        setListener();//设置监听
        initData();
    }

    private void findView() {
        mListView= (ListView) findViewById(R.id.mListView);//列表
        backImageView = (ImageView) findViewById(R.id.localBack);//返回上一级按钮
        localSearchImageView = (ImageView) findViewById(R.id.localSearch);//本地搜索按钮
    }
    private void setListener() {
        mListView.setOnItemClickListener(new Listener());//列表监听
        backImageView.setOnClickListener(new BackListener());//返回上一级监听
        localSearchImageView.setOnClickListener(new SearchListener());//本地搜索的监听
    }


    /**
     * Item的点击的事件
     */
    private class Listener implements AdapterView.OnItemClickListener{

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Intent intent=new Intent(LocalMusicActivity.this,PlayActivity.class);
            intent.putExtra("musicPath",musics.get(position).getMusicPath());
            startActivity(intent);
        }
    }

    /**
     * 返回上一级的监听事件
     */
    public class BackListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            finish();
        }
    }

    /**
     * 本地搜索的监听事件
     */
    public class SearchListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(LocalMusicActivity.this,LocalSearchActivity.class);
            startActivity(intent);
        }
    }

    /**
     * 初始化页面的数据
     */
    private void initData() {
        musics=getMusic();
        adapter=new MyAdapter(musics,LocalMusicActivity.this);
        mListView.setAdapter(adapter);
    }

    /**
     * 自定义适配器
     */
    private class MyAdapter extends BaseAdapter{
        Context context;
        LayoutInflater inflater;
        List<Music> musics;
        ViewHolder mViewHolder;
        public MyAdapter(List<Music> musics, Context context) {
            this.musics = musics;
            this.context = context;
            inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return musics.size();
        }

        @Override
        public Object getItem(int position) {
            return musics.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if(convertView==null){
                convertView=inflater.inflate(R.layout.list_item,null);
                mViewHolder=new ViewHolder();
                mViewHolder.mTextViewMusicName= (TextView) convertView.findViewById(R.id.mTextViewMusicName);
                mViewHolder.mTextViewSinger= (TextView) convertView.findViewById(R.id.mTextViewSinger);
                convertView.setTag(mViewHolder);
            }else{
                mViewHolder= (ViewHolder) convertView.getTag();
            }
            mViewHolder.mTextViewMusicName.setText(musics.get(position).getMusicName());
            mViewHolder.mTextViewSinger.setText(musics.get(position).getArtist());
            return convertView;
        }
    }

    static class ViewHolder{
        TextView mTextViewMusicName;
        TextView mTextViewSinger;
    }
    /**
     * 获取系统音乐的数据
     */
    private List<Music> getMusic() {
        List<Music> musics=new ArrayList<>();
        Cursor cursor = getContentResolver().query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, null, null, null, null);
        while (cursor.moveToNext()){
            Music mMusic=new Music();
            mMusic.setTitle(cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.TITLE)));
            mMusic.setArtist(cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.ARTIST)));
            mMusic.setAlbum(cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.ALBUM)));
            mMusic.setMusicName(cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DISPLAY_NAME)));
            mMusic.setMusicPath(cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DATA)));
            musics.add(mMusic);
        }
        return musics;
    }
}

