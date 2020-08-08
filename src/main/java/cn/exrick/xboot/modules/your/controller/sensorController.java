package cn.exrick.xboot.modules.your.controller;

import cn.exrick.xboot.base.XbootBaseController;
import cn.exrick.xboot.common.utils.PageUtil;
import cn.exrick.xboot.common.utils.ResultUtil;
import cn.exrick.xboot.common.vo.PageVo;
import cn.exrick.xboot.common.vo.Result;
import cn.exrick.xboot.common.vo.SearchVo;
import cn.exrick.xboot.modules.your.entity.sensor;
import cn.exrick.xboot.modules.your.service.sensorService;
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
@Api(description = "传感器数据接口")
@RequestMapping("/xboot/sensor")
@Transactional
public class sensorController extends XbootBaseController<sensor, String> {

    @Autowired
    private sensorService sensorService;

    @Override
    public sensorService getService() {
        return sensorService;
    }


    @RequestMapping(value = "/getByCondition", method = RequestMethod.GET)
    @ApiOperation(value = "多条件分页获取")
    public Result<Page<sensor>> getByCondition(@ModelAttribute sensor sensor,
                                                            @ModelAttribute SearchVo searchVo,
                                                            @ModelAttribute PageVo pageVo){

        Page<sensor> page = sensorService.findByCondition(sensor, searchVo, PageUtil.initPage(pageVo));
        return new ResultUtil<Page<sensor>>().setData(page);
    }

}
