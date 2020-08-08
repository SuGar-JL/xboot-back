package cn.exrick.xboot.modules.your.service;

import cn.exrick.xboot.base.XbootBaseService;
import cn.exrick.xboot.modules.your.entity.Grade;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import cn.exrick.xboot.common.vo.SearchVo;

/**
 * 年级类接口
 * @author SuGar
 */
public interface GradeService extends XbootBaseService<Grade,String> {

    /**
    * 多条件分页获取
    * @param grade
    * @param searchVo
    * @param pageable
    * @return
    */
    Page<Grade> findByCondition(Grade grade, SearchVo searchVo, Pageable pageable);
}