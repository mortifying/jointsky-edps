package com.jointsky.edps.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by root on 2017/6/15.
 */
@Controller
public class WebController {

    @RequestMapping("/index.html")
    public String index(ModelMap modelMap){

        return "index";
    }


    @RequestMapping("/product.html")
    public String product(ModelMap modelMap){

        return "product";
    }

    @RequestMapping("/productApi.html")
    public String productApi(ModelMap modelMap){

        return "productApi";
    }
    @RequestMapping("/productDataReport.html")
    public String productDataReport(ModelMap modelMap){

        return "productDataReport";
    }

    @RequestMapping("/productRankingList.html")
    public String productRankingList(ModelMap modelMap){

        return "productRankingList";
    }

    @RequestMapping("/login.html")
    public String login(ModelMap modelMap){

        return "login";
    }

    @RequestMapping("/regist.html")
    public String regist(ModelMap modelMap){

        return "regist";
    }




}
