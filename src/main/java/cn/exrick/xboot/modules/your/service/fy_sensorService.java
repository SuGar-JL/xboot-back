package cn.exrick.xboot.modules.your.service;

import cn.exrick.xboot.base.XbootBaseService;
import cn.exrick.xboot.modules.your.entity.fy_sensor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import cn.exrick.xboot.common.vo.SearchVo;

import java.util.List;

/**
 * 测试接口
 * @author SuGar
 */
public interface fy_sensorService extends XbootBaseService<fy_sensor,String> {

    /**
    * 多条件分页获取
    * @param fy_sensor
    * @param searchVo
    * @param pageable
    * @return
    */
    Page<fy_sensor> findByCondition(fy_sensor fy_sensor, SearchVo searchVo, Pageable pageable);
}