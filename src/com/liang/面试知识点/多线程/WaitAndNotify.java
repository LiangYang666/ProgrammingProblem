package com.liang.面试知识点.多线程;

/**
 * @ProjectName: ProgrammingProblem
 * @Package: com.liang.面试知识点.多线程
 * @ClassName: WaitAndNotify
 * @Description:
 * @Author: Yang Liang
 * @CreateDate: 2022/4/13 19:48
 * @Version: 1.0
 */
public class WaitAndNotify {
    /**
     * 奇偶数依次输出
     */

    public static final Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            synchronized (lock) {
                for (int i = 1; i <= 100; i += 2) {
                    lock.notify();
                    System.out.println("奇数：" + i);
                    //大于100后不再wait
                    if (i < 100) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
        Thread t2 = new Thread(() -> {
            synchronized (lock) {
                for (int i = 2; i <= 100; i += 2) {
                    lock.notify();
                    System.out.println("偶数：" + i);
                    //等于100后不再wait了
                    if (i == 100) {
                        break;
                    }
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        t1.start();
        Thread.sleep(1000L);
        t2.start();
    }

}
