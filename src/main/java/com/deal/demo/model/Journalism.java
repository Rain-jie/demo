package com.deal.demo.model;

import java.io.Serializable;

public class Journalism implements Serializable {
    /**
     * 主键ID
     */
    private  Integer id;
    /**
     * 新闻名称
     */
    private  String  journalismName;
    /**
     * 新闻内容
     */
    private  String  journalismContent;
    /**
     * 新闻发布时间
     */
    private  String  journalismTime;
    /**
     * 新闻发布地址
     */
    private  String  journalismPlace;
    /**
     * 新闻出版社
     */
    private  String  journalismPress;
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

    public String getJournalismName() {
        return journalismName;
    }

    public void setJournalismName(String journalismName) {
        this.journalismName = journalismName;
    }

    public String getJournalismContent() {
        return journalismContent;
    }

    public void setJournalismContent(String journalismContent) {
        this.journalismContent = journalismContent;
    }

    public String getJournalismTime() {
        return journalismTime;
    }

    public void setJournalismTime(String journalismTime) {
        this.journalismTime = journalismTime;
    }

    public String getJournalismPlace() {
        return journalismPlace;
    }

    public void setJournalismPlace(String journalismPlace) {
        this.journalismPlace = journalismPlace;
    }

    public String getJournalismPress() {
        return journalismPress;
    }

    public void setJournalismPress(String journalismPress) {
        this.journalismPress = journalismPress;
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
