package com.jointsky.edps.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import springfox.documentation.annotations.ApiIgnore;

/**
 * Created by root on 2017/6/15.
 */
@Controller
@ApiIgnore
public class IndexController {

    @RequestMapping("/index.html")
    public String index(ModelMap modelMap){

        return "index";
    }

    @RequestMapping("/homePage.html")
    public String homePage(ModelMap modelMap){

        return "homePage";
    }

    @RequestMapping("/product.html")
    public String product(ModelMap modelMap){

        return "product";
    }

    @RequestMapping("/productEntry.html")
    public String productEntry(ModelMap modelMap){

        return "productEntry";
    }
    @RequestMapping("product/dataInterface.html")
    public String dataInterface(ModelMap modelMap){

        return "product/dataInterface";
    }
    @RequestMapping("product/dataReport.html")
    public String dataReport(ModelMap modelMap){

        return "product/dataReport";
    }
    @RequestMapping("product/rank.html")
    public String rank(ModelMap modelMap){

        return "product/rank";
    }

    @RequestMapping("product/dataReport/dataReportSon.html")
    public String dataReportSon(ModelMap modelMap){

        return "product/dataReport/dataReportSon";
    }

    @RequestMapping("product/rank/rankSon001.html")
    public String rankSon001(ModelMap modelMap){

        return "product/rank/rankSon001";
    }


}
