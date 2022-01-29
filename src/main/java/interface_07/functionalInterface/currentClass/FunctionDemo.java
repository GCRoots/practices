package interface_07.functionalInterface.currentClass;

import java.util.function.Function;

//Function<T, R> 接受一个参数并返回一个结果 T：参数类型，R：结果类型
public class FunctionDemo {
    public static void main(String[] args) {
        convert("12", s -> Integer.parseInt(s));
        convert("12", Integer::parseInt);

        convert("666",Integer::parseInt,i->String.valueOf(i+222));

    }

    //String类型参数转换为int类型的参数并输出
    public static void convert(String s,Function<String,Integer> fun){
        int i=fun.apply(s);
        System.out.println(i);
    }

    //String类型参数转换为int类型的参数,然后加上另一个int型参数，再转换为String类型并输出
    public static void convert(String s,Function<String,Integer> fun1,Function<Integer,String> fun2){
//        int i=fun1.apply(s);
//        String ss=fun2.apply(i);
//        System.out.println(ss);

        String ss=fun1.andThen(fun2).apply(s);
        System.out.println(ss);
    }

}
