package lambda_06.demo02;

import lambda_06.demo02.add.Addable;
import lambda_06.demo02.add.AddableImpl;
import lambda_06.demo02.eat.Eatable;
import lambda_06.demo02.eat.EatableImpl;
import lambda_06.demo02.fly.Flyable;
import lambda_06.demo02.fly.FlyableImpl;
import lambda_06.demo02.student.Student;
import lambda_06.demo02.student.StudentBuilder;
import lambda_06.demo02.toUpper.Printer;
import lambda_06.demo02.toUpper.PrinterString;

public class LambdaDemo {

    public static void main(String[] args) {

        //1、无参无返回值
        System.out.println("无参无返回值");
        //实现类
        Eatable e=new EatableImpl();
        useEatable(e);
        //匿名内部类
        useEatable(new Eatable() {
            @Override
            public void eat() {
                System.out.println("吃东西——匿名内部类");
            }
        });
        //Lambda表达式
        useEatable(()->{
            System.out.println("吃东西——Lambda表达式");
        });
        System.out.println();

        //2、带参无返回值
        System.out.println("带参无返回值");
        //实现类
        Flyable f=new FlyableImpl();
        useFlyable(f);
        //匿名内部类
        useFlyable(new Flyable() {
            @Override
            public void fly(String s) {
                System.out.println(s);
                System.out.println("匿名内部类");
            }
        });
        //Lambda表达式
        useFlyable((String s)->{
            System.out.println(s);
            System.out.println("Lambda表达式");
        });
        System.out.println();

        //3、带参带返回值
        System.out.println("带参带返回值");
        //实现类
        Addable a=new AddableImpl();
        useAddable(a);
        //匿名内部类
        useAddable(new Addable() {
            @Override
            public int add(int a, int b) {
                System.out.println("匿名内部类");
                return a+b;
            }
        });
        //Lambda表达式
        useAddable((int x,int y)->{
            System.out.println("Lambda表达式");
            return x+y;
        });
        System.out.println();


        //Lambda表达式的省略
        System.out.println("Lambda表达式的省略");

        //带参方法的参数类型可以省略，且要省略都省略
        useFlyable((s)->{
            System.out.println(s);
            System.out.println("Lambda表达式");
        });
        useAddable((x,y)->{
            System.out.println("Lambda表达式");
            return x+y;
        });

        //若参数仅有一个，则小括号可省略
        useFlyable(s->{
            System.out.println(s);
            System.out.println("Lambda表达式");
        });

        //若代码块内仅有一条语句，则大括号、分号、return可以省略
        useFlyable(s -> System.out.println(s) );
        useAddable((x,y)->x+y );
        System.out.println();


        //方法引用
        System.out.println("方法引用");
        //1、引用类方法
        useFlyable(System.out::println);
        useAddable(Integer::sum);

        //2、引用对象的实例方法
        printerUpper((String s)->{
            String s1=s.toUpperCase();
            System.out.println(s1);
        });
        PrinterString ps=new PrinterString();
        printerUpper(ps::printerUpper);

        //3、引用类的实例方法
        //第一个参数作为调用者，后面的参数全部传递给该方法作为参数
        useMyString((String s,int x,int y)->{
            return s.substring(x,y);
        });
        useMyString((s,x,y)-> s.substring(x,y));
        useMyString(String::substring);

        //4、引用构造器，即引用构造方法
        useStudentBuilder((String name,int age)->{
            Student s=new Student(name,age);
            return s;
        });
        useStudentBuilder((name,age)->new Student(name,age));
        useStudentBuilder(Student::new);

    }

    public static void useEatable(Eatable e){
        e.eat();
    }

    public static void useFlyable(Flyable f){
        f.fly("Fly Fly Fly");
    }

    public static void useAddable(Addable a){
        int sum=a.add(10,20);
        System.out.println(sum);
    }

    public static void printerUpper(Printer p){
        p.printerUpper("hello world");
    }

    public static void useMyString(MyString myString){
        String s=myString.MySubString("HelloWorld",2,5);
        System.out.println(s);
    }

    public static void useStudentBuilder(StudentBuilder sb){
        Student s=sb.build("阿萨德",45);
        System.out.println(s.toString());
    }
}
