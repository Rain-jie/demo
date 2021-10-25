package com.deal.demo.base;


import com.deal.demo.base.response.ResponseBody;
import com.deal.demo.base.response.ResponseHead;
import com.deal.demo.base.response.ResponseSatus;
//import com.deal.demo.utils.redis.JedisUtil;

/**
 * @version V1.0
 * @Title: BaseController.java <br>
 * @Package com.jxp.utils.base <br>
 * @Description: (所有controller的基类, 默认失败) <br>
 * @author: 路逸冰(Allen) <br>
 * @date: 2019/11/20 19:39 <br>
 */
public class BaseController {

   // protected JedisUtil jedisUtil = JedisUtil.getInstance();

    public ResponseHead createResponse() {
        //默认响应头
        ResponseHead responseHead = new ResponseHead();
        //默认响应体
        ResponseBody responseBody = new ResponseBody();
        responseHead.setCode(ResponseSatus.INTERNAL_SERVER_ERROR.getValue());
        responseHead.setMessage(ResponseSatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
        responseHead.setInterfaceStatus(ResponseSatus.INTERFACE_LOCK.getReasonPhrase());
        responseBody.setResStatus(ResponseSatus.ERROR_REQUEST.getValue());
        responseBody.setResMessage(ResponseSatus.ERROR_REQUEST.getReasonPhrase());
        responseBody.setData(ResponseSatus.ERROR_DATA.getReasonPhrase());
        responseHead.setResponse(responseBody);
        return responseHead;
    }
}
