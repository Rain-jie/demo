package com.deal.demo.controller;

import com.deal.demo.base.ResponseHttpStatus;
import com.deal.demo.base.exception.ControllerException;
import com.deal.demo.base.response.ResponseHead;
import com.deal.demo.service.SponsorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * 赞助企业相关接口控制层
 */
@RestController
@RequestMapping(value = "/api/spnsor")
public class SponsorController extends ControllerException {
    private ResponseHead responseHead = createResponse();
    @Autowired
    private SponsorService sponsorService;
    /**
     * 获取所有赞助企业方法
     * @param response
     * @return
     */
    @RequestMapping(value = "/phone/getSponsor", method = RequestMethod.POST)
    public ResponseHead getSponsor(HttpServletResponse response,
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
        HashMap<String,Object> userMap=new HashMap<>(1);
        userMap.put("pageNum",pageNum);
        userMap.put("pageSize",pageSize);
        Map<String,Object> user = sponsorService.getSponsor(userMap);
        if (user.get("type").toString().contains("error&")) {
            return ResponseHttpStatus.errorRequest(responseHead, user.get("type"), "interfaceStatus");
        }
        return ResponseHttpStatus.successRequest(responseHead, user, "interfaceStatus");
    }
    /**
     * 新增赞助企业
     * @param response
     * @return
     */
    @RequestMapping(value = "/phone/registerSponsor", method = RequestMethod.POST)
    public ResponseHead registerSponsor(HttpServletResponse response,
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
        Map<String,Object> user = sponsorService.registerSponsor(userJsonMap);
        if (user.get("type").toString().contains("error&")) {
            return ResponseHttpStatus.errorRequest(responseHead, user.get("type"), "interfaceStatus");
        }
        return ResponseHttpStatus.successRequest(responseHead, user, "interfaceStatus");
    }
    /**
     * 赞助企业信息修改
     * @param response
     * @return
     */
    @RequestMapping(value = "/phone/updateSponsor", method = RequestMethod.POST)
    public ResponseHead updateSponsor(HttpServletResponse response,
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
        Map<String,Object> user = sponsorService.updateSponsor(userJsonMap);
        if (user.get("type").toString().contains("error&")) {
            return ResponseHttpStatus.errorRequest(responseHead, user.get("type"), "interfaceStatus");
        }
        return ResponseHttpStatus.successRequest(responseHead, user, "interfaceStatus");
    }
    /**
     * 清除赞助企业信息
     * @param response
     * @return
     */
    @RequestMapping(value = "/phone/deleteSponsor", method = RequestMethod.GET)
    public ResponseHead deleteSponsor(HttpServletResponse response,
                                   @RequestParam(value = "sponsorId") Integer sponsorId) {
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
        Map<String,Object> user = sponsorService.deleteSponsor(sponsorId);
        if (user.get("type").toString().contains("error&")) {
            return ResponseHttpStatus.errorRequest(responseHead, user.get("type"), "interfaceStatus");
        }
        return ResponseHttpStatus.successRequest(responseHead, user, "interfaceStatus");
    }
}
