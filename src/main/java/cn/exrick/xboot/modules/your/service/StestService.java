package cn.exrick.xboot.modules.your.service;

import cn.exrick.xboot.base.XbootBaseService;
import cn.exrick.xboot.modules.your.entity.Stest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import cn.exrick.xboot.common.vo.SearchVo;

import java.util.List;

/**
 * 测试接口
 * @author SuGar
 */
public interface StestService extends XbootBaseService<Stest,String> {

    /**
    * 多条件分页获取
    * @param stest
    * @param searchVo
    * @param pageable
    * @return
    */
    Page<Stest> findByCondition(Stest stest, SearchVo searchVo, Pageable pageable);
}