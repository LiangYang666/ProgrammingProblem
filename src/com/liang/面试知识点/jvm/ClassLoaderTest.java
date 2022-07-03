package com.liang.面试知识点.jvm;

/**
 * @Description: TODO
 * @Author: LiangYang
 * @Date: 2022/4/25 下午6:20
 **/
public class ClassLoaderTest {
    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader myLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                return super.loadClass(name);
            }
        };
        Class<?> aClass = myLoader.loadClass("com.liang.面试知识点.jvm.类文件结构.MyTestA");
    }
}
