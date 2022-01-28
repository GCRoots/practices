package lambda_06.demo01;

public class LambdaDemo {

    public static void main(String[] args) {
        //1-实现类的方式实现多线程
        MyRunnable my=new MyRunnable();
        Thread thread=new Thread(my);
        thread.start();

        //2-匿名内部类的方式实现多线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("多线程程序启动了--匿名内部类");
            }
        }).start();

        //3-Lambda表达式的方式实现多线程
        new Thread(()->{
            System.out.println("多线程程序启动了--Lambda表达式");
        }).start();

    }

}
