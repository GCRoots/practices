package thread_04.runnableDemo.sellTickets.loak_02;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SellTicket implements Runnable {

    private int tickets = 100;

    private Lock lock=new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            try {
                lock.lock(); //加锁
                if (tickets > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "正在售出第" + tickets + "张票");
                    tickets--;
                }
            }finally {
                lock.unlock(); //解锁
            }
        }
    }
}

