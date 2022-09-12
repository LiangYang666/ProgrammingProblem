package com.liang.面试知识点.多线程;


/**
 * @ProjectName: ProgrammingProblem
 * @Package: com.liang.面试知识点.多线程
 * @ClassName: RunnableDemo
 * @Description:
 * @Author: Yang Liang
 * @CreateDate: 2022/1/21 12:56
 * @Version: 1.0
 */
public class ThreadSingleRunnableDemo implements Runnable {
    private String threadName;

    public ThreadSingleRunnableDemo(String threadName) {
        this.threadName = threadName;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println(this.threadName+"\t:run"+i+"次");
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        ThreadSingleRunnableDemo runnableDemo1 = new ThreadSingleRunnableDemo("run-1");
        Thread thread1 = new Thread(runnableDemo1, "th-1");

        ThreadSingleRunnableDemo runnableDemo2 = new ThreadSingleRunnableDemo("run-2");
        Thread thread2 = new Thread(runnableDemo2, "th-2");

        thread1.start();
        thread2.start();
    }
}
