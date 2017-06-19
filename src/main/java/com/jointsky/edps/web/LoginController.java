package com.jointsky.edps.controller;

import com.jointsky.edps.model.UserInfo;
import com.jointsky.edps.service.LoginService;
import com.jointsky.edps.system.login.LoginSecurityConfig;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpSession;

/**
 * Created by shilin on 2017/6/15.
 */

@Controller
@ApiIgnore
public class LoginController {

//    @RequestMapping("/login")
//    public String login(ModelMap modelMap){
//        return("login");
//    }

}
