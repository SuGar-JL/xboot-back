package cn.exrick.xboot.modules.your.entity;

import cn.exrick.xboot.base.XbootBaseEntity;
import cn.exrick.xboot.common.constant.CommonConstant;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * @author SuGar
 */
@Data
@Entity
@Table(name = "s_student")
@TableName("s_student")
@ApiModel(value = "学生类")
public class Student extends XbootBaseEntity {

	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "姓名")
	@Column(nullable = false)
	private String name;

	@ApiModelProperty(value = "性别")
	@Column(nullable = false)
	private String sex;

	@ApiModelProperty(value = "生日")
	@Column(nullable = false)
	private String birthday;

	@ApiModelProperty(value = "头像")
	@Column(length = 1000)
	private String avatar = CommonConstant.USER_DEFAULT_AVATAR;

	@ApiModelProperty(value = "学院名称")
	@Column(nullable = false)
	private String collegeName;

	@ApiModelProperty(value = "年级名称")
	@Column(nullable = false)
	private String gradeName;
}