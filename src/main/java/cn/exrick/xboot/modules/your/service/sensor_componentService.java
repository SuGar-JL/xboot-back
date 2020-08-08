package cn.exrick.xboot.modules.your.service;

import cn.exrick.xboot.base.XbootBaseService;
import cn.exrick.xboot.modules.your.entity.sensor_component;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import cn.exrick.xboot.common.vo.SearchVo;

import java.util.List;

/**
 * 测试接口
 * @author SuGar
 */
public interface sensor_componentService extends XbootBaseService<sensor_component,String> {

    /**
    * 多条件分页获取
    * @param sensor_component
    * @param searchVo
    * @param pageable
    * @return
    */
    Page<sensor_component> findByCondition(sensor_component sensor_component, SearchVo searchVo, Pageable pageable);
}