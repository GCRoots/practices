package interface_07.functionalInterface;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class FunctionalInterfaceDemo {
    public static void main(String[] args) {
        //函数式接口试用
        MyInterface my=()-> System.out.println("FunctionalInterface");
        my.show();


        //匿名内部类 函数式接口作为方法的参数
        startThread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"：线程启动了");
            }
        });
        startThread(()->System.out.println(Thread.currentThread().getName()+"：线程启动了"));

        System.out.println();
        System.out.println("----------");
        System.out.println();

        //函数式接口作为方法的返回值
        ArrayList<String> list=new ArrayList<>();
        list.add("aaaa");
        list.add("cc");
        list.add("bbb");
        list.add("d");
        list.add("eeeeeee");
        list.add("ffffff");

        System.out.println("排序前："+list);
        Collections.sort(list);
        System.out.println("默认排序后："+list);
        Collections.sort(list,getComparator());
        System.out.println("比较器排序后："+list);


    }

    //函数式接口作为方法的参数
    public static void startThread(Runnable r){
        new Thread(r).start();
    }

    //函数式接口作为方法的返回值
    public static Comparator<String> getComparator(){
        //匿名内部类实现
//        return new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return o1.length()-o2.length();
//            }
//        };

//        return(String s1,String s2)->{
//            return s1.length()-s2.length();
//        };

        return( s1, s2)->s1.length()-s2.length();

    }

}
