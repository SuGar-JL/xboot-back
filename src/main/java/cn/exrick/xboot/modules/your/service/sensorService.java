package cn.exrick.xboot.modules.your.service;

import cn.exrick.xboot.base.XbootBaseService;
import cn.exrick.xboot.modules.your.entity.sensor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import cn.exrick.xboot.common.vo.SearchVo;

import java.util.List;

/**
 * 测试接口
 * @author SuGar
 */
public interface sensorService extends XbootBaseService<sensor,String> {

    /**
    * 多条件分页获取
    * @param sensor
    * @param searchVo
    * @param pageable
    * @return
    */
    Page<sensor> findByCondition(sensor sensor, SearchVo searchVo, Pageable pageable);
}