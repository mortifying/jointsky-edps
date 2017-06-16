package com.jointsky.edps.controller;

import com.jointsky.edps.model.RegionSelect;
import com.jointsky.edps.service.RegionSelectService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by shilin on 2017/6/14.
 * 城市下拉列表控制层
 */
@Api(value = "城市下拉列表入口", description = "城市下拉列表入口API")
@RestController
public class RegionSelectController {

    @Autowired
    private RegionSelectService regionSelectService;

    @ApiResponses({
            @ApiResponse(code = 400, message = "请求参数没有设置好"),
            @ApiResponse(code = 401, message = "未授权访问"),
            @ApiResponse(code = 403, message = "请求被拒绝"),
            @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对")
    })
    @ApiOperation(value="获取城市下拉列表",notes = "获取城市下来列表入口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "regionCode", value = "行政编码", required = false, dataType = "String", paramType = "query", defaultValue = "")
    })
    @RequestMapping(value = "/getRegionSelect",method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    public List<RegionSelect> getRegionSelect(String regionCode){

        List<RegionSelect> list = regionSelectService.getRegionSelect(regionCode);
        return list;

    }

}
