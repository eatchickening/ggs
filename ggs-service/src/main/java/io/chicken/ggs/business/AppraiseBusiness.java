package io.chicken.ggs.business;

import io.chicken.ggs.common.Result;
import io.chicken.ggs.common.vo.AppraiseParameter;
import io.chicken.ggs.common.vo.AppraiseSchoolVo;
import io.chicken.ggs.common.vo.AppraiseVo;
import io.chicken.ggs.dal.model.Appraise;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
 * Created by nyh on 8/31/17.
 */
public interface AppraiseBusiness {

    Result<List<Appraise>> queryList(String appraiseName, Integer pageNum, Integer pageSize);

    Result<List<Appraise>> queryList(Map<String, Object> params);


    Result save(AppraiseVo appraiseVo);
    Result save(AppraiseSchoolVo appraiseVo);

    Result update(AppraiseVo appraiseVo);

    Result update(AppraiseSchoolVo appraiseVo);

    Result savefile(String appraisecode,String awardcode, MultipartFile file);

    Result<List<Appraise>> queryListByIds(List<Long> ids);

    Result delete(Long id);

    Result deleteSchoolAppraise(Long id);

    Result getDetail(Long id);

    Result getAppraiseInfo(Long id);
}
