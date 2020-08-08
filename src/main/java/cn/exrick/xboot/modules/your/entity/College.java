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
@Table(name = "s_college")
@TableName("s_college")
@ApiModel(value = "学院类")
public class College extends XbootBaseEntity {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "学院名")
	@Column(unique = true, nullable = false)
	private String name;
}