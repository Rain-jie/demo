package com.deal.demo.controller;

import com.deal.demo.base.ResponseHttpStatus;
import com.deal.demo.base.exception.ControllerException;
import com.deal.demo.base.response.ResponseHead;
import com.deal.demo.model.User;
import com.deal.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * 用户相关接口控制层
 */
@RestController
@RequestMapping(value = "/api/user")
public class UserController extends ControllerException {
    private ResponseHead responseHead = createResponse();
    @Autowired
    private UserService userService;
    @RequestMapping(value = "/phone/jenkinsDemo",method = RequestMethod.GET)
    public  String jenkinsDemo(){
        return "hello word";
    }
    /**
     * 用户登录方法
     * @param response
     * @param userAccount 用户账号
     * @param userPassword 用户密码
     * @return
     */
    @RequestMapping(value = "/phone/loginUser", method = RequestMethod.POST)
    public ResponseHead loginUser(HttpServletResponse response,
                                               @RequestParam(value = "userAccount") String userAccount,
                                               @RequestParam(value = "userPassword") String userPassword) {
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
        HashMap<String,Object> userMap=new HashMap<>(2);
        userMap.put("userAccount",userAccount);
        userMap.put("userPassword",userPassword);
        Map<String,Object> user = userService.loginUser(userMap);
        if (user.get("type").toString().contains("error&")) {
            return ResponseHttpStatus.errorRequest(responseHead, user.get("type"), "interfaceStatus");
        }
        return ResponseHttpStatus.successRequest(responseHead, user, "interfaceStatus");
    }
    /**
     * 用户注册
     * @param response
     * @return
     */
    @RequestMapping(value = "/phone/registerUser", method = RequestMethod.POST)
    public ResponseHead registerUser(HttpServletResponse response,
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
        Map<String,Object> user = userService.registerUser(userJsonMap);
        if (user.get("type").toString().contains("error&")) {
            return ResponseHttpStatus.errorRequest(responseHead, user.get("type"), "interfaceStatus");
        }
        return ResponseHttpStatus.successRequest(responseHead, user, "interfaceStatus");
    }
    /**
     * 用户信息修改
     * @param response
     * @return
     */
    @RequestMapping(value = "/phone/updateUser", method = RequestMethod.POST)
    public ResponseHead updateUser(HttpServletResponse response,
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
        Map<String,Object> user = userService.updateUser(userJsonMap);
        if (user.get("type").toString().contains("error&")) {
            return ResponseHttpStatus.errorRequest(responseHead, user.get("type"), "interfaceStatus");
        }
        return ResponseHttpStatus.successRequest(responseHead, user, "interfaceStatus");
    }

}
