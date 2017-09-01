package io.chicken.ggs.business;

import io.chicken.ggs.common.Result;
import io.chicken.ggs.common.vo.TeacherList;
import io.chicken.ggs.common.vo.TeacherQueryParam;
import io.chicken.ggs.dal.model.Teacher;

import java.util.List;
import java.util.Map;

/**
 * Created by nyh on 8/24/17.
 */
public interface TeacherBusiness {
    Result<List<TeacherList>> queryTeacherList(TeacherQueryParam teaParam);
}
