/**
 * Copyright (C), 2011-2017, 微贷网.
 */
package io.chicken.ggs.common.util;

import io.chicken.ggs.common.CommonConstant;
import org.springframework.util.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 *
 * @author wungmc 2017/7/4.
 */
public class LoginUtil {

    public static Map<String, String> getParamFromCookie(HttpServletRequest request, HttpServletResponse response) {
        if (request == null || response == null) {
            return null;
        }

        String account = null;
        String token = null;

        Cookie[] cookies = request.getCookies();
        if (cookies == null) {
            return null;
        }
        for (Cookie cookie : cookies) {
            if (CommonConstant.ACCOUNT_COOKIE.equals(cookie.getName())) {
                account = cookie.getValue();
            }
            else if (CommonConstant.TOKEN_COOKIE.equals(cookie.getName())) {
                token = cookie.getValue();
            }
        }
        if (account == null || token == null) return null;

        Map<String, String> map = new HashMap<>();
        map.put(CommonConstant.ACCOUNT_COOKIE, account);
        map.put(CommonConstant.TOKEN_COOKIE, token);

        return map;
    }

    public static String getClientIP(HttpServletRequest httpservletrequest) {
        if (httpservletrequest == null)
            return null;
        String s = httpservletrequest.getHeader("X-Forwarded-For");
        if (s == null || s.length() == 0 || "unknown".equalsIgnoreCase(s))
            s = httpservletrequest.getHeader("Proxy-Client-IP");
        if (s == null || s.length() == 0 || "unknown".equalsIgnoreCase(s))
            s = httpservletrequest.getHeader("WL-Proxy-Client-IP");
        if (s == null || s.length() == 0 || "unknown".equalsIgnoreCase(s))
            s = httpservletrequest.getHeader("HTTP_CLIENT_IP");
        if (s == null || s.length() == 0 || "unknown".equalsIgnoreCase(s))
            s = httpservletrequest.getHeader("HTTP_X_FORWARDED_FOR");
        if (s == null || s.length() == 0 || "unknown".equalsIgnoreCase(s))
            s = httpservletrequest.getRemoteAddr();
        return s;
    }

    public static void setCookieInvalid(HttpServletRequest request, HttpServletResponse response) {
        if (request == null || response == null) return;
        Cookie[] cookies = request.getCookies();
        if (cookies == null) return;

        for (int i = 0; i < cookies.length; i++) {
            Cookie cookie = new Cookie(cookies[i].getName(), null);
            cookie.setMaxAge(0);
            cookie.setPath("/");
            response.addCookie(cookie);
        }
        request.getSession().invalidate();
    }

    /**
     * 设置 cookie 值，并返回Token值
     * @param request
     * @param response
     * @param account
     * @return
     */
    public static String setCookieValueAndReturnToken(HttpServletRequest request, HttpServletResponse response, String account) {
        if (request == null || response == null || StringUtils.isEmpty(account)) return null;
        String uuid = UUID.randomUUID().toString();
        String token = Md5Util.Md5(uuid + account);

        Cookie cookie1 = new Cookie(CommonConstant.ACCOUNT_COOKIE, account);
        cookie1.setMaxAge(CommonConstant.ACCOUNT_COOKIE_EXPIRED);
        cookie1.setPath("/");

        Cookie cookie2 = new Cookie(CommonConstant.TOKEN_COOKIE, token);
        cookie2.setMaxAge(CommonConstant.ACCOUNT_COOKIE_EXPIRED);
        cookie2.setPath("/");

        response.addCookie(cookie1);
        response.addCookie(cookie2);

        return token;
    }
}
