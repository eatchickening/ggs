package io.chicken.ggs.service;

import io.chicken.ggs.business.DepartBusiness;
import io.chicken.ggs.common.Result;
import io.chicken.ggs.dal.model.Depart;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 *
 * Created by wung on 8/25/17.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = AppTest.class)
public class DepartBusinessTest {

    @Autowired
    private DepartBusiness departBusiness;

    @Test
    public void queryByOrgancode() {
        String areacode = "JG001";
        Result<List<Depart>> list = departBusiness.queryByOrgancode(areacode);
        System.out.println(list.getData().size());
    }
}