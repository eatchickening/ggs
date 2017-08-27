package io.chicken.ggs.service;

import io.chicken.ggs.business.OrganizationBusiness;
import io.chicken.ggs.common.Result;
import io.chicken.ggs.dal.model.Organization;
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
public class OrganizationBusinessTest {

    @Autowired
    private OrganizationBusiness organizationBusiness;

    @Test
    public void queryByAreacode() {
        String areacode = "QY003";
        Result<List<Organization>> list = organizationBusiness.queryByAreacode(areacode);
        System.out.println(list.getData().size());
    }
}