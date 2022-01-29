package stream_08;

import java.util.*;
import java.util.stream.Stream;

public class StreamDemo {
    public static void main(String[] args) {
        ArrayList<String> list=new ArrayList<>();
        list.add("张三丰");
        list.add("张无忌");
        list.add("赵敏");
        list.add("周芷若");
        list.add("张三");
        list.add("小昭");
        list.add("阿珠");

        //选择开头为张的字符串
        ArrayList<String> zhangList=new ArrayList<>();
        for (String s:list){
            if (s.startsWith("张")){
                zhangList.add(s);
            }
        }
        //选择开头为张，长度为3的字符串
        ArrayList<String> threeList=new ArrayList<>();
        for (String s:zhangList){
            if (s.length()==3){
                threeList.add(s);
            }
        }
        //输出
        for (String s:threeList){
            System.out.println(s);
        }
        System.out.println("--------");

        //改进--Stream流
        list.stream().filter(s->s.startsWith("张")).filter(s->s.length()==3).forEach(System.out::println);

        System.out.println("--------");

        //生产流
        //1、Collection：默认方法stream()
//        List<String> list1=new ArrayList<>();
//        Stream<String> stringStream = list1.stream();
//        Set<String> set=new HashSet<>();
//        Stream<String> stringStream1 = set.stream();

        //2、Map：间接生成流
//        Map<String,String> map=new HashMap<>();
//        Stream<String> keyStream = map.keySet().stream();
//        Stream<String> valueStream = map.values().stream();
//        Set<Map.Entry<String, String>> entriesStream = map.entrySet();

        //3、数组：Stream接口的静态方法生成流
//        String[] strings={"A","B","C"};
//        Stream<String> stringsStream = Stream.of(strings);
//        int[] ints={1,2,3};
//        Stream<int[]> intsStream = Stream.of(ints);



    }

}
