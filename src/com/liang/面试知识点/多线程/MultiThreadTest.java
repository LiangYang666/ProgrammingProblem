package com.liang.面试知识点.多线程;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ProjectName: ProgrammingProblem
 * @Package: com.liang.面试知识点.多线程
 * @ClassName: MultiThreadTest
 * @Description: 原子性测试
 * @Author: Yang Liang
 * @CreateDate: 2022/1/27 14:34
 * @Version: 1.0
 */
public class MultiThreadTest {
    public int a = 0;
    public void increase(){
        a++;
    }
    public static void main(String[] args) throws InterruptedException {
        MultiThreadTest test = new MultiThreadTest();
        ArrayList<Thread> threads = new ArrayList<>();

        Lock lock = new ReentrantLock();
        for (int i = 0; i < 30; i++) {
            Thread thread = new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
//                    lock.lock();
                    test.increase();
//                    lock.unlock();
                }
            });
            threads.add(thread);
            thread.start();
        }
        lock.lock();
        Thread[] threads1 = new Thread[Thread.activeCount()];
        Thread.currentThread().getThreadGroup().enumerate(threads1);
        for (Thread thread :
                threads1) {
            System.out.println(thread.getName());
        }
        lock.unlock();
        for (Thread thread :
                threads) {
            thread.join();
        }
        System.out.println(Thread.activeCount());
        System.out.println(test.a);

    }
}
class ThreadDemo02{
//    public int[] a = {0,0,0};
    public volatile int[] a = {0,0,0};
    public static void main(String[] args) {
        ThreadDemo02 test = new ThreadDemo02();
        Thread threadA = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                test.a[0] = i;
                System.out.println("a:" + test.a[0]);
            }
        });
        Thread threadB = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                test.a[1] = test.a[0];
                System.out.println("-b:" + test.a[1]);
            }
        });
        threadA.start();
        threadB.start();

        System.out.println(Arrays.toString(test.a));
    }

}
