
package io.chicken.ggs.service;

import io.chicken.ggs.dal.model.UserInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author wung 2017/8/21.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = AppTest.class)
public class UserInfoServiceTest {

    @Autowired
    private UserInfoService userInfoService;

    @Test
    public void save() {
        UserInfo userInfo = new UserInfo();
        userInfo.setAccount("test1");
        userInfo.setUsername("张三");
        userInfoService.save(userInfo);
    }


    @Test
    public void update() {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(1);
        userInfo.setAccount("test1");
        userInfo.setUsername("李四");
        userInfoService.update(userInfo);
    }

    @Test
    public void query() {
        Integer id = 1;
        UserInfo user = userInfoService.query(id);
        System.out.println(user);
    }
}
