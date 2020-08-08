package cn.exrick.xboot.modules.your.controller;

import cn.exrick.xboot.base.XbootBaseController;
import cn.exrick.xboot.common.utils.PageUtil;
import cn.exrick.xboot.common.utils.ResultUtil;
import cn.exrick.xboot.common.vo.PageVo;
import cn.exrick.xboot.common.vo.Result;
import cn.exrick.xboot.common.vo.SearchVo;
import cn.exrick.xboot.modules.your.entity.sl_sensor;
import cn.exrick.xboot.modules.your.service.sl_sensorService;
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
@RequestMapping("/xboot/sl_sensor")
@Transactional
public class sl_sensorController extends XbootBaseController<sl_sensor, String> {

    @Autowired
    private sl_sensorService sl_sensorService;

    @Override
    public sl_sensorService getService() {
        return sl_sensorService;
    }


    @RequestMapping(value = "/getByCondition", method = RequestMethod.GET)
    @ApiOperation(value = "多条件分页获取")
    public Result<Page<sl_sensor>> getByCondition(@ModelAttribute sl_sensor sl_sensor,
                                                            @ModelAttribute SearchVo searchVo,
                                                            @ModelAttribute PageVo pageVo){

        Page<sl_sensor> page = sl_sensorService.findByCondition(sl_sensor, searchVo, PageUtil.initPage(pageVo));
        return new ResultUtil<Page<sl_sensor>>().setData(page);
    }

}
