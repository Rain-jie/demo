package com.deal.demo.service.impl;

import com.deal.demo.dao.JoinMapper;
import com.deal.demo.model.Field;
import com.deal.demo.model.Join;
import com.deal.demo.service.JoinService;
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

@Service("joinService")
public class JoinServiceImpl implements JoinService {
    private Logger logger = LoggerFactory.getLogger(JoinServiceImpl.class);
    @Autowired
    private JoinMapper joinMapper;

    /**
     * 获取参与活动人数
     * @param userMap
     * @return
     */
    @Override
    public Map<String, Object> getJoinActivity(HashMap<String, Object> userMap) {
        Map<String,Object> map=new HashMap<String,Object>(2);
        try {
            //当前页码
            Integer pageNum=(Integer) userMap.get("pageNum");
            //每页展示条数
            Integer pageSize=(Integer) userMap.get("pageSize");
            /**
             * 根据用户ID获取该用户所得到的企业赞助
             */
            List<Join> joinList=joinMapper.getJoinActivity();
            if(joinList.size()<1){
                map.put("type","error&暂无场地信息");
                return map;
            }
            //使用代码进行分页操作
            CustomPageInfo<Join> rewritePageInfo = CustomPageInfoUtil.getRewritePageInfo(joinList, pageNum, pageSize);
            map.put("type","success&获取场地信息成功");
            map.put("joinList",rewritePageInfo);
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("获取场地信息出现异常，异常错误为："+e);
            map.put("type","error&获取场地信息出现异常");
            return map;
        }
    }

    /**
     * 新增参与活动人员管理
     * @param userJsonMap
     * @return
     */
    @Override
    public Map<String, Object> registerJoinActivity(Map<String, Object> userJsonMap) {
        Map<String,Object> map=new HashMap<String,Object>(2);
        try {
            //场地名称
            String joinName=(String) userJsonMap.get("joinName");
            //场地开始使用时间
            String joinActivityName=(String) userJsonMap.get("joinActivityName");
            Join join=new Join();
            join.setJoinName(joinName);
            join.setJoinActivityName(joinActivityName);
            join.setCreateTime(DateUtils.formatNow());
            //新增活动信息
            int i=joinMapper.insertJoin(join);
            if(i<1){
                map.put("type","error&新增参与活动人员信息失败");
                return map;
            }
            map.put("type","success&新增参与活动人员信息成功");
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("新增参与活动人员信息出现异常，异常错误为："+e);
            map.put("type","error&新增参与活动人员信息出现异常");
            return map;
        }
    }

    @Override
    public Map<String, Object> updateJoinActivity(Map<String, Object> userJsonMap) {
        Map<String,Object> map=new HashMap<String,Object>(2);
        try {
            Integer joinActivityId=(Integer)userJsonMap.get("joinActivityId");
            String joinName=(String) userJsonMap.get("joinName");
            String joinActivityName=(String) userJsonMap.get("joinActivityName");
            Join join=new Join();
            join.setId(joinActivityId);
            join.setJoinName(joinName);
            join.setJoinActivityName(joinActivityName);
            join.setUpdateTime(DateUtils.formatNow());
            //新增活动信息
            int i=joinMapper.updateJoinActivity(join);
            if(i<1){
                map.put("type","error&更新参与活动人员信息失败");
                return map;
            }
            map.put("type","success&更新参与活动人员信息成功");
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("更新参与活动人员信息出现异常，异常错误为："+e);
            map.put("type","error&更新参与活动人员信息出现异常");
            return map;
        }
    }

    @Override
    public Map<String, Object> deleteJoinActivity(Integer joinActivityId) {
        Map<String,Object> map=new HashMap<String,Object>(2);
        try {
            if (joinActivityId == null || "".equals(joinActivityId)) {
                map.put("type","error&场地主键ID不存在，请确认后重试");
                return map;
            }
            //新增活动信息
            int i=joinMapper.deleteJoinActivity(joinActivityId);
            if(i<1){
                map.put("type","error&清除参与人员信息失败");
                return map;
            }
            map.put("type","success&清除参与人员信息成功");
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("清除参与人员信息出现异常，异常错误为："+e);
            map.put("type","error&清除参与人员信息出现异常");
            return map;
        }
    }
}
