/*
 * Copyright (C), 2011-2017.
 */
package io.chicken.ggs.service;

import io.chicken.ggs.common.vo.AppraisedActivityQueryParam;
import io.chicken.ggs.dal.model.AppraisedActivity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author wung 2017/9/5.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = AppTest.class)
public class AppraisedActivityServiceTest {

    @Autowired
    private AppraisedActivityService appraisedActivityService;

    @Test
    public void queryList() {
        AppraisedActivityQueryParam param = new AppraisedActivityQueryParam();
        param.setActivityName("2017");
        List<AppraisedActivity> list = appraisedActivityService.queryList(param);
        System.out.println(list.size());
    }

    @Test
    public void queryTotal() {
        AppraisedActivityQueryParam param = new AppraisedActivityQueryParam();
        param.setActivityName("2018");
        Long count = appraisedActivityService.queryTotal(param);
        System.out.println(count);
    }
}
