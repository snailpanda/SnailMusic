package com.snail.administrator.snailmusic;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import java.util.ArrayList;
import java.util.List;

/**
 * 主界面
 */
public class MainActivity extends AppCompatActivity {
	List<Fragment> fragments=new ArrayList<>();   //fragment的初始化
	RadioGroup mRadioGroup;
	ViewPager mViewPager;
	RadioButton radioBtnOnline;
	RadioButton radioBtnManager;
	RadioButton radioBtnPersonal;
	ImageView ivSearch;
	List<RadioButton> radioBtns=new ArrayList<>();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		findView();//寻找控件
		mRadioGroup.setOnCheckedChangeListener(new OnCheckedListener());
		mViewPager.addOnPageChangeListener(new OnPageListener());
		initData();
		setAdapter();//设置适配器
		setListener();//设置监听
	}

	/**
	 * 设置监听
	 */
	private void setListener() {
		ivSearch.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this,SearchActivity.class);
				startActivity(intent);
			}
		});
	}

	/**
	 * 寻找控件
	 */
	private void findView() {
		mRadioGroup = (RadioGroup) findViewById(R.id.group);//中间的RadioGroup
		mViewPager = (ViewPager) findViewById(R.id.mViewPager);//ViewPager
		ivSearch = (ImageView) findViewById(R.id.IvSearch);//搜索按钮
		radioBtnOnline = (RadioButton) findViewById(R.id.radioBtnOnline);//在线音乐按钮
		radioBtnOnline.setChecked(true);
		radioBtnManager = (RadioButton) findViewById(R.id.radioBtnManager);//音乐管理按钮
		radioBtnPersonal = (RadioButton) findViewById(R.id.radioBtnPersonal);//个人信息按钮
	//按照顺序放
		radioBtns.add(radioBtnOnline);
		radioBtns.add(radioBtnManager);
		radioBtns.add(radioBtnPersonal);


	}

	/**
	 * 设置适配器
	 */
	private void setAdapter() {
		MyAdapter mMyAdapter=new MyAdapter(getSupportFragmentManager());
		mViewPager.setAdapter(mMyAdapter);
	}
	/**
	 * 自定义适配器
	 */
	private class MyAdapter extends FragmentPagerAdapter{
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
	}

	/**
	 * ViewPager的监听
	 */
	private class OnPageListener implements ViewPager.OnPageChangeListener{
		@Override
		public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

		}
		//滚动页面RadioButton进行改变
		public void onPageSelected(int position) {
			radioBtns.get(position).setChecked(true);
		}

		@Override
		public void onPageScrollStateChanged(int state) {

		}
	}

	/**
	 * RadioGroup的点击事件
	 */
	private class  OnCheckedListener implements RadioGroup.OnCheckedChangeListener{
		@Override
		public void onCheckedChanged(RadioGroup group, int checkedId) {
			switch (group.getCheckedRadioButtonId()){
				case R.id.radioBtnOnline:
					mViewPager.setCurrentItem(0);

					break;
				case R.id.radioBtnManager:
					mViewPager.setCurrentItem(1);

					break;
				case R.id.radioBtnPersonal:
					mViewPager.setCurrentItem(2);

					break;
			}
		}
	}

	/**
	 * 数据初始化
	 */
	private void initData() {
		for (int i=0;i<3;i++){
			if(i==0) {
				OnlineContentFragment mContentFragment=new OnlineContentFragment();
				fragments.add(mContentFragment);
			} else if (i==1) {
				LocalContentFragment mContentFragment=new LocalContentFragment();
				fragments.add(mContentFragment);
			} else {
				PersonalContentFragment mContentFragment=new PersonalContentFragment();
				fragments.add(mContentFragment);
			}
		}
	}
}