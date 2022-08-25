package com.liang.面试知识点.多线程;

import java.util.concurrent.*;

/**
 * @ProjectName: ProgrammingProblem
 * @Package: com.liang.面试知识点.多线程
 * @ClassName: ThreadPoolDemo
 * @Description:
 * @Author: Yang Liang
 * @CreateDate: 2022/2/15 16:42
 * @Version: 1.0
 */
public class ThreadPoolDemo {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);
//      ExecutorService executor =  new ThreadPoolExecutor(5, 5, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());
//        new ThreadPoolExecutor()
        for (int i = 0; i < 10; i++) {
            executor.execute(()->{
                System.out.println("thread id is: " + Thread.currentThread().getId());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

    }
}
