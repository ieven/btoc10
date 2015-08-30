package com.multipless.egogoal.btoc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multipless.egogoal.btoc.dao.UserEntityMapper;
import com.multipless.egogoal.btoc.entity.UserEntity;
import com.multipless.egogoal.btoc.service.UserService;

/**
 * @author ChenKai
 * @date 2015年8月29日
 */
@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserEntityMapper userEntityMapper;

	@Override
	public List<UserEntity> getAllUsers() {
		return userEntityMapper.getAllUsers();
	}

	@Override
	public UserEntity selectByPrimaryKey(String userId) {
		return userEntityMapper.selectByPrimaryKey(userId);
	}

	@Override
	public Integer updateUserByUserId(UserEntity userEntity) {
		int status = userEntityMapper.updateByPrimaryKeySelective(userEntity);
		userEntity.setScore("111");//断点到这时，status为1，库中的channel还没有变化，说明整个方法是事务控制的
		return userEntityMapper.updateByPrimaryKeySelective(userEntity);
	}
}
