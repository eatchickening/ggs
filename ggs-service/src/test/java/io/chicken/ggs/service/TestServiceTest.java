
package io.chicken.ggs.service;

import io.chicken.ggs.dal.dao.DictionaryMapper;
import io.chicken.ggs.dal.model.Dictionary;
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
public class TestServiceTest {
    @Autowired
   private DictionaryMapper dictionaryMapper;

    @Test
    public void testInsert()
    {
        Dictionary record =new Dictionary ();
        record.setId(new Long(2));
        record.setBizcode("2");
        record.setBiztype("area");
        record.setDatavalue("街道");
        record.setStatus(new Byte("1"));
        dictionaryMapper.insertSelective(record);
    }

}
