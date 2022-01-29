package stream_08.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo {

    public static void main(String[] args) {
        List<String> manList=new ArrayList<>();
        manList.add("周杰伦");
        manList.add("林俊杰");
        manList.add("李连杰");
        manList.add("成龙");
        manList.add("吴京");
        manList.add("周星驰");
        List<String> womanList=new ArrayList<>();
        womanList.add("林心如");
        womanList.add("贾玲");
        womanList.add("迪丽热巴");
        womanList.add("林青霞");
        womanList.add("林志玲");
        womanList.add("柳岩");

        //男演员名字为三个字的前三人
        Stream<String> manStream = manList.stream().filter(s -> s.length() == 3).limit(3);
        //女演员姓为林且不要第一人
        Stream<String> womanStream = womanList.stream().filter(s -> s.startsWith("林")).skip(1);
        //合并
        Stream<String> stream = Stream.concat(manStream, womanStream);
        //创建Actor对象并遍历
        stream.map(Actor::new).forEach(System.out::println);

        List<String> list = Stream.concat(manList.stream().filter(s -> s.length() == 3).limit(3),
                womanList.stream().filter(s -> s.startsWith("林")).skip(1)).collect(Collectors.toList());
        for (String s:list){
            System.out.println(s);
        }


    }

}
