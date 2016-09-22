package com.snail.administrator.snailmusic;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
//
/**
 * Fragment的"在线音乐"页面
 */
public class OnlineContentFragment extends Fragment {
        TabLayout mTabLayout;//定义TabLayout
    ViewPager mViewPager;//定义ViewPager
    List<Fragment> fragments=new ArrayList<>();    //初始化那个Fragment的容器
    String[] titles= {"个性推荐","歌单","主播电台","排行榜"};
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.online_content_fragment, container, false);
        mTabLayout= (TabLayout) view.findViewById(R.id.mTablayout);
        mViewPager= (ViewPager) view.findViewById(R.id.mViewPager);
        initData();
        setAdapter();
        viewPagerWithTabLayout();
        return view;
    }


    private void viewPagerWithTabLayout() {
        mTabLayout.setupWithViewPager(mViewPager);
    }

    /**
     * 设置那个适配器
     */
    private void setAdapter() {
        MyAdapter mMyAdapter=new MyAdapter(getFragmentManager());
        mViewPager.setAdapter(mMyAdapter);
    }
    private class MyAdapter extends FragmentPagerAdapter {
        public MyAdapter(FragmentManager fm) {
            super(fm);
        }
        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }
        @Override
        public int getCount() {
            return fragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }
    }

    /**
     * 初始化数据
     */
    private void initData() {
        for (int i=0;i<titles.length;i++){
            ContentFragment mContentFragment=new ContentFragment();
            Bundle bundle = new Bundle();
            bundle.putString("content",titles[i]);
            mContentFragment.setArguments(bundle);
            fragments.add(mContentFragment);
        }
    }

}
