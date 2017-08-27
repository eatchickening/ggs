/**
 * Copyright (C), 2011-2017, 微贷网.
 */
package io.chicken.ggs.web.filter;

import com.alibaba.fastjson.JSON;
import io.chicken.ggs.common.CommonConstant;
import io.chicken.ggs.common.Result;
import io.chicken.ggs.common.ResultCode;
import io.chicken.ggs.common.util.LoginUtil;
import io.chicken.ggs.common.util.Md5Util;
import io.chicken.ggs.common.util.MenuUtil;
import io.chicken.ggs.common.vo.UserInfoVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * 权限拦截器
 * 
 * @author wungmc 2017/6/27.
 */

public class AuthHandlerInterceptor extends HandlerInterceptorAdapter {
    static final Logger LOGGER = LoggerFactory.getLogger(AuthHandlerInterceptor.class);

    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    // @Autowired
    // private RedisService redisService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        LOGGER.info(request.getRequestURL().toString());
        response.setCharacterEncoding("UTF-8");
//        if(true) return true;

        HttpSession session = request.getSession(true);
        String sessionId = session.getId();
        Object obj =  session.getAttribute(sessionId);
        if (obj == null) {
            // 未登录
            //清除 cookie 和 session 失效
            LoginUtil.setCookieInvalid(request, response);

            //返回未登录提示
            Result<String> result = new Result<>(ResultCode.LOGIN_NO_LOGIN);
            result.setData("login.html");
            response.getWriter().write(JSON.toJSONString(result));
            return false;
        }

        UserInfoVO userVO = (UserInfoVO) obj;
        if (!MenuUtil.hasAuth(userVO.getId(), request.getRequestURL().toString())) {
            //返回无权限提示
            Result<String> result = new Result<>(ResultCode.LOGIN_NO_AUTH);
            response.getWriter().write(JSON.toJSONString(result));
            return false;
        }
        session.setAttribute(sessionId, userVO);
        return true;

        // if (account.equals(userVO.getAccount()) && MenuUtil.getMenu(userVO.getId()) != null) {
        //     // redisService.set(userKey, userObj, CommonConstant.ACCOUNT_EXPIRED);
        //     // redisService.set(CommonConstant.REDIS_PREFIX + account, userKey, CommonConstant.ACCOUNT_EXPIRED);
        //     threadLocal.set(userKey);
        //     return true;
        // }

        // Map<String, String> cookieMap = LoginUtil.getParamFromCookie(request, response);
        // if (cookieMap != null) {
        //     String account = cookieMap.get(CommonConstant.ACCOUNT_COOKIE);
        //     String token = cookieMap.get(CommonConstant.TOKEN_COOKIE);
        //     String ip = LoginUtil.getClientIP(request);
        //     LOGGER.info("ip=" + ip);
        //
        //     String userKey = Md5Util.Md5(token + account);
        //     // Object userObj = redisService.get(userKey);
        //     Object userObj = new UserInfoVO();
        //     if (userObj != null && userObj instanceof UserInfoVO) {
        //         UserInfoVO userVO = (UserInfoVO)userObj;
        //         if (!MenuUtil.hasAuth(userVO.getId(), request.getRequestURL().toString())) {
        //             //返回无权限提示
        //             Result<String> result = new Result<>(ResultCode.LOGIN_NO_AUTH);
        //             result.setData("login.html");
        //             response.getWriter().write(JSON.toJSONString(result));
        //             return false;
        //         }
        //         if (account.equals(userVO.getAccount()) && MenuUtil.getMenu(userVO.getId()) != null) {
        //             // redisService.set(userKey, userObj, CommonConstant.ACCOUNT_EXPIRED);
        //             // redisService.set(CommonConstant.REDIS_PREFIX + account, userKey, CommonConstant.ACCOUNT_EXPIRED);
        //             threadLocal.set(userKey);
        //             return true;
        //         }
        //     }
        //     else {
        //         LOGGER.info("没有命中缓存，ip=" + ip + ",account=" + account);
        //     }
        // }

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        super.afterCompletion(request, response, handler, ex);
    }

    public static String getUserInfoRedisKey() {
        return threadLocal.get();
    }
}
