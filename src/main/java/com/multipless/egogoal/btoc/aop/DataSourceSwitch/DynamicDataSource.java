package com.multipless.egogoal.btoc.aop.DataSourceSwitch;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @author ChenKai
 * @date 2015年9月1日
 */
public class DynamicDataSource extends AbstractRoutingDataSource{

	@Override
	protected Object determineCurrentLookupKey() {
		return DataSourceSwitcher.getDataSource();
	}

}
