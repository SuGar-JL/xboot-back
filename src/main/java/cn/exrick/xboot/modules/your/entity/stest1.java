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
@Table(name = "s_stest1")
@TableName("s_stest1")
@ApiModel(value = "测试")
public class stest1 extends XbootBaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "传感器id")
    private String sensor_id;

    @ApiModelProperty(value = "监测值")
    private Float value;

}