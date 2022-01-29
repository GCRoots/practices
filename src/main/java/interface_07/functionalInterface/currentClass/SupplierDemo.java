package interface_07.functionalInterface.currentClass;

import java.util.function.Supplier;

//生产型接口 Supplier<T>
public class SupplierDemo {
    public static void main(String[] args) {
        String s=getString(()->{
            return "林青霞";
        });
        System.out.println(s);
        s=getString(()->"尹正");
        System.out.println(s);

        int i=getInteger(()-> 30);
        System.out.println(i);

        int[] ints={12,15,45,999};
        int maxValue=getMax(()->{
           int max=ints[0];
           for (int j=1;j<ints.length;j++){
               if (ints[j]>max)
                   max=ints[j];
           }
           return max;
        });
        System.out.println("Max:"+maxValue);


    }

    public static String getString(Supplier<String> supplier){
        return supplier.get();
    }

    public static Integer getInteger(Supplier<Integer> supplier){
        return supplier.get();
    }

    //获取int数组中的最大值
    public static Integer getMax(Supplier<Integer> supplier){
        return supplier.get();
    }



}
