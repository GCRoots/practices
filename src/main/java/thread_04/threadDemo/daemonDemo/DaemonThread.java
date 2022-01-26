package thread_04.threadDemo.daemonDemo;

public class DaemonThread extends Thread{

    public DaemonThread() {
    }

    public DaemonThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i=0;i<100;i++){
            System.out.println(this.getName()+":"+i);
        }
    }
}
