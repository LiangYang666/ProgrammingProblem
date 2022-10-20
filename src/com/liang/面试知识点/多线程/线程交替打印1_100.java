package com.liang.面试知识点.多线程;

/**
 * @ProjectName: ProgrammingProblem
 * @Package: com.liang.面试知识点.多线程
 * @ClassName: 线程交替打印1_100
 * @Description:
 * @Author: Yang Liang
 * @CreateDate: 2022/10/12 9:35
 * @Version: 1.0
 */
public class 线程交替打印1_100 {
    public static void main(String[] args) {
        RunnableT r = new RunnableT();
        new Thread(r, "A").start();
        new Thread(r, "B").start();

    }
}
class RunnableT implements Runnable{
    private int i = 1;
    @Override
    public void run() {
        while (true){
            synchronized (this){
                this.notify();  // 调用notify唤醒阻塞的线程
                if (i<=100){
                    System.out.println(Thread.currentThread().getName()+" "+i);
                    i++;
                    try {
                        this.wait();    // 阻塞当前线程，并释放锁
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    break;
                }
            }
        }
    }
}