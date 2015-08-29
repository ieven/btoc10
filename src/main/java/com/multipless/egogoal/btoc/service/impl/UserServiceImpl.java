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

}
