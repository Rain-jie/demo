package com.deal.demo.service.impl;

import com.deal.demo.dao.UserMapper;
import com.deal.demo.model.User;
import com.deal.demo.service.UserService;
import com.deal.demo.utils.md5.MD5Util;
import com.deal.demo.utils.trapeze.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * 用户相关业务层实现类
 */
@Service(value = "userServiceImpl")
public class UserServiceImpl implements UserService {
    //日志
    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    private UserMapper userMapper;
    /**
     * 用户登录
     * @param userMap
     * @return
     */
    @Override
    public Map<String, Object> loginUser(HashMap<String, Object> userMap) {
        Map<String,Object> map=new HashMap<>(2);
        try {
            //用户账号
            String userAccount=(String) userMap.get("userAccount");
            //用户密码
            String userPassword=(String) userMap.get("userPassword");
            //查询参数集
            HashMap<String, Object> usersMap = new HashMap<>();
            usersMap.put("userAccount",userAccount);
            //根据用户账号获取用户密码，看用户传入的密码是否正确
            User users = userMapper.selectUser(usersMap);
            if(users == null){
                map.put("type","error&该用户不存在");
                return map;
            }
            String password = users.getUserPassword();
            //加密后的密码
            String md5ofStr = MD5Util.getMD5ofStr(userPassword);
            boolean equals = password.equals(md5ofStr);
            if(equals == false){
                map.put("type","error&用户密码错误请输入正确密码");
                return map;
            }
            usersMap.put("userPassword",md5ofStr);
            User user = userMapper.selectUser(usersMap);
            if(user == null){
                map.put("type","error&获取用户信息失败");
                return map;
            }
            map.put("type","success&获取用户信息成功");
            map.put("user",user);
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("获取用户信息出现异常，异常错误为："+e);
            map.put("type","error&获取用户信息出现异常");
            return map;
        }
    }

    /**
     * 用户注册
     * @param userJsonMap
     * @return
     */
    @Override
    public Map<String, Object> registerUser(Map<String, Object> userJsonMap) {
        Map<String,Object> map=new HashMap<>(1);
        try {
            //用户账号
            String userAccount=(String) userJsonMap.get("userAccount");
            //用户密码
            String userPassword=(String) userJsonMap.get("userPassword");
            //用户昵称
            String userName=(String) userJsonMap.get("userName");
            //查询参数集
            HashMap<String, Object> usersMap = new HashMap<>();
            usersMap.put("userAccount",userAccount);
            //根据用户账号获取用户密码，看用户传入的密码是否正确
            User users = userMapper.selectUser(usersMap);
            if(users != null){
                map.put("type","error&该账号已被注册");
                return map;
            }
            //封装注册参数集
            User user=new User();
            user.setUserName(userName);
            //加密后的密码
            String md5ofStr = MD5Util.getMD5ofStr(userPassword);
            user.setUserPassword(md5ofStr);
            //用户账号
            user.setUserAccount(userAccount);
            //用户创建时间
            user.setCreateTime(DateUtils.formatNow());
            //进行用户注册
            int i=userMapper.insertUser(user);
            if(i < 1){
                map.put("type","error&该账号注册失败，请稍后重试");
                return map;
            }
            map.put("type","success");
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("注册用户信息出现异常，异常错误为："+e);
            map.put("type","error&注册用户信息出现异常");
            return map;
        }
    }

    /**
     * 用户信息修改
     * @param userJsonMap
     * @return
     */
    @Override
    public Map<String, Object> updateUser(Map<String, Object> userJsonMap) {
        Map<String,Object> map=new HashMap<>(1);
        try {
            Integer userId=(Integer)userJsonMap.get("userId");
            //用户密码
            String userPassword=(String) userJsonMap.get("userPassword");
            //用户昵称
            String userName=(String) userJsonMap.get("userName");
            //封装注册参数集
            User user=new User();
            user.setId(userId);
            user.setUserName(userName);
            //加密后的密码
            String md5ofStr = MD5Util.getMD5ofStr(userPassword);
            user.setUserPassword(md5ofStr);
            //用户创建时间
            user.setUpdateTime(DateUtils.formatNow());
            //进行用户注册
            int i=userMapper.updateUser(user);
            if(i < 1){
                map.put("type","error&该账号信息更新失败，请稍后重试");
                return map;
            }
            map.put("type","success");
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("更新用户信息出现异常，异常错误为："+e);
            map.put("type","error&更新用户信息出现异常");
            return map;
        }
    }
}
