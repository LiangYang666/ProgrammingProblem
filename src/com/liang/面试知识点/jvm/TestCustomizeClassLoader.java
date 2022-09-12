package com.liang.面试知识点.jvm;

/**
 * @ProjectName: ProgrammingProblem
 * @Package: com.liang.面试知识点.jvm
 * @ClassName: TestCustomizeClassLoader
 * @Description:
 * @Author: Yang Liang
 * @CreateDate: 2022/8/31 13:27
 * @Version: 1.0
 */
import sun.misc.PerfCounter;

import java.io.FileInputStream;
import java.lang.reflect.Method;

public class TestCustomizeClassLoader {
    static class CustomizeClassLoader extends ClassLoader {
        private String classPath;

        public CustomizeClassLoader(String classPath) {
            this.classPath = classPath;
        }

        // 读取class字节码文件
        private byte[] loadByte(String name) throws Exception {
            name = name.replaceAll("\\.", "/");
            FileInputStream fis = new FileInputStream(classPath + "/" + name + ".class");
            int len = fis.available();
            byte[] data = new byte[len];
            fis.read(data);
            fis.close();
            return data;
        }

        @Override
        protected Class<?> findClass(String name) throws ClassNotFoundException {
            try {
                byte[] data = loadByte(name);
                return defineClass(name, data, 0, data.length);
            } catch (Exception e) {
                e.printStackTrace();
                throw new ClassNotFoundException();
            }
        }

        @Override
        protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
            synchronized (getClassLoadingLock(name)) {
                Class<?> c = findLoadedClass(name);
                if (c == null) {
                    long t1 = System.nanoTime();
                    if (name.startsWith("com.liang")) {
                        c = findClass(name);
                    } else {
                        c = this.getParent().loadClass(name);
                    }
                    PerfCounter.getFindClassTime().addElapsedTimeFrom(t1);
                    PerfCounter.getFindClasses().increment();
                }
                if (resolve) {
                    resolveClass(c);
                }
                return c;
            }
        }

    }

    public static void main(String args[]) throws Exception {
        CustomizeClassLoader classLoader1 = new CustomizeClassLoader("D:\\Seafile\\LiangDrive\\Code\\Java\\Code\\ProgrammingProblem\\src");
        System.out.println("自定义类加载器的父加载器：" + classLoader1.getParent().getClass().getName());
        Class clazz1 = classLoader1.loadClass("com.liang.面试知识点.jvm.类文件结构.MyTestA");
        Object obj1 = clazz1.newInstance();
        Method method1 = clazz1.getDeclaredMethod("print", null);
        method1.invoke(obj1, null);
        System.out.println("MyTestA类的类加载器是：" + clazz1.getClassLoader().getClass().getName());

        System.out.println("====================================================================");

//        CustomizeClassLoader classLoader2 = new CustomizeClassLoader("D:/MyClasses-v2");
//        System.out.println("自定义类加载器的父加载器：" + classLoader2.getParent().getClass().getName());
//        Class clazz2 = classLoader2.loadClass("com.liang.面试知识点.jvm.类文件结构.MyTestA");
//        Object obj2 = clazz2.newInstance();
//        Method method2 = clazz2.getDeclaredMethod("print", null);
//        method2.invoke(obj2, null);
//        System.out.println("Note类的类加载器是：" + clazz2.getClassLoader().getClass().getName());
    }
}