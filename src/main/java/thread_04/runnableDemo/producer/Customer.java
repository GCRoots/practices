package thread_04.runnableDemo.producer;

public class Customer implements Runnable{
    private MilkBox box;

    public Customer(MilkBox box) {
        this.box=box;
    }

    @Override
    public void run() {
        while (true){
            box.get();
        }
    }
}
