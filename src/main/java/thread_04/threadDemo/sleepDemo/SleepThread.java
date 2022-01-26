package thread_04.threadDemo.sleepDemo;

public class SleepThread extends Thread{

    public SleepThread() {
    }

    public SleepThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i=0;i<100;i++){
            System.out.println(this.getName()+":"+i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
