package cn.exrick.xboot.modules.your.serviceimpl;

import cn.exrick.xboot.modules.base.entity.Department;
import cn.exrick.xboot.modules.base.entity.Permission;
import cn.exrick.xboot.modules.base.entity.Role;
import cn.exrick.xboot.modules.your.dao.CollegeDao;
import cn.exrick.xboot.modules.your.dao.GradeDao;
import cn.exrick.xboot.modules.your.dao.StudentDao;
import cn.exrick.xboot.modules.your.entity.College;
import cn.exrick.xboot.modules.your.entity.Grade;
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

/**
 * 学生类接口实现
 *
 * @author SuGar
 */
@Slf4j
@Service
@Transactional
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDao studentDao;

	@Autowired
	private CollegeDao collegeDao;

	@Autowired
	private GradeDao gradeDao;

	@Override
	public StudentDao getRepository() {
		return studentDao;
	}

	@Override
	public List<Student> findByname(String name) {
		List<Student> students = studentDao.findByname(name);
		for (Student student : students) {

			//关联学院
			if (StrUtil.isNotBlank(student.getCollegeId())) {
				College college = collegeDao.findById(student.getCollegeId()).orElse(null);
				if (college != null) {
					student.setCollegeName(college.getName());
				}
			}
			// 关联年级
			if (StrUtil.isNotBlank(student.getGradeId())) {
				Grade grade = gradeDao.findById(student.getGradeId()).orElse(null);
				if (grade != null) {
					student.setGradeName(grade.getName());
				}
			}
		}
		return students;
	}

	@Override
	public List<Student> findBySex(String sex) {
		return studentDao.findBySex(sex);
	}

	@Override
	public List<Student> findByBirthday(String birthday) {
		return studentDao.findByBirthday(birthday);
	}

	@Override
	public List<Student> findByCollegeId(String collegeId) {
		return studentDao.findByCollegeId(collegeId);
	}

	@Override
	public List<Student> findByNameLike(String name) {
		return studentDao.findByNameLike(name);
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
				Path<String> collegeIdField = root.get("collegeId");
				Path<String> gradeIdField = root.get("gradeId");
				Path<Date> createTimeField = root.get("createTime");

				List<Predicate> list = new ArrayList<Predicate>();

				//创建时间
				if (StrUtil.isNotBlank(searchVo.getStartDate()) && StrUtil.isNotBlank(searchVo.getEndDate())) {
					Date start = DateUtil.parse(searchVo.getStartDate());
					Date end = DateUtil.parse(searchVo.getEndDate());
					list.add(cb.between(createTimeField, start, DateUtil.endOfDay(end)));
				}

				//模糊搜素
				if (StrUtil.isNotBlank(student.getName())) {
					list.add(cb.like(nameField, '%' + student.getName() + '%'));
				}
				//性别
				if (StrUtil.isNotBlank(student.getSex())) {
					list.add(cb.equal(sexField, student.getSex()));
				}
				//生日
				if (StrUtil.isNotBlank(student.getBirthday())) {
					list.add(cb.equal(sexField, student.getBirthday()));
				}

				//学院
				if (StrUtil.isNotBlank(student.getCollegeId())) {
					list.add(cb.equal(collegeIdField, student.getCollegeId()));
				}

				//年级
				if (StrUtil.isNotBlank(student.getGradeId())) {
					list.add(cb.equal(gradeIdField, student.getGradeId()));
				}

				Predicate[] arr = new Predicate[list.size()];
				cq.where(list.toArray(arr));
				return null;
			}
		}, pageable);
	}
}