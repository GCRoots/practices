package thread_04.runnableDemo.producer;

//生产者
public class Producer implements Runnable{
    private MilkBox box;

    public Producer(MilkBox box) {
        this.box=box;
    }

    @Override
    public void run() {
        for (int i=0;i<5;i++){
            box.put(i+1);
        }
    }
}
