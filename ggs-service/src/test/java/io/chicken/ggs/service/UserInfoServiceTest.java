
package io.chicken.ggs.service;

import io.chicken.ggs.common.vo.UserInfoQueryParam;
import io.chicken.ggs.common.vo.UserInfoVO;
import io.chicken.ggs.dal.model.UserInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

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
        userInfo.setAccount("test2");
        userInfo.setUsername("李四");
        userInfoService.save(userInfo);
    }

    @Test
    public void saveBatch() {
        for (int i = 3; i < 500; i++) {
            UserInfo userInfo = new UserInfo();
            userInfo.setAccount("test" + i);
            userInfo.setUsername("李四" + i);
            userInfoService.save(userInfo);
        }
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

    @Test
    public void queryList() {
        UserInfoQueryParam param = new UserInfoQueryParam();
        param.setPageNum(1);
        param.setPageSize(10);
        param.setAccount("test20");
        // param.setOrganName("机构");
        // param.setDepartName("部门");
        List<UserInfoVO> list = userInfoService.queryList(param);
        System.out.println(list);
    }

    @Test
    public void queryCount() {
        UserInfoQueryParam param = new UserInfoQueryParam();
        param.setPageSize(10);
        param.setPageNum(1);
        param.setAccount("test1");
        // param.setOrganName("教育局");
        param.setDepartName("办公公司");
        param.setPostName("教师");
        Long count = userInfoService.queryCount(param);
        System.out.println(count);
    }
}
