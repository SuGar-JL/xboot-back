package cn.exrick.xboot.common.lock;

import java.util.concurrent.TimeUnit;

/**
 * 分布式可重入锁
 * @author sunyujia@aliyun.com https://github.com/yujiasun/Distributed-Kit
 * @date 2016/2/26
 */
public interface DistributedReentrantLock {

    public boolean tryLock(long timeout, TimeUnit unit) throws InterruptedException;

    public void unlock();
}
