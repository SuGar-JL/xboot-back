package cn.exrick.xboot.modules.activiti.entity.business;

import cn.exrick.xboot.base.XbootBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Date;
/**
 * @author Exrick
 */
@Data
@Entity //表明该类为一个实体类，t_leave。
@Table(name = "t_leave") //当实体类与其映射的数据库表名不同名时需要使用 @Table注解说明，该标注与 @Entity 注解并列使用
@TableName("t_leave") //mybatis-plus中的注解
@ApiModel(value = "请假申请") //描述返回对象的意义 value值为模型提供备用名称
public class Leave extends XbootBaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "请假类型") //对象属性
    private String type;

    @ApiModelProperty(value = "标题")
    private String title;

    @ApiModelProperty(value = "说明")
    private String description;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm") //从后台到前台时间格式转换，设置时区为上海时区，时间格式自己据需求定。
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")//从前台到后台时间格式转换
    @ApiModelProperty(value = "开始日期")
    private Date startDate;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    @ApiModelProperty(value = "截止日期")
    private Date endDate;

    @ApiModelProperty(value = "请假时长（小时）")
    private Integer duration;
}