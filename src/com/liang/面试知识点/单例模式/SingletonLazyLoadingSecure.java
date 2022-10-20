package com.liang.面试知识点.单例模式;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @ProjectName: ProgrammingProblem
 * @Package: com.liang.面试知识点.单例模式
 * @ClassName: SingletonLazyLoadingSecure
 * @Description:
 * @Author: Yang Liang
 * @CreateDate: 2022/2/15 10:26
 * @Version: 1.0
 */
public class SingletonLazyLoadingSecure {
    private static volatile SingletonLazyLoadingSecure instance;
    public static SingletonLazyLoadingSecure getInstance(){
        if (instance==null){
            synchronized (SingletonLazyLoadingSecure.class){
                if (instance==null){
                    instance = new SingletonLazyLoadingSecure();
                }
            }
        }
        return instance;
    }
}
