package com.liang.面试知识点.基本数据类型和String;

/**
 * @ProjectName: ProgrammingProblem
 * @Package: com.liang.面试知识点.基本数据类型和String
 * @ClassName: BasicAndString
 * @Description:
 * @Author: Yang Liang
 * @CreateDate: 2022/1/27 22:33
 * @Version: 1.0
 */
public class BasicAndString {
    public static void main(String[] args) {
        Integer a = 40;
        Integer b = 100;
        Integer c = 140;
        Integer d = new Integer(140);

        System.out.println((a+b)==c);
        System.out.println((a+b)==d);
        System.out.println(140==c);
        System.out.println(140==d);
        System.out.println(d==c);

    }
}
