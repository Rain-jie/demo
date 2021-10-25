package com.deal.demo.dao;

import com.deal.demo.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;

/**
 * 用户相关SQl
 */
@Mapper
public interface UserMapper {
    /**
     * 根据用户账号，及密码查询用户信息
     * @param usersMap
     * @return
     */
    User selectUser(HashMap<String, Object> usersMap);

    /**
     * 用户注册
     * @param user 参数集
     * @return
     */
    int insertUser(User user);

    /**
     * 更新用户基础信息
     * @param user
     * @return
     */
    int updateUser(User user);
}
