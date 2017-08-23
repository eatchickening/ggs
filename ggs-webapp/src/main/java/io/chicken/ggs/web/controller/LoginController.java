
package io.chicken.ggs.web.controller;

import io.chicken.ggs.common.Result;
import io.chicken.ggs.common.ResultCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author wung 2017/8/22.
 */
@Controller
@RequestMapping("/ggs/auth")
public class LoginController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Result login(String account, String password, HttpServletRequest request, HttpServletResponse response) {
        logger.info("account=" + account + ", pwd =" + password);
        if (StringUtils.isEmpty(account) || StringUtils.isEmpty(password)) {
            return new Result<>(ResultCode.PARAMETER_EMPTY);
        }

        // 处理逻辑

        return new Result<>(ResultCode.SUCCESS);
    }

    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    @ResponseBody
    public Result logout(HttpServletRequest request, HttpServletResponse response) {
        // 清除登录状态

        System.out.println("logout...");

        return new Result(ResultCode.SUCCESS);
    }
}
