package io.chicken.ggs.service;

import io.chicken.ggs.business.DictionaryBusiness;
import io.chicken.ggs.business.TeacherBusiness;
import io.chicken.ggs.common.CommonConstant;
import io.chicken.ggs.common.Result;
import io.chicken.ggs.dal.model.Dictionary;
import io.chicken.ggs.dal.model.Teacher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * Created by wung on 8/25/17.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = AppTest.class)
public class DictionaryBusinessTest {

    @Autowired
    private DictionaryBusiness dictionaryBusiness;

    @Test
    public void queryList() {

        Map<String, Object> teaMap =  new HashMap<>();
        teaMap.put("biztype", CommonConstant.DIC_AREA_CODE);
        teaMap.put("bizcode", "QY001");

        Result<List<Dictionary>> count = dictionaryBusiness.queryList(teaMap);
        System.out.println(count.getData().size());
    }
}