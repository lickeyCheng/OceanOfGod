package com.lickey.asus.oceanofgod.utils;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class GsonUtil {

	private static Gson gson = null;

	private GsonUtil() {
	}

	public static Gson getInstance() {
		if (gson == null) {
			gson = new Gson();
		}
		return gson;
	}
	/**
	 * 
	 * @param obj实体类对象
	 * @return json字符串
	 */
	public static String objectToJson(Object obj){
		Gson gson = GsonUtil.getInstance();
//		System.out.println("json字符串:"+gson.toJson(obj));
		Log.e("json:", gson.toJson(obj));
		return gson.toJson(obj);
	}
	/**
	 * 
	 * @param json json字符串
	 * @param cls 转换的类型
	 * @return 返回一个泛型
	 */
	public static <T> T jsonToObject(String json , Class<T> cls){
		Gson gson = GsonUtil.getInstance();
		gson.fromJson(json, cls);
		return gson.fromJson(json, cls);
	}
	
	/**
	 * 
	 * @param <E>
	 * @param json json字符串
	 * @param cls 转换的类型
	 * @return 返回一个泛型
	 */
	public static <T, E> T jsonToObject(String json , TypeToken<E> t){
		Gson gson = GsonUtil.getInstance();
		return gson.fromJson(json, t.getType());
	}
}
