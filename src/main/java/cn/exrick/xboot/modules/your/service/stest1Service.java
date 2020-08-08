package cn.exrick.xboot.modules.your.service;

import cn.exrick.xboot.base.XbootBaseService;
import cn.exrick.xboot.modules.your.entity.stest1;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import cn.exrick.xboot.common.vo.SearchVo;

import java.util.List;

/**
 * 测试接口
 * @author SuGar
 */
public interface stest1Service extends XbootBaseService<stest1,String> {

    /**
    * 多条件分页获取
    * @param stest1
    * @param searchVo
    * @param pageable
    * @return
    */
    Page<stest1> findByCondition(stest1 stest1, SearchVo searchVo, Pageable pageable);
}