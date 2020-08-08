package cn.exrick.xboot.modules.your.service;

import cn.exrick.xboot.base.XbootBaseService;
import cn.exrick.xboot.modules.your.entity.sy_sensor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import cn.exrick.xboot.common.vo.SearchVo;

import java.util.List;

/**
 * 测试接口
 * @author SuGar
 */
public interface sy_sensorService extends XbootBaseService<sy_sensor,String> {

    /**
    * 多条件分页获取
    * @param sy_sensor
    * @param searchVo
    * @param pageable
    * @return
    */
    Page<sy_sensor> findByCondition(sy_sensor sy_sensor, SearchVo searchVo, Pageable pageable);
}