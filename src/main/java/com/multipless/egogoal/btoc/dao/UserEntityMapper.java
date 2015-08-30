package com.multipless.egogoal.btoc.dao;

import java.util.List;

import com.multipless.egogoal.btoc.entity.UserEntity;

public interface UserEntityMapper {
    int deleteByPrimaryKey(Long autoId);

    int insert(UserEntity record);

    int insertSelective(UserEntity record);

    UserEntity selectByPrimaryKey(Long autoId);

    int updateByPrimaryKeySelective(UserEntity record);

    int updateByPrimaryKey(UserEntity record);
    
    List<UserEntity> getAllUsers();
    
    UserEntity selectByPrimaryKey(String userId);
}