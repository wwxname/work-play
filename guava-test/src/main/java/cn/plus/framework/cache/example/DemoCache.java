package cn.plus.framework.cache.example;

import cn.plus.framework.cache.BaseCache;

/**
 * @author plus me
 * @date 2018/6/13
 */
public class DemoCache extends BaseCache {
    @Override
    protected Object loadData(String key) {
        Object o = loadDataFromDisk(key);
        this.put(key, o);
        return o;
    }

    /**
     * 定义数据的真实来自哪里
     * @param key
     * @return
     */
    private Object loadDataFromDisk(String key) {
        return new Object();
    }
}
