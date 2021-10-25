package com.deal.demo.model;

import java.io.Serializable;

public class Join implements Serializable {
    /**
     * 主键ID
     */
    private  Integer id;
    /**
     * 参与人姓名
     */
    private  String joinName;
    /**
     * 参与活动
     */
    private  String joinActivityName;
    /**
     * 创建时间
     */
    private  String createTime;
    /**
     * 更新时间
     */
    private  String updateTime;
    /**
     * get set
     */
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getJoinName() {
        return joinName;
    }

    public void setJoinName(String joinName) {
        this.joinName = joinName;
    }

    public String getJoinActivityName() {
        return joinActivityName;
    }

    public void setJoinActivityName(String joinActivityName) {
        this.joinActivityName = joinActivityName;
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
