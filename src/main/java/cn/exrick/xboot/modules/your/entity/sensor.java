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
@Table(name = "t_sensor")
@TableName("t_sensor")
@ApiModel(value = "传感器信息")
public class sensor extends XbootBaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "传感器名称")
    private String name;

    @ApiModelProperty(value = "传感器类型")
    @Column(nullable = false)
    private Integer type;

    @ApiModelProperty(value = "监测项")
    @Column(nullable = false)
    private String label;

    @ApiModelProperty(value = "检测值")
    @Column(nullable = false)
    private String value;

    @ApiModelProperty(value = "监测单位")
    private String unit;

    @ApiModelProperty(value = "外部构件标志  默认0")
    @Column(nullable = false)
    private Integer is_external = 0;

    @ApiModelProperty(value = "传感器坐标x")
    private String px;

    @ApiModelProperty(value = "传感器坐标y")
    private String py;

    @ApiModelProperty(value = "传感器坐标z")
    private String pz;

}