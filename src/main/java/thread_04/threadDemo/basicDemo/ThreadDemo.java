package thread_04.threadDemo.basicDemo;

public class ThreadDemo {
    public static void main(String[] args) {
        //获取当前线程名称
        System.out.println(Thread.currentThread().getName());

        MyThread myThread1=new MyThread();
        MyThread myThread2=new MyThread();

        myThread1.setName("A");
        myThread2.setName("B");

        //线程优先级默认为5，范围1-10，且优先级高仅代表获取CPU的jilv高
        System.out.println("A:"+myThread1.getPriority());
        System.out.println("B:"+myThread2.getPriority());

        myThread1.setPriority(10);
        myThread2.setPriority(1);

        System.out.println("A:"+myThread1.getPriority());
        System.out.println("B:"+myThread2.getPriority());

        //JVM调用该线程的run()方法
        myThread1.start();
        myThread2.start();



    }
}
