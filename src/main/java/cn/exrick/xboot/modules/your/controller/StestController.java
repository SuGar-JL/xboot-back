package cn.exrick.xboot.modules.your.controller;

import cn.exrick.xboot.base.XbootBaseController;
import cn.exrick.xboot.common.utils.PageUtil;
import cn.exrick.xboot.common.utils.ResultUtil;
import cn.exrick.xboot.common.vo.PageVo;
import cn.exrick.xboot.common.vo.Result;
import cn.exrick.xboot.common.vo.SearchVo;
import cn.exrick.xboot.modules.your.entity.Stest;
import cn.exrick.xboot.modules.your.service.StestService;
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
@RequestMapping("/xboot/stest")
@Transactional
public class StestController extends XbootBaseController<Stest, String> {

    @Autowired
    private StestService stestService;

    @Override
    public StestService getService() {
        return stestService;
    }


    @RequestMapping(value = "/getByCondition", method = RequestMethod.GET)
    @ApiOperation(value = "多条件分页获取")
    public Result<Page<Stest>> getByCondition(@ModelAttribute Stest stest,
                                                            @ModelAttribute SearchVo searchVo,
                                                            @ModelAttribute PageVo pageVo){

        Page<Stest> page = stestService.findByCondition(stest, searchVo, PageUtil.initPage(pageVo));
        return new ResultUtil<Page<Stest>>().setData(page);
    }

}
