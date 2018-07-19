package cn.plus.framework.lock;

import cn.plus.framework.excetion.PlusLockException;


import java.sql.Connection;

/**
 * @author plus me
 * @date 2018/7/2
 */
public interface Semaphore {
    /**
     * 获得锁
     * @param conn
     * @param lockName
     * @return
     * @throws PlusLockException
     */
    boolean obtainLock(Connection conn, String lockName) throws PlusLockException;

    /**
     * release lock
     * @param lockName
     * @throws PlusLockException
     */
    void releaseLock(String lockName) throws PlusLockException;

    /**
     * requires
     * @return
     */
    boolean requiresConnection();
}
