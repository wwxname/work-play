import cn.plus.framework.cache.BaseCache;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author plus me
 * @date 2018/6/13
 */
class DemoCache extends BaseCache{
    public DemoCache(long duration, TimeUnit timeUtil) {
        super(duration, timeUtil);
    }

    @Override
    protected Object loadData(String s) {
        if("2".equals(s)){

            return "wwj";
        }
        this.put("1","laji");
        return "AbstractHttpService";
    }
}
public class Test1 {

    public static  void  main(String args[]) throws InterruptedException {
        DemoCache demoCache = new DemoCache(1l, TimeUnit.SECONDS);
demoCache.loadData("");
        Object o = demoCache.getCache("2");
        demoCache.getCache("1");
       Thread.sleep(2000);


        System.err.println(o);
        System.err.println(demoCache.getCache("1").toString());
    }
}
