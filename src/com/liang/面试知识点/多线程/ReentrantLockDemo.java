package com.liang.面试知识点.多线程;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @ProjectName: ProgrammingProblem
 * @Package: com.liang.面试知识点.多线程
 * @ClassName: ReentrantLockDemo
 * @Description:
 * @Author: Yang Liang
 * @CreateDate: 2022/8/23 10:00
 * @Version: 1.0
 */
public class ReentrantLockDemo {

    public static void test2() throws InterruptedException {
        ReentrantLock lock = new ReentrantLock();
        Thread t1 = new Thread(() -> {
            System.out.println("启动...");
            try {
                lock.lockInterruptibly();
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("等锁的过程中被打断");
                return;
            }
            try {
                System.out.println("获得了锁");
            } finally {
                lock.unlock();
            }
        }, "t1");
        System.out.println("获得了锁");
        lock.lock();
        t1.start();
        try {
            Thread.sleep(1000);
            t1.interrupt();     // 可测试注释该行 不打断并释放锁
            System.out.println("执行打断");
        } finally {
            lock.unlock();
        }
        Thread.sleep(1000);
    }

    public static void test3(){
        ReentrantLock lock = new ReentrantLock();
        Thread t1 = new Thread(() -> {
            System.out.println("启动...");
            lock.lock();
            try {
                System.out.println("获得了锁");
            } finally {
                lock.unlock();
            }
        }, "t1");
        lock.lock();
        System.out.println("获得了锁");
        t1.start();
        try {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            t1.interrupt();
            System.out.println("执行打断");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } finally {
            System.out.println("释放了锁");
            lock.unlock();
        }
    }
    public static void test4() throws InterruptedException {
        ReentrantLock lock = new ReentrantLock(false);  // 默认非公平，可初始化为公平
        lock.lock();
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                lock.lock();
                try {
                    System.out.println(Thread.currentThread().getName() + " running...");
                } finally {
                    lock.unlock();
                }
            }, "t" + i).start();
        }
        // 争抢锁
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " start...");
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + " running...");
            } finally {
                lock.unlock();
            }
        }, "强行插入").start();
        lock.unlock();
    }
    public static void test5(){

    }
    public static void main(String[] args) throws InterruptedException {
//        test2();    //可被中断演示
//        test3();    // 不可被打断 其实interrupt只是个信号，处不处理看程序员
        test4();    // 默认非公平，可初始化为公平
    }
}
