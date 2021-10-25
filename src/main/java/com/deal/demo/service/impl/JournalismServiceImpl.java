package com.deal.demo.service.impl;

import com.deal.demo.dao.JournalismMapper;
import com.deal.demo.model.Join;
import com.deal.demo.model.Journalism;
import com.deal.demo.service.JournalismService;
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

@Service("journalismService")
public class JournalismServiceImpl implements JournalismService {
    private Logger logger = LoggerFactory.getLogger(JournalismServiceImpl.class);
    @Autowired
    private JournalismMapper journalismMapper;
    @Override
    public Map<String, Object> getJournalism(HashMap<String, Object> userMap) {
        Map<String,Object> map=new HashMap<String,Object>(2);
        try {
            //当前页码
            Integer pageNum=(Integer) userMap.get("pageNum");
            //每页展示条数
            Integer pageSize=(Integer) userMap.get("pageSize");
            /**
             * 根据用户ID获取该用户所得到的企业赞助
             */
            List<Journalism> joinList=journalismMapper.getJournalism();
            if(joinList.size()<1){
                map.put("type","error&暂无新闻信息");
                return map;
            }
            //使用代码进行分页操作
            CustomPageInfo<Journalism> rewritePageInfo = CustomPageInfoUtil.getRewritePageInfo(joinList, pageNum, pageSize);
            map.put("type","success&获取新闻信息成功");
            map.put("journalismList",rewritePageInfo);
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("获取新闻信息出现异常，异常错误为："+e);
            map.put("type","error&获取新闻信息出现异常");
            return map;
        }
    }

    @Override
    public Map<String, Object> registerJournalism(Map<String, Object> userJsonMap) {
        Map<String,Object> map=new HashMap<String,Object>(2);
        try {
            String journalismName=(String) userJsonMap.get("journalismName");
            String journalismContent=(String) userJsonMap.get("journalismContent");
            String journalismTime=(String) userJsonMap.get("journalismTime");
            String journalismPlace=(String) userJsonMap.get("journalismPlace");
            String journalismPress=(String) userJsonMap.get("journalismPress");
            Journalism journalism=new Journalism();
            journalism.setJournalismName(journalismName);
            journalism.setJournalismContent(journalismContent);
            journalism.setJournalismPlace(journalismPlace);
            journalism.setJournalismPress(journalismPress);
            journalism.setJournalismTime(journalismTime);
            journalism.setCreateTime(DateUtils.formatNow());
            //新增活动信息
            int i=journalismMapper.insertJournalism(journalism);
            if(i<1){
                map.put("type","error&新增新闻信息失败");
                return map;
            }
            map.put("type","success&新增新闻信息成功");
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("新增新闻信息出现异常，异常错误为："+e);
            map.put("type","error&新增新闻信息出现异常");
            return map;
        }
    }

    @Override
    public Map<String, Object> updateJournalism(Map<String, Object> userJsonMap) {
        Map<String,Object> map=new HashMap<String,Object>(2);
        try {
            Integer journalismId=(Integer)userJsonMap.get("journalismId");
            String journalismName=(String) userJsonMap.get("journalismName");
            String journalismContent=(String) userJsonMap.get("journalismContent");
            String journalismTime=(String) userJsonMap.get("journalismTime");
            String journalismPlace=(String) userJsonMap.get("journalismPlace");
            String journalismPress=(String) userJsonMap.get("journalismPress");
            Journalism journalism=new Journalism();
            journalism.setId(journalismId);
            journalism.setJournalismName(journalismName);
            journalism.setJournalismContent(journalismContent);
            journalism.setJournalismPlace(journalismPlace);
            journalism.setJournalismPress(journalismPress);
            journalism.setJournalismTime(journalismTime);
            journalism.setUpdateTime(DateUtils.formatNow());
            //新增活动信息
            int i=journalismMapper.updateJournalism(journalism);
            if(i<1){
                map.put("type","error&更新新闻信息失败");
                return map;
            }
            map.put("type","success&更新新闻信息成功");
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("更新新闻信息出现异常，异常错误为："+e);
            map.put("type","error&更新新闻信息出现异常");
            return map;
        }
    }

    @Override
    public Map<String, Object> deleteJournalism(Integer journalismId) {
        Map<String,Object> map=new HashMap<String,Object>(2);
        try {
            if (journalismId == null || "".equals(journalismId)) {
                map.put("type","error&新闻主键ID不存在，请确认后重试");
                return map;
            }
            //新增活动信息
            int i=journalismMapper.deleteJournalism(journalismId);
            if(i<1){
                map.put("type","error&清除新闻信息失败");
                return map;
            }
            map.put("type","success&清除新闻信息成功");
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("清除新闻信息出现异常，异常错误为："+e);
            map.put("type","error&清除新闻信息出现异常");
            return map;
        }
    }
}
