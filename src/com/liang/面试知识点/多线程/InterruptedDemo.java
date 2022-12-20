package com.liang.面试知识点.多线程;

public class InterruptedDemo {
    public static void main(String[] args) throws InterruptedException {
        ThreadDemo demo1 = new ThreadDemo("线程1");
        ThreadDemo demo2 = new ThreadDemo("线程2");
        demo1.start();
        demo2.start();
//        demo1.stop();
        Thread.sleep(1000);
        demo1.interrupt();
    }
}
class ThreadDemo extends Thread{

    public ThreadDemo(String name) {
        this.setName(name);
    }

    @Override
    public void run() {

        while(!isInterrupted()) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            System.out.println(Thread.currentThread().getName()+" is running");
            System.out.println(Thread.currentThread().getName()+" isInterrupted: "+isInterrupted());
        }
    }
}