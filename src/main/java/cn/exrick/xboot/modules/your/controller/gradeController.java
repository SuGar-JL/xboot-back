package cn.exrick.xboot.modules.your.controller;

import cn.exrick.xboot.base.XbootBaseController;
import cn.exrick.xboot.common.utils.PageUtil;
import cn.exrick.xboot.common.utils.ResultUtil;
import cn.exrick.xboot.common.vo.PageVo;
import cn.exrick.xboot.common.vo.Result;
import cn.exrick.xboot.common.vo.SearchVo;
import cn.exrick.xboot.modules.your.entity.Grade;
import cn.exrick.xboot.modules.your.service.GradeService;
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
@Api(description = "年级类管理接口")
@RequestMapping("/xboot/grade")
@Transactional
public class gradeController extends XbootBaseController<Grade, String> {

    @Autowired
    private GradeService gradeService;

    @Override
    public GradeService getService() {
        return gradeService;
    }


    @RequestMapping(value = "/getByCondition", method = RequestMethod.GET)
    @ApiOperation(value = "多条件分页获取")
    public Result<Page<Grade>> getByCondition(@ModelAttribute Grade grade,
											  @ModelAttribute SearchVo searchVo,
											  @ModelAttribute PageVo pageVo){

        Page<Grade> page = gradeService.findByCondition(grade, searchVo, PageUtil.initPage(pageVo));
        return new ResultUtil<Page<Grade>>().setData(page);
    }

}
