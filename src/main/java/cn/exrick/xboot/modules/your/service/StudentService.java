package cn.exrick.xboot.modules.your.service;

import cn.exrick.xboot.base.XbootBaseService;
import cn.exrick.xboot.modules.your.entity.Student;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import cn.exrick.xboot.common.vo.SearchVo;

import java.util.List;

/**
 * 学生类接口
 *
 * @author SuGar
 */
public interface StudentService extends XbootBaseService<Student, String> {


	/**
	 * 通过姓名获取学生
	 * @param name
	 * @return
	 */
	List<Student> findByname(String name);

	/**
	 * 通过性别获取学生
	 * @param sex
	 * @return
	 */
	List<Student> findBySex(String sex);

	/**
	 * 通过生日获取学生
	 * @param birthday
	 * @return
	 */
	List<Student> findByBirthday(String birthday);

	/**
	 * 通过学院id获取
	 * @param collegeId
	 * @return
	 */
	List<Student> findByCollegeId(String collegeId);

	/**
	 * 通过姓名模糊搜索
	 * @param name
	 * @return
	 */
	List<Student> findByNameLike(String name);


	/**
	 * 多条件分页获取学生
	 *
	 * @param student
	 * @param searchVo
	 * @param pageable
	 * @return
	 */
	Page<Student> findByCondition(Student student, SearchVo searchVo, Pageable pageable);
}