package cn.exrick.xboot.modules.your.controller;

import cn.exrick.xboot.base.XbootBaseController;
import cn.exrick.xboot.common.utils.PageUtil;
import cn.exrick.xboot.common.utils.ResultUtil;
import cn.exrick.xboot.common.vo.PageVo;
import cn.exrick.xboot.common.vo.Result;
import cn.exrick.xboot.common.vo.SearchVo;
import cn.exrick.xboot.modules.your.entity.sy_sensor;
import cn.exrick.xboot.modules.your.service.sy_sensorService;
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
@RequestMapping("/xboot/sy_sensor")
@Transactional
public class sy_sensorController extends XbootBaseController<sy_sensor, String> {

    @Autowired
    private sy_sensorService sy_sensorService;

    @Override
    public sy_sensorService getService() {
        return sy_sensorService;
    }


    @RequestMapping(value = "/getByCondition", method = RequestMethod.GET)
    @ApiOperation(value = "多条件分页获取")
    public Result<Page<sy_sensor>> getByCondition(@ModelAttribute sy_sensor sy_sensor,
                                                            @ModelAttribute SearchVo searchVo,
                                                            @ModelAttribute PageVo pageVo){

        Page<sy_sensor> page = sy_sensorService.findByCondition(sy_sensor, searchVo, PageUtil.initPage(pageVo));
        return new ResultUtil<Page<sy_sensor>>().setData(page);
    }

}
