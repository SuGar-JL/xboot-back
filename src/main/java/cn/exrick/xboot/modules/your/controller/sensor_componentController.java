package cn.exrick.xboot.modules.your.controller;

import cn.exrick.xboot.base.XbootBaseController;
import cn.exrick.xboot.common.utils.PageUtil;
import cn.exrick.xboot.common.utils.ResultUtil;
import cn.exrick.xboot.common.vo.PageVo;
import cn.exrick.xboot.common.vo.Result;
import cn.exrick.xboot.common.vo.SearchVo;
import cn.exrick.xboot.modules.your.entity.sensor_component;
import cn.exrick.xboot.modules.your.service.sensor_componentService;
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
@Api(description = "传感器外部构件接口")
@RequestMapping("/xboot/sensor_component")
@Transactional
public class sensor_componentController extends XbootBaseController<sensor_component, String> {

    @Autowired
    private sensor_componentService sensor_componentService;

    @Override
    public sensor_componentService getService() {
        return sensor_componentService;
    }


    @RequestMapping(value = "/getByCondition", method = RequestMethod.GET)
    @ApiOperation(value = "多条件分页获取")
    public Result<Page<sensor_component>> getByCondition(@ModelAttribute sensor_component sensor_component,
                                                            @ModelAttribute SearchVo searchVo,
                                                            @ModelAttribute PageVo pageVo){

        Page<sensor_component> page = sensor_componentService.findByCondition(sensor_component, searchVo, PageUtil.initPage(pageVo));
        return new ResultUtil<Page<sensor_component>>().setData(page);
    }

}
