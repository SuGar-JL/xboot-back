package cn.exrick.xboot.base;


import org.springframework.data.jpa.repository.JpaRepository; //用于访问数据库，可对数据库进行操作，不用事先在数据库建表。Repository：资料库
import org.springframework.data.jpa.repository.JpaSpecificationExecutor; //规范执行器
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable; //序列化

/**
 * @author Exrickx
 */
// 自定义接口 不会创建接口的实例 必须加此注解
@NoRepositoryBean //为了告诉JPA（Java Persistence API的简称，中文名Java持久层API）不要创建对应接口的bean对象 就在类上加注解@NoRepositoryBean
/**
 * 参数E 表示实体
 */
/*
* JpaRepository; //用于访问数据库，可对数据库进行操作，不用事先在数据库建表。Repository：资料库
* JpaSpecificationExecutor; //规范执行器*/
public interface XbootBaseDao<E, ID extends Serializable> extends JpaRepository<E, ID>, JpaSpecificationExecutor<E> {

}
