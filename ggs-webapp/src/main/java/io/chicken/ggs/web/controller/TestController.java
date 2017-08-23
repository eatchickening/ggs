package io.chicken.ggs.web.controller;

import io.chicken.ggs.service.TestService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;


@Controller
public class TestController {

    @Resource
    private TestService testService;


    @RequestMapping(value = "/test")
    @ResponseBody
    public Object test(){

        return "Hello,World";
    }
}
