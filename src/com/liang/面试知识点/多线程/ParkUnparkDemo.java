package com.liang.面试知识点.多线程;

import java.util.concurrent.locks.LockSupport;

public class ParkUnparkDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            System.out.println("start...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("park...");
            LockSupport.park();
            System.out.println("resume...");
        }, "t1");
        t1.start();

        Thread.sleep(200);     // 改成200和2000都能够执行（代表park类似于信号量，unpark可以在前）
        System.out.println("unpark...");
        LockSupport.unpark(t1); // 指定恢复t1
    }
}

