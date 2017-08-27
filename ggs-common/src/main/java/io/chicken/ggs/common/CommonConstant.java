
package io.chicken.ggs.common;

/**
 * 系统常量
 *
 * @author wungmc 2017/6/21.
 */
public class CommonConstant {

    /** 默认的当前页数 */
    public static final Integer PAGE_NUM = 1;
    /** 默认的每页条数 */
    public static final Integer PAGE_SIZE = 10;
    /** 一次查询取多少页 */
    public static final Integer PAGE_PRE = 10;

    /** 用户账号的 cookie 名 */
    public static final String ACCOUNT_COOKIE = "_GGSA";
    /** token 的 cookie 名 */
    public static final String TOKEN_COOKIE = "_GGST";
    /** 账号cookie的存活时间（秒） */
    public static final int ACCOUNT_COOKIE_EXPIRED = 30 * 24 * 60 * 60;

    /** 用户删除状态 */
    public static final int USER_STATUS_DELETE = 1;
}
