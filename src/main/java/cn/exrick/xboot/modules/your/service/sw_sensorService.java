package cn.exrick.xboot.modules.your.service;

import cn.exrick.xboot.base.XbootBaseService;
import cn.exrick.xboot.modules.your.entity.sw_sensor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import cn.exrick.xboot.common.vo.SearchVo;

import java.util.List;

/**
 * 测试接口
 * @author SuGar
 */
public interface sw_sensorService extends XbootBaseService<sw_sensor,String> {

    /**
    * 多条件分页获取
    * @param sw_sensor
    * @param searchVo
    * @param pageable
    * @return
    */
    Page<sw_sensor> findByCondition(sw_sensor sw_sensor, SearchVo searchVo, Pageable pageable);
}