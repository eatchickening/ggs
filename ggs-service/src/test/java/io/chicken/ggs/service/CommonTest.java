/*
 * Copyright (C), 2011-2017.
 */
package io.chicken.ggs.service;

import io.chicken.ggs.common.util.PropertiesUtils;
import io.chicken.ggs.dal.model.UserInfo;
import org.junit.Test;

/**
 * @author wung 2017/8/31.
 */
public class CommonTest {

    @Test
    public void isEmpty() {
        assert PropertiesUtils.isEmpty(null);
        assert PropertiesUtils.isEmpty("");

        UserInfo userInfo = new UserInfo();
        assert PropertiesUtils.isEmpty(userInfo);

        userInfo.setAccount("");
        assert PropertiesUtils.isEmpty(userInfo);

        userInfo.setId(2);
        assert !PropertiesUtils.isEmpty(userInfo);
    }
}
