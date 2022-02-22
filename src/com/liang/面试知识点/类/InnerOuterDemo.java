package com.liang.面试知识点.类;

public class InnerOuterDemo {
    public static void main(String[] args) {
        Outer.Inner inner = new Outer().new Inner();
        inner.print();
    }
}
class Outer{
    private int age = 20;

    class Inner{
        void print(){
            System.out.println(age);
        }
    }
    static class StaticInner{
        void staticPrint(){
            System.out.println();
        }
    }
}
