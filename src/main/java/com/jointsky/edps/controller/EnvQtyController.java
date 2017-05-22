package com.jointsky.edps.controller;

import com.jointsky.edps.model.EnvQty;
import com.jointsky.edps.service.EnvQtyService;
import io.swagger.annotations.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;


@Api(value = "环境质量入口",description = "长天长大数据平台环境质量与污染源监控数据分析API")
@RestController
@ApiIgnore    //不显示此接口
public class EnvQtyController {

    private Logger logger = Logger.getLogger(EnvQtyController.class);

    @Autowired
    private EnvQtyService userQtyService;

    @ApiResponses({
            @ApiResponse(code=400,message="请求参数没填好"),
            @ApiResponse(code=401,message="未授权访问"),
            @ApiResponse(code=403,message="请求被拒绝"),
            @ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")
    })
    @ApiOperation(value = "环境质量指标信息",notes = "单个环境质量指标分析结果入口")
    @ApiImplicitParam(name = "envParam", value = "指标参数", required = true, dataType = "String", paramType = "query",defaultValue="so2")
    @RequestMapping(value = "/envQty",params="envParam", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    public EnvQty getEnvQtyInfo(@RequestParam(value = "envParam") String envParam) {
        EnvQty envQty = userQtyService.getEnvQtyInfo(envParam);
        return envQty;
    }

    @ApiOperation(value="环保质量指标集", notes="")
    @RequestMapping(value={"/envQtys"}, method= RequestMethod.GET)
    public List<EnvQty> getEnvQtys() {
        return userQtyService.getEnvQtyInfos();
    }
}
