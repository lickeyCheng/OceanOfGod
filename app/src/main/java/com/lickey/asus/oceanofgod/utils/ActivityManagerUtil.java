package com.lickey.asus.oceanofgod.utils;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.util.Log;

/**
 * 
 * Activity管理类
 * 
 */
public class ActivityManagerUtil {

	private static List<Activity> activityList = null;
	private static List<Activity> assignactivityList = null;

	private static ActivityManagerUtil amu = null;

	private ActivityManagerUtil() {

	}

	// 获取ActivityManagerUtil类
	public static ActivityManagerUtil getInstance() {
		if (amu == null) {
			amu = new ActivityManagerUtil();
		}
		if (activityList == null) {
			activityList = new ArrayList<Activity>();
		}
		if (assignactivityList == null) {
			assignactivityList = new ArrayList<Activity>();
		}
		return amu;
	}

	// 添加Activity到List中
	public static void addActivityToList(Activity activity) {
		if (amu != null) {
			assignactivityList.add(activity);
		}
	}

	// 结束掉所有Activity
	public static void finishAssignActivity() {
		if (amu != null) {
			for (Activity act : assignactivityList) {
				if (act != null) {
					act.finish();
				}
			}
		}
	}

	// 添加Activity到List中
	public static void addToList(Activity activity) {
		if (amu != null) {
			activityList.add(activity);
		}
	}

	// 结束掉所有Activity
	public static void finishAllActivity() {
		if (amu != null) {
			for (Activity act : activityList) {
				if (act != null) {
					act.finish();
				}
			}
		}else{
		}
	}

}
