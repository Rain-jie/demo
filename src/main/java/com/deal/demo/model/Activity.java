package com.deal.demo.model;

import java.io.Serializable;

public class Activity implements Serializable {
    private  Integer id;
    /**
     * 活动名称
     */
    private  String  activityName;
    /**
     * 活动内容
     */
    private  String  activityContent;
    /**
     * 活动负责人
     */
    private  String  activityPersonName;
    /**
     * 活动开始时间
     */
    private  String  activityStatusTime;
    /**
     * 活动结束时间
     */
    private  String  activityEndTime;
    /**
     * 活动场地
     */
    private  String  activityField;
    /**
     * 参与活动的人员数量
     */
    private  Integer activityNumber;
    /**
     * 创建时间
     */
    private  String  createTime;
    /**
     * 更新时间
     */
    private  String  updateTime;

    /**
     * get set 方法
     */
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

    public String getActivityContent() {
        return activityContent;
    }

    public void setActivityContent(String activityContent) {
        this.activityContent = activityContent;
    }

    public String getActivityPersonName() {
        return activityPersonName;
    }

    public void setActivityPersonName(String activityPersonName) {
        this.activityPersonName = activityPersonName;
    }

    public String getActivityStatusTime() {
        return activityStatusTime;
    }

    public void setActivityStatusTime(String activityStatusTime) {
        this.activityStatusTime = activityStatusTime;
    }

    public String getActivityEndTime() {
        return activityEndTime;
    }

    public void setActivityEndTime(String activityEndTime) {
        this.activityEndTime = activityEndTime;
    }

    public String getActivityField() {
        return activityField;
    }

    public void setActivityField(String activityField) {
        this.activityField = activityField;
    }

    public Integer getActivityNumber() {
        return activityNumber;
    }

    public void setActivityNumber(Integer activityNumber) {
        this.activityNumber = activityNumber;
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
