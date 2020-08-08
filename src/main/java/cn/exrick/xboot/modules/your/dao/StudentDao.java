package cn.exrick.xboot.modules.your.dao;

import cn.exrick.xboot.base.XbootBaseDao;
import cn.exrick.xboot.modules.base.entity.User;
import cn.exrick.xboot.modules.your.entity.Student;

import java.util.List;

/**
 * 学生类数据处理层
 * @author SuGar
 */
public interface StudentDao extends XbootBaseDao<Student,String> {

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

}