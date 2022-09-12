package com.liang.面试知识点.锁;


import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class 自旋锁 {
    static volatile MyLock lock;
    public static int testAndSet(MyLock lock, int newVal){
        int old = lock.getLock();
        lock.setLock(newVal);
        return old;
    }

    private static AtomicBoolean available = new AtomicBoolean(false);

    public static void main(String[] args) throws InterruptedException {

        lock = new MyLock();
        Integer sync = 1;
        MyValuable myValuable = new MyValuable();

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
//                synchronized (sync){
//                    while (testAndSet(lock, 1) == 1) ;      //自旋锁
//                }
                while (!available.compareAndSet(false, true));
                myValuable.increase();
                available.set(false);
//                lock.setLock(0);
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
//                synchronized (sync){
//                    while (testAndSet(lock, 1) == 1) ;      //自旋锁
//                }
                while (!available.compareAndSet(false, true));
                myValuable.increase();
                available.set(false);
//                lock.setLock(0);
            }
        });
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
//        Thread.sleep(10000);
        System.out.println(myValuable.getValue());
    }

}
class MyValuable{
    int value;

    public MyValuable() {
        this.value = 0;
    }
    public int getValue() {
        return value;
    }
    public void increase(){
        for (int i = 0; i < 10; i++) {
            value++;
        }

    }
}
class MyLock{
    private volatile int lock;

    public MyLock() {
        this.lock = 0;
    }

    public int getLock() {
        return lock;
    }

    public void setLock(int lock) {
        this.lock = lock;
    }
}
