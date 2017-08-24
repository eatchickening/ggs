
package io.chicken.ggs.web.controller;

import io.chicken.ggs.business.LoginBusiness;
import io.chicken.ggs.common.Result;
import io.chicken.ggs.common.ResultCode;
import io.chicken.ggs.common.vo.UserInfoVO;
import io.chicken.ggs.dal.model.UserInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

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

    @Autowired
    private LoginBusiness loginBusiness;

    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Result login(String account, String password, HttpServletRequest request, HttpServletResponse response) {
        // String account = userInfo.getAccount();
        // String password = userInfo.getPassword();
        logger.info("account=" + account + ", pwd =" + password);
        if (StringUtils.isEmpty(account) || StringUtils.isEmpty(password)) {
            return new Result<>(ResultCode.PARAMETER_EMPTY);
        }
        System.out.println(account);
        System.out.println(password);
        // 处理逻辑

        Result<UserInfoVO> result = loginBusiness.login(account, password);
        // UserVO userVO = result.getData();
        // if (!result.isSuccess() || userVO == null) {
        //     return new RpcResult<>(result.getCode(), result.getMessage());
        // }
        // System.out.println(result.isSuccess());
        // System.out.println(result.getMessage());
        // System.out.println(result.getData());
        //
        // if (MenuUtil.getEnum(userVO.getRoleCode()) == null) {
        //     logger.error("非pc用户登录: roleName=" + userVO.getRoleName());
        //     return new RpcResult(ResultCode.LOGIN_FAIL);
        // }
        //
        // // cookie 设置和 redis 保存用户信息
        // String token = LoginUtil.setCookieValueAndReturnToken(request, response, userVO.getAccount());
        // // String ip = LoginUtil.getClientIP(request);
        // if (StringUtils.isEmpty(token) /*|| StringUtils.isEmpty(ip)*/) {
        //     logger.error("login(), token=" + token/* + ", ip =" + ip*/);
        //     return new RpcResult();
        // }
        // String userKey = Md5Util.Md5(token + account);
        // redisService.set(userKey, userVO, Constant.ACCOUNT_EXPIRED);
        // redisService.set(Constant.REDIS_PREFIX + account, userKey, Constant.ACCOUNT_EXPIRED);


        return new Result<>(ResultCode.SUCCESS);
    }


    /**
     * 获取登录用户信息和菜单
     */
    // @RequestMapping(value = "/userInfo", method = RequestMethod.POST)
    // @ResponseBody
    // public RpcResult<UserVOAndEnumNodeVO> userInfo() {
    //     // 从redis 中取用户信息
    //     UserVO userVO = getUserInfo();
    //     String account = userVO.getAccount();
    //     logger.info("account=" + account);
    //
    //     if (StringUtils.isEmpty(account)) {
    //         return new RpcResult<>(ResultCode.PARAMETER_EMPTY);
    //     }
    //
    //     UserVOAndEnumNodeVO vo = new UserVOAndEnumNodeVO();
    //     vo.setUserVO(userVO);
    //     EnumNode enumNode = MenuUtil.getEnum(userVO.getRoleCode());
    //     vo.setEnumNode(enumNode);
    //
    //     return new RpcResult<>(vo);
    // }

    /**
     * 修改密码
     */
    @RequestMapping(value = "/updatePwd", method = RequestMethod.POST)
    @ResponseBody
    public Result<Boolean> updatePwd(String oldPassword, String newPassword) {
        if (StringUtils.isEmpty(oldPassword) || StringUtils.isEmpty(newPassword)) {
            return new Result<>(ResultCode.PARAMETER_EMPTY);
        }

        // String account = getUserInfo().getAccount();
        String account = "test"; //todo

        return loginBusiness.updatePwd(account, oldPassword, newPassword);
    }

    /**
     * 测试是否可以跨域
     * @param request
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/debug", method = RequestMethod.POST)
    public Result debug(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("debug...");

        return new Result<>(ResultCode.SUCCESS);
    }

    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    @ResponseBody
    public Result logout(HttpServletRequest request, HttpServletResponse response) {
        // 清除登录状态
        // 这个时候redis 删除登录状态
        // clearUserInfoFromCache();
        // LoginUtil.setCookieInvalid(request, response);
        System.out.println("logout...");

        return new Result(ResultCode.SUCCESS);
    }
}
