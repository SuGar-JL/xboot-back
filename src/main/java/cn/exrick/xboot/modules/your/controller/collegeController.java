package cn.exrick.xboot.modules.your.controller;

import cn.exrick.xboot.base.XbootBaseController;
import cn.exrick.xboot.common.utils.PageUtil;
import cn.exrick.xboot.common.utils.ResultUtil;
import cn.exrick.xboot.common.vo.PageVo;
import cn.exrick.xboot.common.vo.Result;
import cn.exrick.xboot.common.vo.SearchVo;
import cn.exrick.xboot.modules.your.entity.College;
import cn.exrick.xboot.modules.your.service.CollegeService;
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
@Api(description = "学院类管理接口")
@RequestMapping("/xboot/college")
@Transactional
public class collegeController extends XbootBaseController<College, String> {

    @Autowired
    private CollegeService collegeService;

    @Override
    public CollegeService getService() {
        return collegeService;
    }


    @RequestMapping(value = "/getByCondition", method = RequestMethod.GET)
    @ApiOperation(value = "多条件分页获取")
    public Result<Page<College>> getByCondition(@ModelAttribute College college,
												@ModelAttribute SearchVo searchVo,
												@ModelAttribute PageVo pageVo){

        Page<College> page = collegeService.findByCondition(college, searchVo, PageUtil.initPage(pageVo));
        return new ResultUtil<Page<College>>().setData(page);
    }

}
