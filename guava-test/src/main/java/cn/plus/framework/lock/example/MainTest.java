package cn.plus.framework.lock.example;

import org.quartz.impl.jdbcjobstore.SimpleSemaphore;

/**
 * @author plus me
 * @date 2018/7/2
 */

class Demo1 extends Thread {
    SimpleSemaphore s = null;

    public Demo1(SimpleSemaphore s) {
        this.s = s;
    }

    @Override
    public void run() {
        s.obtainLock(null, "wwx");
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.err.println("laji");
        s.releaseLock("wwx");
    }
}

class Demo2 extends Thread {
    SimpleSemaphore s = null;
    public Demo2(SimpleSemaphore s) {
        this.s = s;
    }
    @Override
    public void run() {
        s.obtainLock(null, "wwx");
        System.err.println("laji");
    }
}

public class MainTest {
    public static void main(String args[]) throws InterruptedException {
        SimpleSemaphore s = new SimpleSemaphore();
        new Demo1(s).start();
        Thread.sleep(3000);
        new Demo2(s).start();
    }
}
