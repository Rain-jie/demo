package com.deal.demo.service.impl;

import com.deal.demo.dao.ActivityFundsMapper;
import com.deal.demo.model.ActivityFunds;
import com.deal.demo.model.Journalism;
import com.deal.demo.service.ActivityFundsService;
import com.deal.demo.utils.page.CustomPageInfo;
import com.deal.demo.utils.page.CustomPageInfoUtil;
import com.deal.demo.utils.trapeze.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.List;
import java.util.Map;

@Service("activityFundsService")
public class ActivityFundsServiceImpl implements ActivityFundsService {
    private Logger logger = LoggerFactory.getLogger(ActivityFundsServiceImpl.class);
    @Autowired
    private ActivityFundsMapper activityFundsMapper;
    @Override
    public Map<String, Object> getActivityFunds(HashMap<String, Object> userMap) {
        Map<String,Object> map=new HashMap<String,Object>(2);
        try {
            //当前页码
            Integer pageNum=(Integer) userMap.get("pageNum");
            //每页展示条数
            Integer pageSize=(Integer) userMap.get("pageSize");
            /**
             * 根据用户ID获取该用户所得到的企业赞助
             */
            List<ActivityFunds> joinList=activityFundsMapper.getActivityFunds();
            if(joinList.size()<1){
                map.put("type","error&暂无活动经费信息");
                return map;
            }
            //使用代码进行分页操作
            CustomPageInfo<ActivityFunds> rewritePageInfo = CustomPageInfoUtil.getRewritePageInfo(joinList, pageNum, pageSize);
            map.put("type","success&获取活动经费信息成功");
            map.put("activityFundsList",rewritePageInfo);
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("获取活动经费信息出现异常，异常错误为："+e);
            map.put("type","error&获取新闻信息出现异常");
            return map;
        }
    }

    @Override
    public Map<String, Object> registerActivityFunds(Map<String, Object> userJsonMap) {
        Map<String,Object> map=new HashMap<String,Object>(2);
        try {
            String activityName=(String) userJsonMap.get("activityName");
            Integer activityFundss=(Integer) userJsonMap.get("activityFunds");
            ActivityFunds activityFunds=new ActivityFunds();
            activityFunds.setActivityName(activityName);
            activityFunds.setActivityFunds(activityFundss);
            activityFunds.setCreateTime(DateUtils.formatNow());
            //新增活动信息
            int i=activityFundsMapper.registerActivityFunds(activityFunds);
            if(i<1){
                map.put("type","error&新增活动经费信息失败");
                return map;
            }
            map.put("type","success&新增活动经费信息成功");
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("新增活动经费信息出现异常，异常错误为："+e);
            map.put("type","error&新增活动经费信息出现异常");
            return map;
        }
    }

    @Override
    public Map<String, Object> updateActivityFunds(Map<String, Object> userJsonMap) {
        Map<String,Object> map=new HashMap<String,Object>(2);
        try {
            Integer activityFundsId = (Integer)userJsonMap.get("activityFundsId");
            String activityName=(String) userJsonMap.get("activityName");
            Integer activityFundss=(Integer) userJsonMap.get("activityFunds");
            ActivityFunds activityFunds=new ActivityFunds();
            activityFunds.setId(activityFundsId);
            activityFunds.setActivityName(activityName);
            activityFunds.setActivityFunds(activityFundss);
            activityFunds.setUpdateTime(DateUtils.formatNow());
            //新增活动信息
            int i=activityFundsMapper.updateActivityFunds(activityFunds);
            if(i<1){
                map.put("type","error&更新活动经费信息失败");
                return map;
            }
            map.put("type","success&更新活动经费信息成功");
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("更新活动经费信息出现异常，异常错误为："+e);
            map.put("type","error&更新活动经费信息出现异常");
            return map;
        }
    }

    @Override
    public Map<String, Object> deleteActivityFunds(Integer activityFundsId) {
        Map<String,Object> map=new HashMap<String,Object>(2);
        try {
            if (activityFundsId == null || "".equals(activityFundsId)) {
                map.put("type","error&活动经费主键ID不存在，请确认后重试");
                return map;
            }
            //新增活动信息
            int i=activityFundsMapper.deleteActivityFunds(activityFundsId);
            if(i<1){
                map.put("type","error&清除活动经费信息失败");
                return map;
            }
            map.put("type","success&清除活动经费信息成功");
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("清除活动经费信息出现异常，异常错误为："+e);
            map.put("type","error&清除活动经费信息出现异常");
            return map;
        }
    }
}
