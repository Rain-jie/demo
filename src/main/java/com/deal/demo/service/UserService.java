package com.deal.demo.service;

import java.util.HashMap;
import java.util.Map;

/**
 * 用户相关业务层
 */
public interface UserService {
    /**
     * 用户登录
     * @param userMap
     * @return
     */
    Map<String, Object> loginUser(HashMap<String, Object> userMap);

    /**
     * 用户注册
     * @param userJsonMap
     * @return
     */
    Map<String, Object> registerUser(Map<String, Object> userJsonMap);

    /**
     * 用户信息修改
     * @param userJsonMap
     * @return
     */
    Map<String, Object> updateUser(Map<String, Object> userJsonMap);
}
