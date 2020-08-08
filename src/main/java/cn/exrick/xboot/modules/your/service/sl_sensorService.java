package cn.exrick.xboot.modules.your.service;

import cn.exrick.xboot.base.XbootBaseService;
import cn.exrick.xboot.modules.your.entity.sl_sensor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import cn.exrick.xboot.common.vo.SearchVo;

import java.util.List;

/**
 * 测试接口
 * @author SuGar
 */
public interface sl_sensorService extends XbootBaseService<sl_sensor,String> {

    /**
    * 多条件分页获取
    * @param sl_sensor
    * @param searchVo
    * @param pageable
    * @return
    */
    Page<sl_sensor> findByCondition(sl_sensor sl_sensor, SearchVo searchVo, Pageable pageable);
}