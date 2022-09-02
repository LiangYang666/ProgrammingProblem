package com.liang.面试知识点.jvm.类文件结构;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Description: TODO
 * @Author: LiangYang
 * @Date: 2022/4/16 上午11:23
 **/
public class TestClass {
    private int m;
    private int[] a;
    private String[][] b;
    public int inc(String a){
        return m+1;
    }
    public int inc(int a){
        return m+a;
    }

    public static void main(String[] args) throws RuntimeException {
        TestClass testClass = new TestClass();
        Class<?> aClass;
        int inc = testClass.inc(1);
        try {
            aClass = Class.forName("com.liang.面试知识点.jvm.类文件结构.MyTestA");
            Object obj = aClass.newInstance();
            Field a1 = aClass.getDeclaredField("a");
            a1.setAccessible(true);
            System.out.println("获取到private的变量值  "+a1.get(obj));
            Method methodPrint = aClass.getMethod("print", null);
            methodPrint.invoke(obj, null);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException |
                 NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
    }
}

