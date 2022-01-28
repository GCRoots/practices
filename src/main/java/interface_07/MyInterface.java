package interface_07;

public interface MyInterface {
    //抽象方法
    //实现类中必须重写
    void show1();
    void show2();

    //默认方法
    //不强制重写
    default void show3(){
        System.out.println("default show3");
    }

    //静态方法
    //仅能通过接口名调用，实现类不能调用
    static void show4(){
        System.out.println("static show4");
    }

    //私有方法，Java9中新增


}
