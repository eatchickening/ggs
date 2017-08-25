package io.chicken.ggs.service;

import io.chicken.ggs.business.TeacherBusiness;
import io.chicken.ggs.dal.model.Teacher;

import java.util.List;
import java.util.Map;

/**
 * Created by nyh on 8/24/17.
 */
public interface TeacherService {
    List<Teacher> queryTeacherList(Map<String, Object> teaMap);
    long queryTotal(Map<String, Object> teaMap);
}
