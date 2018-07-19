package cn.plus.framework.quartz2.spring.redis;

import redis.clients.jedis.Jedis;

/**
 * @author plus me
 * @date 2018/6/28
 */
public class RedisTest {

    private static Jedis jedis;


    static {
        //连接redis服务器(在这里是连接本地的)
        jedis = new Jedis("127.0.0.1", 6379);
        //权限认证
        //jedis.auth("chenhaoxiang");
        System.out.println("连接服务成功");
    }

    public static void main(String args[]) {
        Long db = jedis.getDB();
        jedis.set("user","name:wwx");


    }
}
