package com.jointsky.edps.web;

import com.jointsky.edps.service.UserRegistrationService;
import io.swagger.annotations.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by shilin on 2017/6/14.
 * 用户注册控制层
 */

@Api(value = "用户注册入口", description = "用户注册入口API")
@RestController
public class UserRegistrationController {

    private Logger logger = Logger.getLogger(UserRegistrationController.class);

    @Autowired
    private UserRegistrationService userRegistrationService;

    @ApiResponses({
            @ApiResponse(code = 400, message = "请求参数没有设置好"),
            @ApiResponse(code = 401, message = "未授权访问"),
            @ApiResponse(code = 403, message = "请求被拒绝"),
            @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对")
    })
    @ApiOperation(value = "用户注册", notes = "用户注册入口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userAccount", value = "用户名", required = true, dataType = "String", paramType = "query", defaultValue = ""),
            @ApiImplicitParam(name = "userName", value = "姓名", required = true, dataType = "String", paramType = "query", defaultValue = ""),
            @ApiImplicitParam(name = "telphone", value = "手机号", required = true, dataType = "String", paramType = "query", defaultValue = ""),
            @ApiImplicitParam(name = "email", value = "电子邮件", required = true, dataType = "String", paramType = "query", defaultValue = ""),
            @ApiImplicitParam(name = "region", value = "所在城市", required = true, dataType = "String", paramType = "query", defaultValue = ""),
            @ApiImplicitParam(name = "factName", value = "单位名称", required = true, dataType = "String", paramType = "query", defaultValue = ""),
            @ApiImplicitParam(name = "password", value = "密码", required = true, dataType = "String", paramType = "query", defaultValue = "")
    })
    @RequestMapping(value = "/userRegistration", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    public Map<String, Boolean> saveUser(@RequestParam(value = "userAccount") String userAccount, @RequestParam(value = "userName") String userName,
                                         @RequestParam(value = "telphone") String telphone, @RequestParam(value = "email") String email,
                                         @RequestParam(value = "region") String region, @RequestParam(value = "factName") String factName,
                                         @RequestParam(value = "password") String password) {
        logger.info("===用户注册===");
        boolean flag = false;
        Map<String, Boolean> map = new HashMap<String, Boolean>();
        flag =  userRegistrationService.saveUser(userAccount,userName,telphone,email,region,factName,password);
        logger.info("===用户注册状态===" + flag);
        map.put("flag",flag);
        return map;
    }

    @ApiResponses({
            @ApiResponse(code = 400, message = "请求参数没有设置好"),
            @ApiResponse(code = 401, message = "未授权访问"),
            @ApiResponse(code = 403, message = "请求被拒绝"),
            @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对")
    })
    @ApiOperation(value="用户名重名检测",notes = "用户名重名检测入口")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "userAccount", value = "用户名", required = true, dataType = "String", paramType = "query", defaultValue = "")
    })
    @RequestMapping(value = "/checkUserAccount",method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    public Map<String, Boolean> checkUserAccount(@RequestParam(value = "userAccount") String userAccount){
        logger.info("===用户名重名检测===");
        boolean flag = false;
        Map<String, Boolean> map = new HashMap<String, Boolean>();
        flag = userRegistrationService.checkUserAccount(userAccount);
        logger.info("===用户名重名检测状态===" + flag);
        map.put("flag",flag);
        return map;
    }

    @ApiResponses({
            @ApiResponse(code = 400, message = "请求参数没有设置好"),
            @ApiResponse(code = 401, message = "未授权访问"),
            @ApiResponse(code = 403, message = "请求被拒绝"),
            @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对")
    })
    @ApiOperation(value = "手机号码重复检测", notes = "手机号码重复检测入口")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "telphone", value = "手机号", required = true, dataType = "String", paramType = "query", defaultValue = "")
    })
    @RequestMapping(value = "/checkTelphone", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    public Map<String, Boolean> checkTelphone(@RequestParam(value = "telphone") String telhpone){
        logger.info("===手机号码重复检测===");
        boolean flag = false;
        Map<String, Boolean> map = new HashMap<String, Boolean>();
        flag = userRegistrationService.checkTelphone(telhpone);
        logger.info("===手机号码重复检测状态===" + flag);
        map.put("flag", flag);
        return map;
    }

    @ApiResponses({
            @ApiResponse(code = 400, message = "请求参数没有设置好"),
            @ApiResponse(code = 401, message = "未授权访问"),
            @ApiResponse(code = 403, message = "请求被拒绝"),
            @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对")
    })
    @ApiOperation(value = "电子邮箱重复检测", notes = "电子邮箱重复检测入口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "email", value = "电子邮箱", required = true, dataType = "String", paramType = "query", defaultValue = "")
    })
    @RequestMapping(value = "/checkEmail", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    public Map<String, Boolean> checkEmail(@RequestParam(value = "email") String email){
        logger.info("===电子邮箱重复检测===");
        boolean flag = false;
        Map<String, Boolean> map = new HashMap<String, Boolean>();
        flag = userRegistrationService.checkEmail(email);
        logger.info("===电子邮箱重复检测状态===" + flag);
        map.put("flag", flag);
        return map;
    }

}
