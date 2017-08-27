package io.chicken.ggs.service;

import io.chicken.ggs.business.PostBusiness;
import io.chicken.ggs.common.Result;
import io.chicken.ggs.dal.model.Post;
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
public class PostBusinessTest {

    @Autowired
    private PostBusiness postBusiness;

    @Test
    public void queryByDepartcode() {
        String departcode = "BM001";
        Result<List<Post>> list = postBusiness.queryByDepartcode(departcode);
        System.out.println(list.getData().size());
    }
}