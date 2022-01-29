package interface_07.functionalInterface.currentClass;

import java.nio.charset.StandardCharsets;
import java.util.function.Consumer;

//消费型接口 Consumer<T>
public class ConsumerDemo {
    public static void main(String[] args) {
        operatorString("asdgfghf",(String s)->{
            System.out.println(s);
            System.out.println(s.toUpperCase());
        });
        operatorString("林青霞", System.out::println);
        operatorString("林青霞", s -> System.out.println(new StringBuilder(s).reverse()));
        System.out.println("-----------");
        operatorString("林青霞", System.out::println, s -> System.out.println(new StringBuilder(s).reverse()));






    }

    //对给定的参数进行操作一次
    public static void operatorString(String s,Consumer<String > consumer){
        consumer.accept(s);
    }

    //对给定的参数进行操作两次
    public static void operatorString(String s,Consumer<String > consumer1,Consumer<String > consumer2){
//        consumer1.accept(s);
//        consumer2.accept(s);
        consumer1.andThen(consumer2).accept(s);
    }

}
