package cn.exrick.xboot.modules.your.entity;

import cn.exrick.xboot.base.XbootBaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author SuGar
 */
@Data
@Entity
@Table(name = "t_sensor_component")
@TableName("t_sensor_component")
@ApiModel(value = "传感器外部构件")
public class sensor_component extends XbootBaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "传感器id")
    private String sensor_id;

    @ApiModelProperty(value = "构件id")
    private String component_id;


}