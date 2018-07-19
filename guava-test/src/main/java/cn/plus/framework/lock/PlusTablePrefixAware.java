package cn.plus.framework.lock;

/**
 * @author plus me
 * @date 2018/7/2
 */
public interface PlusTablePrefixAware {
    /**
     * 锁 表的前缀
     * @param tablePrefix
     */
    void setTablePrefix(String tablePrefix);

    /**
     *锁表的key值
     * @param keyName
     */
    void setKeyName(String keyName);
}
