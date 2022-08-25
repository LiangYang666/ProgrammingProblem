package com.liang.面试知识点.多线程;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ProjectName: ProgrammingProblem
 * @Package: com.liang.面试知识点.多线程
 * @ClassName: ReentrantLockConditionDemo
 * @Description:
 * @Author: Yang Liang
 * @CreateDate: 2022/8/23 11:34
 * @Version: 1.0
 */
public class ReentrantLockConditionDemo {
    public static void main(String[] args) throws InterruptedException {
        Task t = new Task();
        Thread t1 = new Thread(t,"A");
        Thread t2 = new Thread(t,"B");
        t1.start();
        t2.start();
    }
}

class Task implements Runnable{
    private int number = 0;
    private ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    @Override
    public void run(){
        while(number<100){
            lock.lock();
            number++;
            System.out.println(number);
            condition.signal();
            try{
                if(number<100)
                    condition.await();
            }catch (InterruptedException e) {
                e.printStackTrace();
            }finally{
                lock.unlock();
            }
        }
    }
}
