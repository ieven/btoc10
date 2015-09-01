package com.multipless.egogoal.btoc.aop.DataSourceSwitch;

import org.springframework.util.Assert;


/**
 * @author ChenKai
 * @date 2015年9月1日
 */
public class DataSourceSwitcher {
	private static final ThreadLocal contextHolder = new ThreadLocal();

	private static void setDataSource(String dataSource) {
		Assert.notNull(dataSource, "dataSource cannot be null");
		contextHolder.set(dataSource);
	}

	public static void setMaster() {
		clearDataSource();
	}

	public static void setSlave() {
		setDataSource("slave");
	}
	
	public static String getDataSource() {
		return (String) contextHolder.get();
	}
	private static void clearDataSource() {
		contextHolder.remove();
	}
}
