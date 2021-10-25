package com.deal.demo.model;

import java.io.Serializable;

public class ActivityFunds implements Serializable {
    private  Integer id;
    private  String  activityName;
    private  Integer activityFunds;
    private  String createTime;
    private  String updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public Integer getActivityFunds() {
        return activityFunds;
    }

    public void setActivityFunds(Integer activityFunds) {
        this.activityFunds = activityFunds;
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
