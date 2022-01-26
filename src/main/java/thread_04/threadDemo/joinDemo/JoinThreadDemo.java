package thread_04.threadDemo.joinDemo;

public class JoinThreadDemo {
    public static void main(String[] args) {

        JoinThread myThread0=new JoinThread();
        JoinThread myThread1=new JoinThread();
        JoinThread myThread2=new JoinThread();

        myThread0.setName("刘备");
        myThread1.setName("曹操");
        myThread2.setName("孙权");


        //JVM调用该线程的run()方法
        myThread0.start();
        try {
            //线程myThread0执行完成之后，其余线程才能继续执行
            myThread0.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        myThread1.start();
        myThread2.start();
    }
}
