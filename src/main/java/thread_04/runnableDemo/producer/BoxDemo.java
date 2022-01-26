package thread_04.runnableDemo.producer;

public class BoxDemo {
    public static void main(String[] args) {
        MilkBox box=new MilkBox();

        Producer producer=new Producer(box);
        Customer customer=new Customer(box);

        Thread threadP=new Thread(producer);
        Thread threadC=new Thread(customer);

        threadP.start();
        threadC.start();


    }
}
