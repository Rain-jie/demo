package com.deal.demo.dao;

import com.deal.demo.model.Activity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ActivityMapper {
    /**
     * 获取所有的活动信息
     * @return
     */
    List<Activity> getActivity();

    /**
     * 新增活动信息
     * @param activity
     * @return
     */
    int insertSelective(Activity activity);

    /**
     * 更新活动信息
     * @param activity
     * @return
     */
    int updateActivity(Activity activity);

    /**
     * 根据主键ID查询此信息是否存在
     * @param activityId
     * @return
     */
    Activity selectActivity(Integer activityId);

    /**
     * 清除活动信息
     * @param activityId
     * @return
     */
    int deleteActivity(Integer activityId);
}
