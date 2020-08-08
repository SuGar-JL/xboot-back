package cn.exrick.xboot.modules.your.controller;

import cn.exrick.xboot.base.XbootBaseController;
import cn.exrick.xboot.common.utils.PageUtil;
import cn.exrick.xboot.common.utils.ResultUtil;
import cn.exrick.xboot.common.vo.PageVo;
import cn.exrick.xboot.common.vo.Result;
import cn.exrick.xboot.common.vo.SearchVo;
import cn.exrick.xboot.modules.your.entity.fl_sensor;
import cn.exrick.xboot.modules.your.service.fl_sensorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author SuGar
 */
@Slf4j
@RestController
@Api(description = "X类型传感器数据接口")
@RequestMapping("/xboot/fl_sensor")
@Transactional
public class fl_sensorController extends XbootBaseController<fl_sensor, String> {

    @Autowired
    private fl_sensorService fl_sensorService;

    @Override
    public fl_sensorService getService() {
        return fl_sensorService;
    }


    @RequestMapping(value = "/getByCondition", method = RequestMethod.GET)
    @ApiOperation(value = "多条件分页获取")
    public Result<Page<fl_sensor>> getByCondition(@ModelAttribute fl_sensor fl_sensor,
                                                            @ModelAttribute SearchVo searchVo,
                                                            @ModelAttribute PageVo pageVo){

        Page<fl_sensor> page = fl_sensorService.findByCondition(fl_sensor, searchVo, PageUtil.initPage(pageVo));
        return new ResultUtil<Page<fl_sensor>>().setData(page);
    }

}
