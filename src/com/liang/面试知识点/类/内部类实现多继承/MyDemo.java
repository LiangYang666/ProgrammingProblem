package com.liang.面试知识点.类.内部类实现多继承;

/**
 * @ProjectName: ProgrammingProblem
 * @Package: com.liang.面试知识点.类.内部类实现多继承
 * @ClassName: MyDemo
 * @Description:
 * @Author: Yang Liang
 * @CreateDate: 2022/3/10 23:20
 * @Version: 1.0
 */
public class MyDemo {
    private class myEmail extends EmailClass{
        @Override
        public String email() {
            return "MyDemo->"+super.email();
        }
    }
    public class myName extends NameClass{
        @Override
        public String name() {
            return "MyDemo->"+super.name();
        }
    }
    public String name(){
        return new myName().name();
    }
    public String email(){
        return new myEmail().email();
    }

    public static void main(String[] args) {
        MyDemo myDemo = new MyDemo();
        System.out.println(myDemo.name());
        System.out.println(myDemo.email());
    }
}
