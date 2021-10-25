package com.deal.demo.base;




import com.deal.demo.base.response.ResponseHead;

import java.util.ArrayList;
import java.util.List;

/**
 * @version V1.0
 * @Title: IsResponseList.java <br>
 * @Package com.hzbf.utils.controller <br>
 * @Description: Controller中list数据的通用类 <br>
 * @author: 路逸冰(Allen) <br>
 * @date: 2017/12/27 11:27 <br>
 */
public class IsResponseList {


    public static ResponseHead isOk(List list, ResponseHead responseHead, String interfaceStatus) {
        //不等于空==长度不为0
        if (!list.isEmpty()) {
            return ResponseHttpStatus.successRequest(responseHead, list,interfaceStatus);
        } else {
            return ResponseHttpStatus.errorRequest(responseHead,"error&暂无数据",interfaceStatus);
        }
    }
    public static ResponseHead isOkListNull(List list, ResponseHead responseHead,String interfaceStatus) {
        if (list.size() != 1 && list.get(0) != null) {
            return ResponseHttpStatus.successRequest(responseHead, list,interfaceStatus);
        } else {
            return ResponseHttpStatus.successRequest(responseHead,new ArrayList<>(),interfaceStatus);
        }
    }

    public static ResponseHead isOkNoStatus(List list, ResponseHead responseHead,String interfaceStatus) {
        if (!list.isEmpty()) {
            return ResponseHttpStatus.successRequest(responseHead, list,interfaceStatus);
        } else {
            return ResponseHttpStatus.errorRequest(responseHead,"success&暂无数据",interfaceStatus);
        }
    }
}
