package thread_04.runnableDemo.sellTickets.synchronized_01;

public class SellTicket implements Runnable {

    private static int tickets = 100;
    int x = 0;

    @Override
    public void run() {
        while (true) {
            if (x % 2 == 0) {
                //同步代码块
//                synchronized (this){ //非静态同步方法锁对象
                synchronized (SellTicket.class) { //静态同步方法锁对象
                    if (tickets > 0) {
                        try {
                            Thread.sleep(100); //出票时间->会产生相同的票和输出负数的情况->加锁
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName() + "正在售出第" + tickets + "张票");
                        tickets--;
                    }
                }
            } else {
                //同步方法
                sellTicket();
            }
        }
    }

    public synchronized static void sellTicket() {
        if (tickets > 0) {
            try {
                Thread.sleep(100); //出票时间->会产生相同的票和输出负数的情况->加锁
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "正在售出第" + tickets + "张票");
            tickets--;
        }
    }

}
