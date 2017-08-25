
package io.chicken.ggs.service;

import io.chicken.ggs.business.UserInfoBusiness;
import io.chicken.ggs.common.Result;
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
public class UserInfoBusinessTest {

    @Autowired
    private UserInfoBusiness userInfoBusiness;

    @Test
    public void queryList() {
        UserInfoQueryParam param = new UserInfoQueryParam();
        param.setPageNum(1);
        param.setPageSize(10);
        param.setAccount("test1");
        Result<List<UserInfoVO>> list = userInfoBusiness.queryList(param);
        System.out.println(list.isSuccess());
    }

    @Test
    public void queryCount() {
        UserInfoQueryParam param = new UserInfoQueryParam();
        param.setPageSize(10);
        param.setPageNum(1);
        // param.setAccount("test1");
        // param.setOrganName("教育局");
        // param.setDepartName("办公公司");
        // param.setPostName("教师");
        Result<Long> count = userInfoBusiness.queryCount(param);
        System.out.println(count.getData());
    }
}
