package com.lickey.asus.oceanofgod.utils;


import com.lickey.asus.oceanofgod.utils.ACache;
import com.lickey.asus.oceanofgod.utils.ActivityManagerUtil;
import com.umeng.analytics.MobclickAgent;
import com.umeng.analytics.MobclickAgent.EScenarioType;
import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Window;

/**
 * 父类页面，所有activity继承此页面
 */
public abstract class BaseActivity extends Activity {
	public static ACache mACache;
	private Context mContext;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mContext=this;
		requestWindowFeature(Window.FEATURE_NO_TITLE);// 隐藏标题栏
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);// 竖屏显示
		// 将Activity添加到List集合中，方便退出时关闭所有Activity
//		MobclickAgent.setDebugMode(true);
		MobclickAgent.openActivityDurationTrack(false);
		MobclickAgent.setScenarioType(mContext, EScenarioType.E_UM_NORMAL);
		ActivityManagerUtil.getInstance();
		ActivityManagerUtil.addToList(this);
		mACache = ACache.get(this);
		setView();
		initView();
		setListener();
	}

	protected void onResume() {
		super.onResume();
		MobclickAgent.onResume(this);
	}

	protected void onPause() {
		super.onPause();
		MobclickAgent.onPause(this);
	}

	/**
	 * 设置布局文件
	 */
	public abstract void setView();

	/**
	 * 初始化布局文件中的控件
	 */
	public abstract void initView();

	/**
	 * 设置控件的监听
	 */
	public abstract void setListener();
}
