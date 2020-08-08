package cn.exrick.xboot.base;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.io.Serializable;
import java.util.List;


/**
 * @author Exrickx
 * 该类提供对整张表进行操作的接口
 */
// JDK8函数式接口注解 仅能包含一个抽象方法
@FunctionalInterface
public interface XbootBaseService<E, ID extends Serializable> {

    /*来自于XbootBaseDao<E, ID>import的org.springframework.data.jpa.repository.JpaRepository;
    这其实应该是一个XbootBaseDao<E, ID>的对象，不是方法
    */
    public XbootBaseDao<E, ID> getRepository();

    /**
     * 根据ID获取
     * @param id
     * @return
     */
    public default E get(ID id) {  //public与default时同等级的吧？？？
        /*
        orElse(参数)：当optional值不存在时，调用orElse()返回orElse()的参数，如果optional的值存在时返回optional的值
        */
        return getRepository().findById(id).orElse(null);
    }

    /**
     * 获取所有列表
     * @return
     */
    public default List<E> getAll() {
        return getRepository().findAll();
    }

    /**
     * 获取总数
     * @return
     */
    public default Long getTotalCount() {
        return getRepository().count();
    }

    /**
     * 保存
     * @param entity
     * @return
     */
    public default E save(E entity) {

        return getRepository().save(entity);
    }

    /**
     * 修改
     * @param entity
     * @return
     */
    public default E update(E entity) {
        return getRepository().saveAndFlush(entity);
    }

    /**
     * 批量保存与修改
     * @param entities
     * @return
     */
    public default Iterable<E> saveOrUpdateAll(Iterable<E> entities) { //Iterable返回一个Iterator(迭代器)对象
        return getRepository().saveAll(entities);
    }

    /**
     * 删除
     * @param entity
     */
    public default void delete(E entity) {
        getRepository().delete(entity);
    }

    /**
     * 根据Id删除
     * @param id
     */
    public default void delete(ID id) {
        getRepository().deleteById(id);
    }

    /**
     * 批量删除
     * @param entities
     */
    public default void delete(Iterable<E> entities) {
        getRepository().deleteAll(entities);
    }

    /**
     * 清空缓存，提交持久化
     */
    public default void flush() {
        getRepository().flush();
    }

    /**
     * 根据条件查询获取
     * @param spec
     * @return
     */
    public default List<E> findAll(Specification<E> spec) {
        return getRepository().findAll(spec);
    }

    /**
     * 分页获取
     * @param pageable
     * @return
     */
    public default Page<E> findAll(Pageable pageable){
        return getRepository().findAll(pageable);
    }

    /**
     * 根据查询条件分页获取
     * @param spec
     * @param pageable
     * @return
     */
    public default Page<E> findAll(Specification<E> spec, Pageable pageable) {
        return getRepository().findAll(spec, pageable);
    }

    /**
     * 获取查询条件的结果数
     * @param spec
     * @return
     */
    public default long count(Specification<E> spec) {
        return getRepository().count(spec);
    }
}
