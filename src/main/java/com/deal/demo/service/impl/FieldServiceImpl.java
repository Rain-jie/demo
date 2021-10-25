package com.deal.demo.service.impl;

import com.deal.demo.dao.FieldMapper;
import com.deal.demo.model.Activity;
import com.deal.demo.model.Field;
import com.deal.demo.service.FieldService;
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

@Service("fieldService")
public class FieldServiceImpl implements FieldService {
    private Logger logger = LoggerFactory.getLogger(FieldServiceImpl.class);
    @Autowired
    private FieldMapper fieldMapper;
    @Override
    public Map<String, Object> getField(HashMap<String, Object> userMap) {
        Map<String,Object> map=new HashMap<>(2);
        try {
            //当前页码
            Integer pageNum=(Integer) userMap.get("pageNum");
            //每页展示条数
            Integer pageSize=(Integer) userMap.get("pageSize");
            /**
             * 根据用户ID获取该用户所得到的企业赞助
             */
            List<Field> fieldList=fieldMapper.getField();
            if(fieldList.size()<1){
                map.put("type","error&暂无场地信息");
                return map;
            }
            //使用代码进行分页操作
            CustomPageInfo<Field> rewritePageInfo = CustomPageInfoUtil.getRewritePageInfo(fieldList, pageNum, pageSize);
            map.put("type","success&获取场地信息成功");
            map.put("sponserList",rewritePageInfo);
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("获取场地信息出现异常，异常错误为："+e);
            map.put("type","error&获取场地信息出现异常");
            return map;
        }
    }

    @Override
    public Map<String, Object> registerField(Map<String, Object> userJsonMap) {
        Map<String,Object> map=new HashMap<>(2);
        try {
            //场地名称
            String fieldName=(String) userJsonMap.get("fieldName");
            //场地开始使用时间
            String fieldStatusUseTime=(String) userJsonMap.get("fieldStatusUseTime");
            //场地结束使用时间
            String fieldEndUseTime=(String) userJsonMap.get("fieldEndUseTime");
            Field field=new Field();
            field.setFieldName(fieldName);
            field.setFieldStatusUseTime(fieldStatusUseTime);
            field.setFieldEndUseTime(fieldEndUseTime);
            field.setCreateTime(DateUtils.formatNow());
            //新增活动信息
            int i=fieldMapper.insertField(field);
            if(i<1){
                map.put("type","error&新增场地信息失败");
                return map;
            }
            map.put("type","success&新增场地信息成功");
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("新增场地信息出现异常，异常错误为："+e);
            map.put("type","error&新增场地信息出现异常");
            return map;
        }
    }

    @Override
    public Map<String, Object> updateField(Map<String, Object> userJsonMap) {
        Map<String,Object> map=new HashMap<>(2);
        try {
            //场地名称
            Integer fieldId=(Integer) userJsonMap.get("fieldId");
            //场地开始使用时间
            String fieldStatusUseTime=(String) userJsonMap.get("fieldStatusUseTime");
            //场地结束使用时间
            String fieldEndUseTime=(String) userJsonMap.get("fieldEndUseTime");
            Field field=new Field();
            field.setId(fieldId);
            field.setFieldStatusUseTime(fieldStatusUseTime);
            field.setFieldEndUseTime(fieldEndUseTime);
            field.setUpdateTime(DateUtils.formatNow());
            //新增活动信息
            int i=fieldMapper.updateField(field);
            if(i<1){
                map.put("type","error&更新场地信息失败");
                return map;
            }
            map.put("type","success&更新场地信息成功");
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("更新场地信息出现异常，异常错误为："+e);
            map.put("type","error&更新场地信息出现异常");
            return map;
        }
    }

    @Override
    public Map<String, Object> deleteField(Integer fieldId) {
        Map<String,Object> map=new HashMap<>(2);
        try {
            if (fieldId == null || "".equals(fieldId)) {
                map.put("type","error&场地主键ID不存在，请确认后重试");
                return map;
            }
            //新增活动信息
            int i=fieldMapper.deleteField(fieldId);
            if(i<1){
                map.put("type","error&清除场地信息失败");
                return map;
            }
            map.put("type","success&清除场地信息成功");
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("清除场地信息出现异常，异常错误为："+e);
            map.put("type","error&清除场地信息出现异常");
            return map;
        }
    }
}
