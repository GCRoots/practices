package thread_04.threadDemo.joinDemo;

public class JoinThread extends Thread{

    public JoinThread() {
    }

    public JoinThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i=0;i<100;i++){
            System.out.println(this.getName()+":"+i);
        }
    }
}
