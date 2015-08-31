package com.multipless.egogoal.btoc.utils;

import java.util.ResourceBundle;

/**
 * 应用参数工具类，获得pros/config配置文件中定义的参数
 * 
 * @author ChenKai
 * @date 2015年8月31日
 */
public class PropsLoader {
	private static final String BUNDLE_NAME = "props/config";
	private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);

	private PropsLoader() {
	}

	public static String getString(String key) {
		try {
			String message = RESOURCE_BUNDLE.getString(key);
			return message;
		} catch (Exception e) {
			String message = "不能在配置文件" + BUNDLE_NAME + "中发现参数" + key + "!";
			throw new RuntimeException(message);
		}
	}

}
