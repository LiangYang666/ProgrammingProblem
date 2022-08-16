package com.liang.面试知识点.多线程;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @ProjectName: ProgrammingProblem
 * @Package: com.liang.面试知识点.多线程
 * @ClassName: ThreadPoolCallable
 * @Description:
 * @Author: Yang Liang
 * @CreateDate: 2022/8/16 22:24
 * @Version: 1.0
 */
public class ThreadPoolCallable {
    public static void main(String[] args) {
        System.out.println("start...");
        long begin = System.currentTimeMillis();
        ExecutorService pool = null;
        try {
            int taskSize = 5;
            // 创建一个线程池
            pool = Executors.newFixedThreadPool(taskSize);
            // 创建多个返回值的任务
            List<Future> list = new ArrayList<>();
            for (int i = 1; i <= taskSize; i++) {
                CallableDemo callable = new CallableDemo(new Integer(i));
                Future<Integer> future = pool.submit(callable);
                list.add(future);
                System.out.println("已添加" + i);
            }
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i).get().toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 关闭线程池
        pool.shutdown();
        long end = System.currentTimeMillis();
        System.out.println("end..excute time：" + (end - begin) / 1000 + "s");
        return;

    }
}
