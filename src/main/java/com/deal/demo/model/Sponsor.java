package com.deal.demo.model;

import java.io.Serializable;

/**
 * 赞助企业基础信息表
 */
public class Sponsor implements Serializable {
    /**
     * 主键Id
     */
    private Integer id;
    /**
     * 企业名称
     */
    private String  sponsorName;
    /**
     * 企业负责人
     */
    private String  sponsorPersonName;
    /**
     * 赞助资金
     * 单位：分
     */
    private Integer sponsorPrice;
    /**
     * 赞助活动
     */
    private String sponsorActivity;
    /**
     * 创建时间
     */
    private String  createTime;
    /**
     * 更新时间
     */
    private String updateTime;

    /**
     * 用户信息
     */
    private User user;
    /**
     * get set 方法
     */
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getSponsorName() {
        return sponsorName;
    }

    public void setSponsorName(String sponsorName) {
        this.sponsorName = sponsorName;
    }

    public String getSponsorPersonName() {
        return sponsorPersonName;
    }

    public void setSponsorPersonName(String sponsorPersonName) {
        this.sponsorPersonName = sponsorPersonName;
    }

    public Integer getSponsorPrice() {
        return sponsorPrice;
    }

    public void setSponsorPrice(Integer sponsorPrice) {
        this.sponsorPrice = sponsorPrice;
    }

    public String getSponsorActivity() {
        return sponsorActivity;
    }

    public void setSponsorActivity(String sponsorActivity) {
        this.sponsorActivity = sponsorActivity;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
