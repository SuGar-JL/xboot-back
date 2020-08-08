package cn.exrick.xboot.base;

import cn.exrick.xboot.common.constant.CommonConstant;
import cn.exrick.xboot.common.utils.SnowFlakeUtil;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Exrickx
 */
@Data //来自于lombok.Data，使用此注解则可以不用给实体类写set()、get()方法
@MappedSuperclass //在其他实体类中有相同属性在此。。。
@EntityListeners(AuditingEntityListener.class)//对实体属性变化的跟踪，它提供了保存前，保存后，更新前，更新后，删除前，删除后等状态，就像是拦截器一样，你可以在拦截方法里重写你的个性化逻辑。
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler","fieldHandler"})//标记不需要转化为json的属性
public abstract class XbootBaseEntity implements Serializable{

    private static final long serialVersionUID = 1L;//序列化时为了保持版本的兼容性，即在版本升级时反序列化仍保持对象的唯一性。

    @Id //标记为主键
    @TableId //表示表的主键
    @ApiModelProperty(value = "唯一标识")
    private String id = String.valueOf(SnowFlakeUtil.getFlowIdInstance().nextId());

    @ApiModelProperty(value = "创建者")
    @CreatedBy // 表示该字段为创建人，在这个实体被insert的时候，会设置值
    private String createBy;

    @CreatedDate //表示该字段为创建时间时间字段，在这个实体被insert的时候，会设置值
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "更新者")
    @LastModifiedBy //表示该字段最后的修改者，在这个实体被update的时候，会设置值
    private String updateBy;

    @LastModifiedDate//表示该字段最后修改的时间字段，在这个实体被update的时候，会设置值
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    @ApiModelProperty(value = "删除标志 默认0")
    private Integer delFlag = CommonConstant.STATUS_NORMAL;
}
