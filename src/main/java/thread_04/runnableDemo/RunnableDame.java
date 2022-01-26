package thread_04.runnableDemo;

public class RunnableDame {

    public static void main(String[] args) {
        MyRunnable myRunnable=new MyRunnable();

        Thread thread0=new Thread(myRunnable,"AA");
        Thread thread1=new Thread(myRunnable,"BB");

        thread0.start();
        thread1.start();

    }
}
