package com.liang.面试知识点.单例模式;

/**
 * @ProjectName: ProgrammingProblem
 * @Package: com.liang.面试知识点.单例模式
 * @ClassName: SingletonEagerLoading
 * @Description:
 * @Author: Yang Liang
 * @CreateDate: 2022/1/30 11:01
 * @Version: 1.0
 */
public class SingletonEagerLoading {
    private static SingletonEagerLoading singletonEagerLoading=new SingletonEagerLoading();
    public static SingletonEagerLoading getInstance(){
        return singletonEagerLoading;
    }
}
