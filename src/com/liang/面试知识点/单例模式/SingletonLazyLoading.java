package com.liang.面试知识点.单例模式;

/**
 * @ProjectName: ProgrammingProblem
 * @Package: com.liang.面试知识点.单例模式
 * @ClassName: SingletonDemo
 * @Description:
 * @Author: Yang Liang
 * @CreateDate: 2022/1/30 10:55
 * @Version: 1.0
 */
public class SingletonLazyLoading {
    // 懒汉式 线程不安全
    private static SingletonLazyLoading singletonLazyLoading;
    public static SingletonLazyLoading getInstance(){
        if (singletonLazyLoading==null){
            singletonLazyLoading = new SingletonLazyLoading();
        }
        return singletonLazyLoading;
    }
}
