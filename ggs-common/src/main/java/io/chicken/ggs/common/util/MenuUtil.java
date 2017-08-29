/*
 * Copyright (C), 2011-2017.
 */
package io.chicken.ggs.common.util;

/**
 *
 * @author wung 2017/8/24.
 */
public class MenuUtil {

    /**
     * 判断请求的 url 是否有权限（含有 perms 里的值即可）
     *
     * @param perms
     * @param url
     * @return
     */
    public static boolean hasAuth(String[] perms, String url) {
        if (perms == null || perms.length == 0 || url == null) {
            return false;
        }
        for (String perm : perms) {
            if (url.contains(perm)) { // 有漏洞不？ todo
                return true;
            }
        }
        return false;
    }

    // public static String getMenu(Integer id) {
    //     return null;
    // }
}
