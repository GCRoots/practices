package thread_04.threadDemo.daemonDemo;


public class DaemonThreadDemo {
    public static void main(String[] args) {

        DaemonThread myThread0=new DaemonThread();
        DaemonThread myThread1=new DaemonThread();

        myThread0.setName("关羽");
        myThread1.setName("张飞");

        //主线程
        Thread.currentThread().setName("刘备");

        //守护线程
        myThread0.setDaemon(true);
        myThread1.setDaemon(true);

        //JVM调用该线程的run()方法
        myThread0.start();
        myThread1.start();

        for (int i=0;i<50;i++){
            System.out.println(Thread.currentThread().getName()+":"+i);
        }


    }
}
