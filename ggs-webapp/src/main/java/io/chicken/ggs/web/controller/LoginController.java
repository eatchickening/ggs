
package io.chicken.ggs.web.controller;

import io.chicken.ggs.business.LoginBusiness;
import io.chicken.ggs.business.SysMenuBusiness;
import io.chicken.ggs.common.Result;
import io.chicken.ggs.common.ResultCode;
import io.chicken.ggs.common.util.LoginUtil;
import io.chicken.ggs.common.vo.UserInfoVO;
import io.chicken.ggs.dal.model.SysMenu;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author wung 2017/8/22.
 */
@Controller
@RequestMapping("/ggs/auth")
public class LoginController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private LoginBusiness loginBusiness;
    @Autowired
    private SysMenuBusiness sysMenuBusiness;

    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Result<UserInfoVO> login(String account, String password, HttpServletRequest request, HttpServletResponse response) {
        logger.info("account=" + account + ", pwd =" + password);
        if (StringUtils.isEmpty(account) || StringUtils.isEmpty(password)) {
            return new Result<>(ResultCode.PARAMETER_EMPTY);
        }
        System.out.println(account);
        System.out.println(password);

        // 登录
        Result<UserInfoVO> result = loginBusiness.login(account, password);
        if (!result.isSuccess()) {
            logger.error(account + ", 登录失败:" + result.getMessage());
            return new Result<>(result.getCode(), result.getMessage());
        }

        // 保存到 session
        HttpSession session = request.getSession(true);
        System.out.println("sessionId = " + session.getId());
        UserInfoVO user = result.getData();
        session.setAttribute(session.getId(), user);
        System.out.println("getSession:" + session.getAttribute(session.getId()));

        return new Result<>(ResultCode.SUCCESS);
    }


    /**
     * 获取登录用户信息和菜单
     */
    @RequestMapping(value = "/userInfo", method = RequestMethod.POST)
    @ResponseBody
    public Result<UserInfoVO> userInfo(HttpServletRequest request) {
        UserInfoVO user = getUserInfo();

        // 查询菜单
        String menuId = user.getMenuId();
        if (StringUtils.isEmpty(menuId)) {
            logger.error(user.getAccount() + ", 没有菜单信息");
            return new Result<>(user);
        }
        String[] ids = menuId.split(",");
        List<Integer> idList = new ArrayList<>(ids.length);
        for (String id : ids) {
            idList.add(Integer.parseInt(id));
        }
        Result<List<SysMenu>> menuResult = sysMenuBusiness.queryList(idList);
        if (!menuResult.isSuccess()) {
            logger.error(user.getAccount() + ", 获取菜单失败:" + menuResult.getMessage());
            return new Result<>(ResultCode.SYS_EXCEPTION);
        }

        List<String> angularStateList = new ArrayList<>();
        List<SysMenu> sysMenuList = menuResult.getData();
        for (SysMenu sysMenu : sysMenuList) {
            angularStateList.add(sysMenu.getAngularState());
        }
        user.setAngularState(angularStateList);

        // 保存菜单信息
        HttpSession session = request.getSession();
        String sessionId = session.getId();
        session.setAttribute(sessionId + "_menu", sysMenuList); //todo

        return new Result<>(user);
    }

    /**
     * 修改密码
     */
    @RequestMapping(value = "/updatePwd", method = RequestMethod.POST)
    @ResponseBody
    public Result<Boolean> updatePwd(String oldPassword, String newPassword) {
        if (StringUtils.isEmpty(oldPassword) || StringUtils.isEmpty(newPassword)) {
            return new Result<>(ResultCode.PARAMETER_EMPTY);
        }
        System.out.println(oldPassword);
        System.out.println(newPassword);

        UserInfoVO userInfoVO = getUserInfo();
        String account = userInfoVO.getAccount();

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
        LoginUtil.setCookieInvalid(request, response);
        System.out.println("logout...");

        return new Result(ResultCode.SUCCESS);
    }
}
