package com.deal.demo.service;

import java.util.HashMap;
import java.util.Map;

public interface ActivityService {
    /**
     * 获取所有活动信息
     * @param userMap
     * @return
     */
    Map<String, Object> getActivity(HashMap<String, Object> userMap);

    /**
     * 新增活动
     * @param userJsonMap
     * @return
     */
    Map<String, Object> registerActivity(Map<String, Object> userJsonMap);

    /**
     * 更新活动信息
     * @param userJsonMap
     * @return
     */
    Map<String, Object> updateActivity(Map<String, Object> userJsonMap);

    /**
     * 清除活动信息
     * @param activityId
     * @return
     */
    Map<String, Object> deleteActivity(Integer activityId);
}
