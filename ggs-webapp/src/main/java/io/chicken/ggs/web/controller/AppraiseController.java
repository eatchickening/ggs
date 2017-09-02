package io.chicken.ggs.web.controller;

import io.chicken.ggs.business.AppraiseBusiness;
import io.chicken.ggs.common.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by nyh on 8/31/17.
 *
 * 评优奖项管理
 */
@Api(description = "评优奖项管理")
@RestController
@RequestMapping("/ggs/appr")
public class AppraiseController {
    public static final Logger logger = LoggerFactory.getLogger(AppraiseController.class);

    @Autowired
    private AppraiseBusiness appraiseBusiness;

    @ApiOperation(value = "获取评优奖项列表", notes="默认name参数为空, pageSize pageNum不能为空")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "评优名称", required = false, dataType = "String", paramType = "form"),
            @ApiImplicitParam(name = "pageNum", value = "每页显示个数", required = true, dataType = "String", paramType = "form"),
            @ApiImplicitParam(name = "pageSize", value = "显示页数", required = true, dataType = "String", paramType = "form")
    })
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public Result teacherList(String name,
                              String pageNum,
                              String pageSize){
        return appraiseBusiness.queryList(name, Integer.parseInt(pageNum), Integer.parseInt(pageSize));
    }

}
