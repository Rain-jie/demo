package com.deal.demo.model;

import java.io.Serializable;

public class Field implements Serializable {
    /**
     * 主键ID
     */
    private  Integer id;
    /**
     * 场地名称
     */
    private  String fieldName;
    /**
     * 场地开始使用时间
     */
    private  String fieldStatusUseTime;
    /**
     * 场地结束使用时间
     */
    private  String fieldEndUseTime;
    /**
     * 此场地是否正在被使用中
     * 默认为0
     * 0未使用
     * 1已使用
     */
    private  Integer isUse;
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

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldStatusUseTime() {
        return fieldStatusUseTime;
    }

    public void setFieldStatusUseTime(String fieldStatusUseTime) {
        this.fieldStatusUseTime = fieldStatusUseTime;
    }

    public String getFieldEndUseTime() {
        return fieldEndUseTime;
    }

    public void setFieldEndUseTime(String fieldEndUseTime) {
        this.fieldEndUseTime = fieldEndUseTime;
    }

    public Integer getIsUse() {
        return isUse;
    }

    public void setIsUse(Integer isUse) {
        this.isUse = isUse;
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
