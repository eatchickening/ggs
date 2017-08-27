/*
 * Copyright (C), 2011-2017.
 */
package io.chicken.ggs.web.controller;

import io.chicken.ggs.business.OrganizationBusiness;
import io.chicken.ggs.common.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author wung 2017/8/27.
 */
@Controller
@RequestMapping("/ggs/organization")
public class OrganizationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrganizationController.class);

    @Autowired
    private OrganizationBusiness organizationBusiness;


    @ResponseBody
    @RequestMapping(value = "/get", method = RequestMethod.POST)
    public Result get(String areacode) {
        LOGGER.info("get() " + areacode);

        return organizationBusiness.queryByAreacode(areacode);
    }

}
