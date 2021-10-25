package com.deal.demo.service.impl;

import com.deal.demo.dao.SponsorMapper;
import com.deal.demo.model.Sponsor;
import com.deal.demo.model.User;
import com.deal.demo.service.SponsorService;
import com.deal.demo.utils.md5.MD5Util;
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

@Service(value = "sponsorService")
public class SponsorServiceImpl implements SponsorService {
    //日志
    private Logger logger = LoggerFactory.getLogger(SponsorServiceImpl.class);
    @Autowired
    private SponsorMapper sponsorMapper;

    /**
     * 获取赞助企业方法
     * @param userMap
     * @return
     */
    @Override
    public Map<String, Object> getSponsor(HashMap<String, Object> userMap) {
        Map<String,Object> map=new HashMap<>(2);
        try {
            //当前页码
            Integer pageNum=(Integer) userMap.get("pageNum");
            //每页展示条数
            Integer pageSize=(Integer) userMap.get("pageSize");
            //查询参数集
            HashMap<String, Object> sponsorMap = new HashMap<>(1);
            /**
             * 根据用户ID获取该用户所得到的企业赞助
             */
            List<Sponsor> sponsorList=sponsorMapper.getSponsor(sponsorMap);
            if(sponsorList.size()<1){
                map.put("type","error&该用户暂无赞助企业");
                return map;
            }
            //使用代码进行分页操作
            CustomPageInfo<Sponsor> rewritePageInfo = CustomPageInfoUtil.getRewritePageInfo(sponsorList, pageNum, pageSize);
            map.put("type","success&获取赞助企业信息成功");
            map.put("sponserList",rewritePageInfo);
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("获取赞助企业信息出现异常，异常错误为："+e);
            map.put("type","error&获取赞助企业信息出现异常");
            return map;
        }
    }

    /**
     * 新增赞助企业信息
     * @param userJsonMap
     * @return
     */
    @Override
    public Map<String, Object> registerSponsor(Map<String, Object> userJsonMap) {
        Map<String,Object> map=new HashMap<>(2);
        try {
            //赞助企业
            String sponsorName=(String) userJsonMap.get("sponsorName");
            //赞助负责人
            String sponsorPersonName=(String) userJsonMap.get("sponsorPersonName");
            //赞助金额 单位：分
            Integer sponsorPrice=(Integer) userJsonMap.get("sponsorPrice");
            //赞助活动
            String sponsorActivity=(String) userJsonMap.get("sponsorActivity");
            //封装新增赞助企业参数集
            Sponsor sponsor=new Sponsor();
            //用户ID
            //赞助企业
            sponsor.setSponsorName(sponsorName);
            //赞助负责人
            sponsor.setSponsorPersonName(sponsorPersonName);
            //赞助金额
            sponsor.setSponsorPrice(sponsorPrice);
            //赞助活动
            sponsor.setSponsorActivity(sponsorActivity);
            //创建时间
            sponsor.setCreateTime(DateUtils.formatNow());
            int i=sponsorMapper.insertSponsor(sponsor);
            if(i<1){
                map.put("type","error&新增赞助企业信息失败,请稍后重试");
                return map;
            }
            map.put("type","success&新增赞助企业信息成功");
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("新增赞助企业信息出现异常，异常错误为："+e);
            map.put("type","error&新增赞助企业信息出现异常");
            return map;
        }
    }

    /**
     * 更新赞助企业信息
     * @param userJsonMap
     * @return
     */
    @Override
    public Map<String, Object> updateSponsor(Map<String, Object> userJsonMap) {
        Map<String,Object> map=new HashMap<>(2);
        try {
            //用户ID
            Integer sponsorId=(Integer) userJsonMap.get("sponsorId");
            //赞助负责人
            String sponsorPersonName=(String) userJsonMap.get("sponsorPersonName");

            Sponsor sponsora=sponsorMapper.selectSponsor(sponsorId);
            if(sponsora == null){
                map.put("type","error&此赞助企业信息不存在,请确认后重试");
                return map;
            }
            //封装新增赞助企业参数集
            Sponsor sponsor=new Sponsor();
            sponsor.setId(sponsorId);
            //赞助负责人
            sponsor.setSponsorPersonName(sponsorPersonName);
            //创建时间
            sponsor.setUpdateTime(DateUtils.formatNow());
            int i=sponsorMapper.updateSponsor(sponsor);
            if(i<1){
                map.put("type","error&更新赞助企业信息失败,请稍后重试");
                return map;
            }
            map.put("type","success&更新赞助企业信息成功");
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("更新赞助企业信息出现异常，异常错误为："+e);
            map.put("type","error&更新赞助企业信息出现异常");
            return map;
        }
    }

    @Override
    public Map<String, Object> deleteSponsor(Integer sponsorId) {
        Map<String,Object> map=new HashMap<>(2);
        try {
            Sponsor sponsora=sponsorMapper.selectSponsor(sponsorId);
            if(sponsora == null){
                map.put("type","error&此赞助企业信息不存在,请确认后重试");
                return map;
            }
            int i=sponsorMapper.deleteSponsor(sponsorId);
            if(i<1){
                map.put("type","error&清除赞助企业信息失败,请稍后重试");
                return map;
            }
            map.put("type","success&清除赞助企业信息成功");
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("清除赞助企业信息出现异常，异常错误为："+e);
            map.put("type","error&清楚赞助企业信息出现异常");
            return map;
        }
    }
}
