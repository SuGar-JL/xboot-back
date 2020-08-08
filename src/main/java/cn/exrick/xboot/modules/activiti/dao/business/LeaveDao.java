package cn.exrick.xboot.modules.activiti.dao.business;

import cn.exrick.xboot.base.XbootBaseDao;
import cn.exrick.xboot.modules.activiti.entity.business.Leave;

/**
 * 请假数据处理层
 * @author Exrick
 */
//把Leave实体类放入XbootBaseDao，会在数据库里自动建表。
public interface LeaveDao extends XbootBaseDao<Leave,String> {

}