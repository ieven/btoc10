package com.multipless.egogoal.btoc.service;

import java.util.List;

import com.multipless.egogoal.btoc.entity.UserEntity;

/**
 * @author ChenKai
 * @date 2015年8月29日
 */
public interface UserService{
	List<UserEntity> getAllUsers();
	UserEntity selectByPrimaryKey(String autoId);
	
	/**
	 *更新用户表，测试aop的事务控制配置是否起效果
	 */
	Integer updateUserByUserId(UserEntity userEntity);
}
	
