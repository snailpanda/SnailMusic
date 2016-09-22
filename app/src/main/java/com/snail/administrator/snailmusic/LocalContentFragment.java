package com.snail.administrator.snailmusic;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/**
 * Fragment的"本地音乐"页面
 */
public class LocalContentFragment extends Fragment {
    LinearLayout localMusic;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.local_content_fragment, container, false);
        localMusic = (LinearLayout) view.findViewById(R.id.localMusic);
        setListener();//设置监听
        return view;
    }



    /**
     * 设置监听
     */
    private void setListener() {
        localMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),LocalMusicActivity.class);
                startActivity(intent);
            }
        });
    }

}
