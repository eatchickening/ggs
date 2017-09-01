package io.chicken.ggs.web.controller;

import io.chicken.ggs.business.AppraiseBussiness;
import io.chicken.ggs.common.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by nyh on 8/31/17.
 *
 * 评优活动管理
 */
@RestController
@Api(description = "活动管理")
@RequestMapping("/ggs/appraise")
public class AppraiseController {
    public static final Logger logger = LoggerFactory.getLogger(AppraiseController.class);

    @Autowired
    private AppraiseBussiness appraiseBussiness;

    @ApiOperation(value = "获取评优列表", notes="默认name参数为空, pageSize pageNum不能为空")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "评优名称", required = true, dataType = "form"),
            @ApiImplicitParam(name = "pageNum", value = "每页显示个数", required = true, dataType = "form")
    })
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public Result teacherList(@RequestBody String name,
                              @RequestBody String pageNum,
                              @RequestBody String pageSize){
        return appraiseBussiness.queryList(name.trim(), Integer.parseInt(pageNum), Integer.parseInt(pageSize));
    }

}
