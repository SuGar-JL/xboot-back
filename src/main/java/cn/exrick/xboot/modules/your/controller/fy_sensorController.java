package cn.exrick.xboot.modules.your.controller;

import cn.exrick.xboot.base.XbootBaseController;
import cn.exrick.xboot.common.utils.PageUtil;
import cn.exrick.xboot.common.utils.ResultUtil;
import cn.exrick.xboot.common.vo.PageVo;
import cn.exrick.xboot.common.vo.Result;
import cn.exrick.xboot.common.vo.SearchVo;
import cn.exrick.xboot.modules.your.entity.fy_sensor;
import cn.exrick.xboot.modules.your.service.fy_sensorService;
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
@RequestMapping("/xboot/fy_sensor")
@Transactional
public class fy_sensorController extends XbootBaseController<fy_sensor, String> {

    @Autowired
    private fy_sensorService fy_sensorService;

    @Override
    public fy_sensorService getService() {
        return fy_sensorService;
    }


    @RequestMapping(value = "/getByCondition", method = RequestMethod.GET)
    @ApiOperation(value = "多条件分页获取")
    public Result<Page<fy_sensor>> getByCondition(@ModelAttribute fy_sensor fy_sensor,
                                                            @ModelAttribute SearchVo searchVo,
                                                            @ModelAttribute PageVo pageVo){

        Page<fy_sensor> page = fy_sensorService.findByCondition(fy_sensor, searchVo, PageUtil.initPage(pageVo));
        return new ResultUtil<Page<fy_sensor>>().setData(page);
    }

}
