package com.snail.administrator.snailmusic;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Fragment的"个人信息"页面
 */
public class PersonalContentFragment extends Fragment {
    TextView mTextView;
    String content;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.personal_content_fragment, container, false);
        mTextView= (TextView) view.findViewById(R.id.mTextView);
        return view;
    }

}
