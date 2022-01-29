package interface_07.functionalInterface.currentClass;

import java.util.function.Predicate;

//判断参数是否满足给定的条件 Predicate<T>
public class PredicateDemo {
    public static void main(String[] args) {

        boolean b1=checkString("林青霞",s->s.equals("林青霞"));
        System.out.println(b1);

        boolean b2=checkString("hello", s -> s.length() > 8, s -> s.length() < 15);
        System.out.println(b2);
    }

    //判断给定的字符串是否满足条件
    //boolean test(T t);
    //negate() 非运算
    public static boolean checkString(String s, Predicate<String> predicate){
        return predicate.negate().test(s);
    }

    //and() 短路逻辑与运算
    //or() 短路逻辑或运算
    public static boolean checkString(String s, Predicate<String> pre1,Predicate<String> pre2){
        //boolean b1 = pre1.test(s);
        //boolean b2 = pre2.test(s);
        //boolean b = b1 && b2;
        return pre1.and(pre2).test(s);
    }

}
