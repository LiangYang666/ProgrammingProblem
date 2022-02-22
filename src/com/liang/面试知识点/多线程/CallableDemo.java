package com.liang.面试知识点.多线程;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @ProjectName: ProgrammingProblem
 * @Package: com.liang.面试知识点.多线程
 * @ClassName: CallableDemo
 * @Description:
 * @Author: Yang Liang
 * @CreateDate: 2022/2/15 15:46
 * @Version: 1.0
 */

class CallableDemo implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        return 2;
    }

    public static void main(String[] args) {
        FutureTask<Integer> task = new FutureTask<>(new CallableDemo());
        Thread t = new Thread(task, "AA");
        t.start();
        try {
            System.out.println(task.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}


