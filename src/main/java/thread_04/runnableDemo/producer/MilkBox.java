package thread_04.runnableDemo.producer;

//奶箱，共享数据区
public class MilkBox {
    private int milk;

    //奶箱状态
    private boolean state=false;

    public synchronized void put(int milk){
        if (state){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //没有牛奶，生产
        this.milk=milk;
        System.out.println("送奶工将第"+this.milk+"瓶奶放入箱中");

        //生产完成，修改奶箱状态
        state=true;

        //唤醒其他等待的线程
        notifyAll();

    }

    public synchronized void get(){
        if (!state){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //有牛奶，使用
        System.out.println("用户拿到第"+this.milk+"瓶奶");
        this.milk--;

        //使用完成，修改奶箱状态
        state=false;

        //唤醒其他等待的线程
        notifyAll();
    }

}
