package cn.exrick.xboot.modules.your.controller;

import cn.exrick.xboot.base.XbootBaseController;
import cn.exrick.xboot.common.utils.PageUtil;
import cn.exrick.xboot.common.utils.ResultUtil;
import cn.exrick.xboot.common.vo.PageVo;
import cn.exrick.xboot.common.vo.Result;
import cn.exrick.xboot.common.vo.SearchVo;
import cn.exrick.xboot.modules.your.entity.sw_sensor;
import cn.exrick.xboot.modules.your.service.sw_sensorService;
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
@RequestMapping("/xboot/sw_sensor")
@Transactional
public class sw_sensorController extends XbootBaseController<sw_sensor, String> {

    @Autowired
    private sw_sensorService sw_sensorService;

    @Override
    public sw_sensorService getService() {
        return sw_sensorService;
    }


    @RequestMapping(value = "/getByCondition", method = RequestMethod.GET)
    @ApiOperation(value = "多条件分页获取")
    public Result<Page<sw_sensor>> getByCondition(@ModelAttribute sw_sensor sw_sensor,
                                                            @ModelAttribute SearchVo searchVo,
                                                            @ModelAttribute PageVo pageVo){

        Page<sw_sensor> page = sw_sensorService.findByCondition(sw_sensor, searchVo, PageUtil.initPage(pageVo));
        return new ResultUtil<Page<sw_sensor>>().setData(page);
    }

}
