package com.liang.面试知识点.多线程;

/**
 * @ProjectName: ProgrammingProblem
 * @Package: com.liang.面试知识点.多线程
 * @ClassName: WaitSleepDemo
 * @Description:
 * @Author: Yang Liang
 * @CreateDate: 2022/1/28 18:52
 * @Version: 1.0
 */
public class WaitSleepDemo {
    public Object lock = new Object();
    public void run(){
        synchronized (lock){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
