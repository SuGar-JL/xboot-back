package cn.exrick.xboot.modules.your.service;

import cn.exrick.xboot.base.XbootBaseService;
import cn.exrick.xboot.modules.your.entity.College;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import cn.exrick.xboot.common.vo.SearchVo;

/**
 * 学院类接口
 * @author SuGar
 */
public interface CollegeService extends XbootBaseService<College,String> {

    /**
    * 多条件分页获取
    * @param college
    * @param searchVo
    * @param pageable
    * @return
    */
    Page<College> findByCondition(College college, SearchVo searchVo, Pageable pageable);
}