package com.liang.面试知识点.jvm;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/**
 * @ProjectName: ProgrammingProblem
 * @Package: com.liang.面试知识点.jvm
 * @ClassName: ReferenceDemo
 * @Description:
 * @Author: Yang Liang
 * @CreateDate: 2022/2/16 0:18
 * @Version: 1.0
 */
public class ReferenceDemo {
    public static void main(String[] args) {

        SoftReference<Integer> softReference = new SoftReference<Integer>(new Integer(2));
        WeakReference<Integer> weakReference = new WeakReference<>(new Integer(3));

        System.out.println(softReference.get());
        System.out.println(weakReference.get());
        System.gc();

        System.out.println(softReference.get());
        System.out.println(weakReference.get());


    }
}
