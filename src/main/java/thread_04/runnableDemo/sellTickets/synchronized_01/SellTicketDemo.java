package thread_04.runnableDemo.sellTickets.synchronized_01;

public class SellTicketDemo {

    public static void main(String[] args) {
        SellTicket sellTicket=new SellTicket();

        Thread thread1=new Thread(sellTicket,"窗口一");
        Thread thread2=new Thread(sellTicket,"窗口二");
        Thread thread3=new Thread(sellTicket,"窗口三");

        thread1.start();
        thread2.start();
        thread3.start();


    }

}
