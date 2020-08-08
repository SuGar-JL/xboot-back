package cn.exrick.xboot.modules.your.serviceimpl;

import cn.exrick.xboot.modules.your.dao.sl_sensorDao;
import cn.exrick.xboot.modules.your.entity.sl_sensor;
import cn.exrick.xboot.modules.your.service.sl_sensorService;
import cn.exrick.xboot.common.vo.SearchVo;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.lang.reflect.Field;

/**
 * 测试接口实现
 * @author SuGar
 */
@Slf4j
@Service
@Transactional
public class sl_sensorServiceImpl implements sl_sensorService {

    @Autowired
    private sl_sensorDao sl_sensorDao;

    @Override
    public sl_sensorDao getRepository() {
        return sl_sensorDao;
    }

    @Override
    public Page<sl_sensor> findByCondition(sl_sensor sl_sensor, SearchVo searchVo, Pageable pageable) {

        return sl_sensorDao.findAll(new Specification<sl_sensor>() {
            @Nullable
            @Override
            public Predicate toPredicate(Root<sl_sensor> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {

                // TODO 可添加你的其他搜索过滤条件 默认已有创建时间过滤
                Path<Date> createTimeField=root.get("createTime");

                List<Predicate> list = new ArrayList<Predicate>();

                //创建时间
                if(StrUtil.isNotBlank(searchVo.getStartDate())&&StrUtil.isNotBlank(searchVo.getEndDate())){
                    Date start = DateUtil.parse(searchVo.getStartDate());
                    Date end = DateUtil.parse(searchVo.getEndDate());
                    list.add(cb.between(createTimeField, start, DateUtil.endOfDay(end)));
                }

                Predicate[] arr = new Predicate[list.size()];
                cq.where(list.toArray(arr));
                return null;
            }
        }, pageable);
    }
}