package com.deal.demo.controller;

import com.deal.demo.base.ResponseHttpStatus;
import com.deal.demo.base.exception.ControllerException;
import com.deal.demo.base.response.ResponseHead;
import com.deal.demo.service.ActivityFundsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/activityFunds")
public class ActivityFundsController extends ControllerException {
    private ResponseHead responseHead = createResponse();
    @Autowired
    private ActivityFundsService activityFundsService;



    @RequestMapping(value = "/phone/getActivityFunds", method = RequestMethod.POST)
    public ResponseHead getActivityFunds(HttpServletResponse response,
                                        @RequestParam(value = "pageNum") Integer pageNum,
                                        @RequestParam(value = "pageSize") Integer pageSize) {
        //获取请求状态码
        int responseStatus = response.getStatus();
        //如果状态码等于200代表成功,否则代表失败
        if (responseStatus != HttpServletResponse.SC_OK) {
            //状态码错误（log表建立后此处记录状态码内容，直接在《ControllerException》中记录）
            return ResponseHttpStatus.responseStatus(responseHead, responseStatus, "error&系统错误", "");
        }
        /**
         * 业务处理
         */
        HashMap<String,Object> userMap=new HashMap<String,Object>(2);
        userMap.put("pageNum",pageNum);
        userMap.put("pageSize",pageSize);
        Map<String,Object> user = activityFundsService.getActivityFunds(userMap);
        if (user.get("type").toString().contains("error&")) {
            return ResponseHttpStatus.errorRequest(responseHead, user.get("type"), "interfaceStatus");
        }
        return ResponseHttpStatus.successRequest(responseHead, user, "interfaceStatus");
    }
    /**
     * 新增活动
     * @param response
     * @return
     */
    @RequestMapping(value = "/phone/registerActivityFunds", method = RequestMethod.POST)
    public ResponseHead registerActivityFunds(HttpServletResponse response,
                                             @RequestBody Map<String, Object> userJsonMap) {
        //获取请求状态码
        int responseStatus = response.getStatus();
        //如果状态码等于200代表成功,否则代表失败
        if (responseStatus != HttpServletResponse.SC_OK) {
            //状态码错误（log表建立后此处记录状态码内容，直接在《ControllerException》中记录）
            return ResponseHttpStatus.responseStatus(responseHead, responseStatus, "error&系统错误", "");
        }
        /**
         * 业务处理
         */
        Map<String,Object> user = activityFundsService.registerActivityFunds(userJsonMap);
        if (user.get("type").toString().contains("error&")) {
            return ResponseHttpStatus.errorRequest(responseHead, user.get("type"), "interfaceStatus");
        }
        return ResponseHttpStatus.successRequest(responseHead, user, "interfaceStatus");
    }
    /**
     * 活动信息修改
     * @param response
     * @return
     */
    @RequestMapping(value = "/phone/updateActivityFunds", method = RequestMethod.POST)
    public ResponseHead updateJoinActivity(HttpServletResponse response,
                                           @RequestBody Map<String, Object> userJsonMap) {
        //获取请求状态码
        int responseStatus = response.getStatus();
        //如果状态码等于200代表成功,否则代表失败
        if (responseStatus != HttpServletResponse.SC_OK) {
            //状态码错误（log表建立后此处记录状态码内容，直接在《ControllerException》中记录）
            return ResponseHttpStatus.responseStatus(responseHead, responseStatus, "error&系统错误", "");
        }
        /**
         * 业务处理
         */
        Map<String,Object> user = activityFundsService.updateActivityFunds(userJsonMap);
        if (user.get("type").toString().contains("error&")) {
            return ResponseHttpStatus.errorRequest(responseHead, user.get("type"), "interfaceStatus");
        }
        return ResponseHttpStatus.successRequest(responseHead, user, "interfaceStatus");
    }
    /**
     * 清除活动信息
     * @param response
     * @return
     */
    @RequestMapping(value = "/phone/deleteActivityFunds", method = RequestMethod.GET)
    public ResponseHead deleteJoinActivity(HttpServletResponse response,
                                           @RequestParam(value = "activityFundsId") Integer activityFundsId) {
        //获取请求状态码
        int responseStatus = response.getStatus();
        //如果状态码等于200代表成功,否则代表失败
        if (responseStatus != HttpServletResponse.SC_OK) {
            //状态码错误（log表建立后此处记录状态码内容，直接在《ControllerException》中记录）
            return ResponseHttpStatus.responseStatus(responseHead, responseStatus, "error&系统错误", "");
        }
        /**
         * 业务处理
         */
        Map<String,Object> user = activityFundsService.deleteActivityFunds(activityFundsId);
        if (user.get("type").toString().contains("error&")) {
            return ResponseHttpStatus.errorRequest(responseHead, user.get("type"), "interfaceStatus");
        }
        return ResponseHttpStatus.successRequest(responseHead, user, "interfaceStatus");
    }
}
