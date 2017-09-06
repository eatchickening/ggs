/*
 * Copyright (C), 2011-2017.
 */
package io.chicken.ggs.service;

import io.chicken.ggs.common.vo.AppraisedActivityQueryParam;
import io.chicken.ggs.dal.model.Appraise;
import io.chicken.ggs.dal.model.AppraisedActivity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = AppTest.class)
public class AppraisedServiceTest {

    @Autowired
    private AppraiseService appraiseService;

    @Test
    public void queryListByids() {
        List<Long> ids=new ArrayList<Long>();
        ids.add(new Long(13));
        ids.add(new Long(14));

        List<Appraise> list = appraiseService.queryListByIds(ids);
        System.out.println(list.size());
    }


}
