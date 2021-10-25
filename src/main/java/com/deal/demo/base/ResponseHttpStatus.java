package com.deal.demo.base;


import com.deal.demo.base.response.ResponseHead;
import com.deal.demo.base.response.ResponseSatus;

/**
 * @version V1.0
 * @Title: ResponseHttpStatus.java <br>
 * @Package com.hzbf.utils.controller <br>
 * @Description: (常用请求状态响应的封装) <br>
 * @author: 路逸冰(Allen) <br>
 * @date: 2018/5/18 11:24 <br>
 */
public class ResponseHttpStatus {

    /**
     * 服务器报错请求响应封装
     * @param responseHead
     * @param status
     * @param data
     * @param interfaceStatus
     * @return
     */
    public static ResponseHead responseStatus(ResponseHead responseHead, int status, Object data,
                                              String interfaceStatus) {
        //参数请求错误或缺少参数
        if(status == 400){
            responseHead.setCode(ResponseSatus.OK.getValue());
            responseHead.setMessage(ResponseSatus.OK.getReasonPhrase());
            responseHead.setInterfaceStatus(interfaceStatus);
            responseHead.getResponse().setResStatus(ResponseSatus.BAD_REQUEST.getValue());
            responseHead.getResponse().setResMessage(ResponseSatus.BAD_REQUEST.getReasonPhrase());
            responseHead.getResponse().setData(data);
        } else if(status == 405){
            responseHead.setCode(ResponseSatus.OK.getValue());
            responseHead.setMessage(ResponseSatus.OK.getReasonPhrase());
            responseHead.setInterfaceStatus(interfaceStatus);
            responseHead.getResponse().setResStatus(ResponseSatus.METHOD_NOT_ALLOWED.getValue());
            responseHead.getResponse().setResMessage(ResponseSatus.METHOD_NOT_ALLOWED.getReasonPhrase());
            responseHead.getResponse().setData(data);
        } else if(status == 406){
            responseHead.setCode(ResponseSatus.OK.getValue());
            responseHead.setMessage(ResponseSatus.OK.getReasonPhrase());
            responseHead.setInterfaceStatus(interfaceStatus);
            responseHead.getResponse().setResStatus(ResponseSatus.NOT_ACCEPTABLE.getValue());
            responseHead.getResponse().setResMessage(ResponseSatus.NOT_ACCEPTABLE.getReasonPhrase());
            responseHead.getResponse().setData(data);
        } else if(status == 415){
            responseHead.setCode(ResponseSatus.OK.getValue());
            responseHead.setMessage(ResponseSatus.OK.getReasonPhrase());
            responseHead.setInterfaceStatus(interfaceStatus);
            responseHead.getResponse().setResStatus(ResponseSatus.UNSUPPORTED_MEDIA_TYPE.getValue());
            responseHead.getResponse().setResMessage(ResponseSatus.UNSUPPORTED_MEDIA_TYPE.getReasonPhrase());
            responseHead.getResponse().setData(data);
        } else if(status == 500){
            responseHead.setCode(ResponseSatus.INTERNAL_SERVER_ERROR.getValue());
            responseHead.setMessage(ResponseSatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
            responseHead.setInterfaceStatus(interfaceStatus);
            responseHead.getResponse().setResStatus(ResponseSatus.ERROR_REQUEST.getValue());
            responseHead.getResponse().setResMessage(ResponseSatus.ERROR_REQUEST.getReasonPhrase());
            responseHead.getResponse().setData(data);
        }
        return responseHead;
    }

    /**
     * 请求成功(200) 参数封装
     * @param responseHead
     * @param data
     * @param interfaceStatus
     * @return
     */
    public static ResponseHead successRequest(ResponseHead responseHead, Object data,String interfaceStatus){
        responseHead.setCode(ResponseSatus.OK.getValue());
        responseHead.setMessage(ResponseSatus.OK.getReasonPhrase());
        responseHead.setInterfaceStatus(interfaceStatus);
        responseHead.getResponse().setResStatus(ResponseSatus.SUCCESS_PARAMETER_OK.getValue());
        responseHead.getResponse().setResMessage(ResponseSatus.SUCCESS_PARAMETER_OK.getReasonPhrase());
        responseHead.getResponse().setData(data);
        return responseHead;
    }

    /**
     * 请求失败 参数封装
     * @param responseHead
     * @param data
     * @param interfaceStatus
     * @return
     */
    public static ResponseHead errorRequest(ResponseHead responseHead, Object data,String interfaceStatus){
        responseHead.setCode(ResponseSatus.OK.getValue());
        responseHead.setMessage(ResponseSatus.OK.getReasonPhrase());
        responseHead.setInterfaceStatus(interfaceStatus);
        responseHead.getResponse().setResStatus(ResponseSatus.ERROR_DATA.getValue());
        responseHead.getResponse().setResMessage(ResponseSatus.ERROR_DATA.getReasonPhrase());
        responseHead.getResponse().setData(data);
        return responseHead;
    }
}
