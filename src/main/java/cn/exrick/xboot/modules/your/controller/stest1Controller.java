package cn.exrick.xboot.modules.your.controller;

import cn.exrick.xboot.base.XbootBaseController;
import cn.exrick.xboot.common.utils.PageUtil;
import cn.exrick.xboot.common.utils.ResultUtil;
import cn.exrick.xboot.common.vo.PageVo;
import cn.exrick.xboot.common.vo.Result;
import cn.exrick.xboot.common.vo.SearchVo;
import cn.exrick.xboot.modules.your.entity.stest1;
import cn.exrick.xboot.modules.your.service.stest1Service;
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
@Api(description = "测试管理接口")
@RequestMapping("/xboot/stest1")
@Transactional
public class stest1Controller extends XbootBaseController<stest1, String> {

    @Autowired
    private stest1Service stest1Service;

    @Override
    public stest1Service getService() {
        return stest1Service;
    }


    @RequestMapping(value = "/getByCondition", method = RequestMethod.GET)
    @ApiOperation(value = "多条件分页获取")
    public Result<Page<stest1>> getByCondition(@ModelAttribute stest1 stest1,
                                                            @ModelAttribute SearchVo searchVo,
                                                            @ModelAttribute PageVo pageVo){

        Page<stest1> page = stest1Service.findByCondition(stest1, searchVo, PageUtil.initPage(pageVo));
        return new ResultUtil<Page<stest1>>().setData(page);
    }

}
