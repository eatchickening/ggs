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
     * @param uri
     * @return
     */
    public static boolean hasAuth(String[] perms, String uri) {
        if (perms == null || perms.length == 0 || uri == null) {
            return false;
        }
        for (String perm : perms) {
            if (uri.startsWith(perm)) {
                return true;
            }
        }
        return false;
    }

    // public static String getMenu(Integer id) {
    //     return null;
    // }
}
