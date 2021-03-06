package cn.exrick.xboot.modules.your.service;

import cn.exrick.xboot.base.XbootBaseService;
import cn.exrick.xboot.modules.your.entity.fl_sensor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import cn.exrick.xboot.common.vo.SearchVo;

import java.util.List;

/**
 * 测试接口
 * @author SuGar
 */
public interface fl_sensorService extends XbootBaseService<fl_sensor,String> {

    /**
    * 多条件分页获取
    * @param fl_sensor
    * @param searchVo
    * @param pageable
    * @return
    */
    Page<fl_sensor> findByCondition(fl_sensor fl_sensor, SearchVo searchVo, Pageable pageable);
}