package com.liang.面试知识点.jvm.类文件结构;

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

    public static void main(String[] args) {
        TestClass testClass = new TestClass();
        Class<?> aClass;
        int inc = testClass.inc(1);
        try {
            aClass = Class.forName("com.liang.面试知识点.jvm.类文件结构.MyTestA");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
class MyTestA{
    private int a;
    public Integer b;
}
