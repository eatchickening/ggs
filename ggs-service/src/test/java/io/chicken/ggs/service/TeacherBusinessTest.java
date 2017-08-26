package io.chicken.ggs.service;

import io.chicken.ggs.business.TeacherBusiness;
import io.chicken.ggs.business.UserInfoBusiness;
import io.chicken.ggs.common.Result;
import io.chicken.ggs.common.vo.UserInfoQueryParam;
import io.chicken.ggs.common.vo.UserInfoVO;
import io.chicken.ggs.dal.model.Teacher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by nyh on 8/25/17.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = AppTest.class)
public class TeacherBusinessTest {

    @Autowired
    private TeacherBusiness teacherBusiness;

    @Test
    public void queryTeacher() {
        Object pageNum = new Object();
        pageNum = (Object)(new Integer(5));
        Object pageSize = new Object();
        pageSize = (Object)(new Integer(6));
        Map<String, Object> teaMap =  new HashMap<String, Object>();
        teaMap.put("pageNum", pageNum);
        teaMap.put("pageSize", pageSize);
        teaMap.put("name", "xiao");

        Result<Teacher> count = teacherBusiness.queryTeacherList(teaMap);
        System.out.println(count.getData());
    }
}