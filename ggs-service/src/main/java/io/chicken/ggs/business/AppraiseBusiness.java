package io.chicken.ggs.business;

import io.chicken.ggs.common.Result;
import io.chicken.ggs.common.vo.AppraiseVo;
import io.chicken.ggs.dal.model.Appraise;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by nyh on 8/31/17.
 */
public interface AppraiseBusiness {

    Result<List<Appraise>> queryList(String appraiseName, Integer pageNum, Integer pageSize);

    Result save(AppraiseVo appraiseVo);

    Result savefile(String appraisecode,String awardcode, MultipartFile file);

    Result<List<Appraise>> queryListByIds(List<Long> ids);

    Result delete(Long id);
}
