package com.deal.demo.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.*;

/**
 * 用户基础信息实体类
 */
public class User implements Serializable {
    /**
     * 主键ID
     */
    private Integer id;
    /**
     * 用户昵称
     */
    private String  userName;
    /**
     * 用户账号
     */
    private String  userAccount;
    /**
     * 用户密码
     */
    private String  userPassword;
    /**
     * 用户头像
     */
    private String userHead;
    /**
     * 创建时间
     */
    private String  createTime;
    /**
     * 更新时间
     */
    private String updateTime;

    /**
     * get  set 方法
     */
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserHead() {
        return userHead;
    }

    public void setUserHead(String userHead) {
        this.userHead = userHead;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }
}
