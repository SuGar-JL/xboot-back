package cn.exrick.xboot.modules.your.entity;

import cn.exrick.xboot.base.XbootBaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author SuGar
 */
@Data
@Entity
@Table(name = "s_grade")
@TableName("s_grade")
@ApiModel(value = "年级类")
public class Grade extends XbootBaseEntity {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "年级名")
	@Column(unique = true, nullable = false)
	private String name;
}