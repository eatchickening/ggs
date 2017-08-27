/**
 * Copyright (C), 2011-2017, 微贷网.
 */
package io.chicken.ggs.web.controller;

import io.chicken.ggs.common.vo.UserInfoVO;
import io.chicken.ggs.web.filter.AuthHandlerInterceptor;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;

/**
 * 其他 Controller 继承该类，以便获取当前登录人信息
 * @author wungmc 2017/7/5.
 */
@Component
public class BaseController {

    public UserInfoVO getUserInfo() {
        HttpSession session = AuthHandlerInterceptor.getHttpSession();
        String sessionId = session.getId();
        UserInfoVO userVO = (UserInfoVO)session.getAttribute(sessionId);
        return userVO;
    }
}
