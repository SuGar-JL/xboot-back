package cn.exrick.xboot.modules.your.serviceimpl;

import cn.exrick.xboot.modules.your.dao.StudentDao;
import cn.exrick.xboot.modules.your.entity.Student;
import cn.exrick.xboot.modules.your.service.StudentService;
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
 * 学生类接口实现
 * @author SuGar
 */
@Slf4j
@Service
@Transactional
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;

    @Override
    public StudentDao getRepository() {
        return studentDao;
    }

    @Override
    public Page<Student> findByCondition(Student student, SearchVo searchVo, Pageable pageable) {

        return studentDao.findAll(new Specification<Student>() {
            @Nullable
            @Override
            public Predicate toPredicate(Root<Student> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {

                // TODO 可添加你的其他搜索过滤条件 默认已有创建时间过滤
                Path<String> nameField = root.get("name");
                Path<String> sexField = root.get("sex");
                Path<String> birthdayField = root.get("birthday");
                Path<String> collegeNameField = root.get("collegeName");

                Path<Date> createTimeField=root.get("createTime");

                List<Predicate> list = new ArrayList<Predicate>();

                //创建时间
                if(StrUtil.isNotBlank(searchVo.getStartDate())&&StrUtil.isNotBlank(searchVo.getEndDate())){
                    Date start = DateUtil.parse(searchVo.getStartDate());
                    Date end = DateUtil.parse(searchVo.getEndDate());
                    list.add(cb.between(createTimeField, start, DateUtil.endOfDay(end)));
                }
                //模糊搜索
                //姓名
                if(StrUtil.isNotBlank(student.getName())){
                    list.add(cb.like(nameField, '%'+student.getName()+'%'));
                }
                //学院
                if(StrUtil.isNotBlank(student.getCollegeName())){
                    list.add(cb.like(collegeNameField, '%'+student.getCollegeName()+'%'));
                }
                //性别
                if(StrUtil.isNotBlank(student.getSex())){
                    list.add(cb.equal(sexField, student.getSex()));
                }
                //生日
                if(StrUtil.isNotBlank(student.getBirthday())){
                    list.add(cb.equal(birthdayField, student.getBirthday()));
                }
                Predicate[] arr = new Predicate[list.size()];
                cq.where(list.toArray(arr));
                return null;
            }
        }, pageable);
    }
}