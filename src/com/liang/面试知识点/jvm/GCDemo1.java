package com.liang.面试知识点.jvm;

import com.liang.面试知识点.基本数据类型和String.BasicAndString;

import java.lang.reflect.Field;

/**
 * @ProjectName: ProgrammingProblem
 * @Package: com.liang.面试知识点.jvm
 * @ClassName: GCDemo1
 * @Description:
 * @Author: Yang Liang
 * @CreateDate: 2022/2/1 23:05
 * @Version: 1.0
 */
public class GCDemo1 {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
//        byte[] allocation1, allocation2;
//        allocation1 = new byte[29000*1024];
        ClassLoader classLoader = BasicAndString.class.getClassLoader();
        System.out.println(classLoader.toString());
        PrivateTestDemo privateTestDemo = new PrivateTestDemo();
        Field[] fields = privateTestDemo.getClass().getDeclaredFields();
        Field a = privateTestDemo.getClass().getDeclaredField("a");
        a.setAccessible(true);
        Object o =  a.get(privateTestDemo);
        System.out.println(o);
        a.set(privateTestDemo, 2);
        o =  a.get(privateTestDemo);
        System.out.println(o);
        System.out.println(o.getClass());
        for (Field field :
                fields) {
            System.out.println(field.toString());
        }

    }
}
