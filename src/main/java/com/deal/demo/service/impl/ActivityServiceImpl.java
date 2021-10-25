package com.deal.demo.service.impl;

import com.deal.demo.dao.ActivityMapper;
import com.deal.demo.model.Activity;
import com.deal.demo.model.Sponsor;
import com.deal.demo.service.ActivityService;
import com.deal.demo.utils.page.CustomPageInfo;
import com.deal.demo.utils.page.CustomPageInfoUtil;
import com.deal.demo.utils.trapeze.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service(value = "activityService")
public class ActivityServiceImpl implements ActivityService {
    //日志
    private Logger logger = LoggerFactory.getLogger(ActivityServiceImpl.class);
    @Autowired
    private ActivityMapper activityMapper;

    /**
     * 获取所有活动信息
     * @param userMap
     * @return
     */
    @Override
    public Map<String, Object> getActivity(HashMap<String, Object> userMap) {
        Map<String,Object> map=new HashMap<>(2);
        try {
            //当前页码
            Integer pageNum=(Integer) userMap.get("pageNum");
            //每页展示条数
            Integer pageSize=(Integer) userMap.get("pageSize");
            /**
             * 根据用户ID获取该用户所得到的企业赞助
             */
            List<Activity> activityList=activityMapper.getActivity();
            if(activityList.size()<1){
                map.put("type","error&暂无活动信息");
                return map;
            }
            //使用代码进行分页操作
            CustomPageInfo<Activity> rewritePageInfo = CustomPageInfoUtil.getRewritePageInfo(activityList, pageNum, pageSize);
            map.put("type","success&获取活动信息成功");
            map.put("sponserList",rewritePageInfo);
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("获取活动信息出现异常，异常错误为："+e);
            map.put("type","error&获取活动信息出现异常");
            return map;
        }
    }

    /**
     * 新增活动信息
     * @param userJsonMap
     * @return
     */
    @Override
    public Map<String, Object> registerActivity(Map<String, Object> userJsonMap) {
        Map<String,Object> map=new HashMap<>(2);
        try {
            //活动名称
            String activityName=(String) userJsonMap.get("activityName");
            //活动内容
            String activityContent=(String) userJsonMap.get("activityContent");
            //活动开始时间
            String activityStatusTime=(String) userJsonMap.get("activityStatusTime");
            //活动结束时间
            String activityEndTime=(String) userJsonMap.get("activityEndTime");
            //活动场地
            String activityField=(String) userJsonMap.get("activityField");
            //活动参与人数
            Integer activityNumber=(Integer) userJsonMap.get("activityNumber");
            //活动负责人
            String activityPersonName=(String) userJsonMap.get("activityPersonName");

            Activity activity=new Activity();
            //活动名称
            activity.setActivityName(activityName);
            //活动内容
            activity.setActivityContent(activityContent);
            //活动负责人
            activity.setActivityPersonName(activityPersonName);
            //活动开始时间
            activity.setActivityStatusTime(activityStatusTime);
            //活动结束时间
            activity.setActivityEndTime(activityEndTime);
            //活动场地
            activity.setActivityField(activityField);
            //活动参与人数
            activity.setActivityNumber(activityNumber);
            //创建时间
            activity.setCreateTime(DateUtils.formatNow());
            //新增活动信息
            int i=activityMapper.insertSelective(activity);
            if(i<1){
                map.put("type","error&新增活动信息失败");
                return map;
            }
            map.put("type","success&新增活动信息成功");
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("新增活动信息出现异常，异常错误为："+e);
            map.put("type","error&新增活动信息出现异常");
            return map;
        }
    }

    /**
     * 更新活动信息
     * @param userJsonMap
     * @return
     */
    @Override
    public Map<String, Object> updateActivity(Map<String, Object> userJsonMap) {
        Map<String,Object> map=new HashMap<>(2);
        try {
            //活动名称
            Integer activityId=(Integer) userJsonMap.get("activityId");
            //活动内容
            String activityContent=(String) userJsonMap.get("activityContent");
            //活动开始时间
            String activityStatusTime=(String) userJsonMap.get("activityStatusTime");
            //活动结束时间
            String activityEndTime=(String) userJsonMap.get("activityEndTime");
            //活动场地
            String activityField=(String) userJsonMap.get("activityField");
            //活动参与人数
            Integer activityNumber=(Integer) userJsonMap.get("activityNumber");
            //活动负责人
            String activityPersonName=(String) userJsonMap.get("activityPersonName");

            //根据主键ID查询此信息是否真的存在
            Activity activity1 = activityMapper.selectActivity(activityId);
            if (activity1 == null) {
                map.put("type","error&此活动信息不存在,请确认后重试");
                return map;
            }
            //封装参数集
            Activity activity=new Activity();
            //主键ID
            activity.setId(activityId);
            //活动内容
            activity.setActivityContent(activityContent);
            //活动负责人
            activity.setActivityPersonName(activityPersonName);
            //活动开始时间
            activity.setActivityStatusTime(activityStatusTime);
            //活动结束时间
            activity.setActivityEndTime(activityEndTime);
            //活动场地
            activity.setActivityField(activityField);
            //活动参与人数
            activity.setActivityNumber(activityNumber);
            //更新时间
            activity.setUpdateTime(DateUtils.formatNow());
            //新增活动信息
            int i=activityMapper.updateActivity(activity);
            if(i<1){
                map.put("type","error&更新活动信息失败");
                return map;
            }
            map.put("type","success&更新活动信息成功");
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("更新活动信息出现异常，异常错误为："+e);
            map.put("type","error&更新活动信息出现异常");
            return map;
        }
    }

    @Override
    public Map<String, Object> deleteActivity(Integer activityId) {
        Map<String,Object> map=new HashMap<>(2);
        try {
            if(activityId == null || "".equals(activityId)){
                map.put("type","error&活动信息主键不得为空或空字符串");
                return map;
            }
            int i=activityMapper.deleteActivity(activityId);
            if(i<1){
                map.put("type","error&清除活动信息失败");
                return map;
            }
            map.put("type","success&清除活动信息成功");
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("清除活动信息出现异常，异常错误为："+e);
            map.put("type","error&清除活动信息出现异常");
            return map;
        }
    }
}
