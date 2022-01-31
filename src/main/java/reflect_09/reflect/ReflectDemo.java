package reflect_09.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class ReflectDemo {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        //获取Class对象
        getClassDemo();

        //获取构造方法
        getConstructorDemo();

        //获取成员变量
        getFieldDemo();

        //获取成员方法
        Class<?> aClass = Class.forName("reflect_09.reflect.Student");

        //获取所有public成员方法

    }

    //获取Class对象
    public static void getClassDemo() throws ClassNotFoundException {
        //1、使用类的class属性来获取该类对应的Class对象
        Class<Student> aClass = Student.class;
        System.out.println(aClass);
        Class<Student> aClass1 = Student.class;
        System.out.println(aClass==aClass1);
        System.out.println("--------");

        //2、调用对象的getClass()方法，返回对象所属类对应的Class对象
        Student student=new Student();
        Class<? extends Student> aClass2 = student.getClass();
        System.out.println(aClass==aClass2);
        System.out.println("--------");

        //3、使用Clas类的静态方法Class.forName(String className)
        Class<?> aClass3 = Class.forName("reflect_09.reflect.Student");
        System.out.println(aClass==aClass3);
        System.out.println("--------");
    }

    //获取构造方法
    public static void getConstructorDemo() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, ClassNotFoundException {
        Class<?> aClass = Class.forName("reflect_09.reflect.Student");
        //public构造方法
        Constructor<?>[] cons = aClass.getConstructors();
        for (Constructor con:cons){
            System.out.println(con);
        }
        System.out.println("--------");
        //所有构造方法
        Constructor<?>[] cons1 = aClass.getDeclaredConstructors();
        for (Constructor con:cons1){
            System.out.println(con);
        }
        System.out.println("--------");
        //获取特定public构造方法
        Constructor<?> con = aClass.getConstructor();
        //通过反射获取对象
        Object instance = con.newInstance();
        System.out.println(instance);
        System.out.println("--------");

        Constructor<?> con1 = aClass.getConstructor(String.class,int.class,String.class);
        //通过反射获取对象
        instance = con1.newInstance("林青霞",24,"香港");
        System.out.println(instance);
        System.out.println("--------");

        //获取任意特定构造方法
        Constructor<?> con2 = aClass.getDeclaredConstructor(String.class);
        //通过反射获取对象
        //暴力反射 取消访问检查
        //private方法调用前使用
        con2.setAccessible(true);
        instance = con2.newInstance("林青霞");
        System.out.println(instance);
        System.out.println("--------");

        Constructor<?> con3 = aClass.getDeclaredConstructor(String.class,int.class);
        //通过反射获取对象
        //暴力反射 取消访问检查
        //private方法调用前使用
        con3.setAccessible(true);
        instance = con3.newInstance("林青霞",24);
        System.out.println(instance);
        System.out.println("--------");
    }

    public static void getFieldDemo() throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        //获取成员变量
        Class<?> aClass = Class.forName("reflect_09.reflect.Student");

        //获取所有public成员变量
        Field[] fields = aClass.getFields();
        for (Field field:fields){
            System.out.println(field);
        }
        System.out.println("--------");

        //获取所有成员变量
        Field[] fields1 = aClass.getDeclaredFields();
        for (Field field:fields1){
            System.out.println(field);
        }
        System.out.println("--------");

        //获取某个public成员变量
        Field addressField = aClass.getField("address");
        //获取无参构造方法
        Constructor<?> con = aClass.getConstructor();
        //通过反射获取对象
        Object instance = con.newInstance();
        System.out.println(instance);
        addressField.set(instance,"香港"); //给instance的addressField成员变量赋值为香港
        System.out.println(instance);
        System.out.println("--------");

        //获取任意成员变量
        Field nameFiled = aClass.getDeclaredField("name");
        System.out.println(instance);
        //暴力反射 取消访问检查
        nameFiled.setAccessible(true);
        nameFiled.set(instance,"林青霞");
        System.out.println(instance);
        System.out.println("--------");
    }

}
