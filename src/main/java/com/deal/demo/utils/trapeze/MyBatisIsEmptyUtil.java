package com.deal.demo.utils.trapeze;

import java.util.Collection;

/**
 * @package  包名：com.hzbf.utils.utils
 * @fileName 类名：MyBatisIsEmptyUtil.java
 * @author   创建人：路逸冰(luyibing)
 * @date	 创建时间：2019/4/7 22:18
 * @Description	创建内容：(判断对象是否为0和空字符串等，用于mapper.xml的if标签中)
 * @version  版本号：1.0.0
 */
public class MyBatisIsEmptyUtil {

    //判断空对象
    public static boolean isEmpty(Object obj){
        if(null == obj){
            return true;
        }else if(obj instanceof String){
            if(((String) obj).trim().length() == 0){
                return true;
            }
        }else if(obj instanceof Collection){
            if(((Collection) obj).isEmpty()){
                return true;
            }
        } else if(obj.getClass().isArray()){
            if(((Object[]) obj).length == 0){
                return true;
            }
        } else if(obj instanceof Long){
            if(((Long) obj) == null){
                return true;
            }
        } else if(obj instanceof Integer){
            if(((Integer) obj) == null){
                return true;
            }
        } else{
            return false;
        }
        return false;
    }

    //mapper中引用此方法进行判断空内容,示例参考TUserMapper.xml中的，getUserForList方法
    public static boolean isNotEmpty(Object obj){

        return !isEmpty(obj);
    }
}