package thread_04.threadDemo.sleepDemo;

public class SleepThreadDemo {
    public static void main(String[] args) {
        SleepThread myThread0=new SleepThread();
        SleepThread myThread1=new SleepThread();
        SleepThread myThread2=new SleepThread();

        myThread0.setName("刘备");
        myThread1.setName("曹操");
        myThread2.setName("孙权");


        //JVM调用该线程的run()方法
        myThread0.start();
        myThread1.start();
        myThread2.start();
    }
}
