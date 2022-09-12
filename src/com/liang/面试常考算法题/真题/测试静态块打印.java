package com.liang.面试常考算法题.真题;

/**
 * @ProjectName: ProgrammingProblem
 * @Package: com.liang.面试常考算法题.真题
 * @ClassName: 测试打印
 * @Description:
 * @Author: Yang Liang
 * @CreateDate: 2022/9/2 21:29
 * @Version: 1.0
 */
public class 测试静态块打印 {
    public static void main(String[] args) {
        Student hh = new Student(1, "hh");
    }
}
class User{
    private String name;
    private int age;
    static {
        System.out.println("A静态代码块");
    }
    {
        System.out.println("B构造代码块");
    }
    User(){
        System.out.println("C无参构造");
    }
    User(int age, String name){
        this.name = name;
        this.age = age;
        System.out.println("D有参构造");
    }
}

class Student extends User{
    static {
        System.out.println("a静态代码块");
    }
    {
        System.out.println("b构造代码块");
    }
    Student(){
        System.out.println("c无参构造");
    }
    Student(int age, String name){
        super(age, name);
        System.out.println("d有参构造");
    }

}

