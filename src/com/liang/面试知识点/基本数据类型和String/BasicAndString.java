package com.liang.面试知识点.基本数据类型和String;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.Timer;

/**
 * @ProjectName: ProgrammingProblem
 * @Package: com.liang.面试知识点.基本数据类型和String
 * @ClassName: BasicAndString
 * @Description:
 * @Author: Yang Liang
 * @CreateDate: 2022/1/27 22:33
 * @Version: 1.0
 */
public class BasicAndString{
    public int a = 1;

    public BasicAndString(int a) {
        this.a = a;
    }

    public static void main(String[] args) throws InterruptedException {
//        Integer a = 40;
//        Integer b = 100;
//        Integer c = 140;
//        Integer d = new Integer(140);
//
//        System.out.println((a+b)==c);
//        System.out.println((a+b)==d);
//        System.out.println(140==c);
//        System.out.println(140==d);
//        System.out.println(d==c);
//        B basicAndString = new B();
//        System.out.println(basicAndString.a);
//        EquA equA = new EquA(2);
//        Thread.sleep(1000);
//        EquA equA1 = new EquA(2);
//        Thread.sleep(1000);
//        System.out.println(equA1.equals(equA));
        String s = new String("1");
        s = s.intern();
        String s1 = "1";
        System.out.println(s1==s);
        String s3 = new String("1") + new String("1");
        String s4 = "11";
        System.out.println(s3==s4);
    }
}
class B extends BasicAndString{
    public int b=2;

    public B() {
        super(1);
    }

    public B(int a, int b) {
        super(a);
        this.b = b;
    }
}
interface A{
    public static final int a=2;
}

class EquA{
    int a;

    public EquA(int a) {
        this.a = a;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EquA equA = (EquA) o;
        return a == equA.a;
    }

    @Override
    public int hashCode() {
        Date date = new Date();
        long time = date.getTime();
        return (int)time;
//        return Integer.hashCode(a);
    }
}
