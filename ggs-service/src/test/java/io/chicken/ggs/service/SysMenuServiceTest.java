/*
 * Copyright (C), 2011-2017.
 */
package io.chicken.ggs.service;

import io.chicken.ggs.dal.model.SysMenu;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.List;

/**
 * @author wung 2017/8/29.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = AppTest.class)
public class SysMenuServiceTest {

    @Autowired
    private SysMenuService sysMenuService;

    @Test
    public void queryList() {
        List<Integer> ids = Arrays.asList(1,2,3);
        System.out.println(ids);
        List<SysMenu> list = sysMenuService.queryList(ids);
        System.out.println(list.size());
    }

    @Test
    public void queryAllList() {
        List<SysMenu> list = sysMenuService.queryAllList();
        System.out.println(list.size());
    }
}
