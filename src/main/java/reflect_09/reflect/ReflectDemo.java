package reflect_09.reflect;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ReflectDemo {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException, IOException {
        //获取Class对象
        getClassDemo();

        //获取构造方法
        getConstructorDemo();

        //获取成员变量
        getFieldDemo();

        //获取成员方法
        getMethodDemo();

        //越过泛型检查
        skipCheck();

        //通过配置文件运行类中的方法
        //加载数据
        Properties properties=new Properties();
        FileReader reader=new FileReader("src/main/java/reflect_09/reflect/class.txt");
        properties.load(reader);
        reader.close();

        String className = properties.getProperty("className");
        String methodName = properties.getProperty("methodName");

        //通过反射使用
        Class<?> aClass = Class.forName(className);
        //获取无参构造方法
        Constructor<?> con = aClass.getConstructor();
        //通过反射获取对象
        Object instance = con.newInstance();
        //调用方法
        Method method = aClass.getMethod(methodName);
        method.invoke(instance);


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

    //获取成员变量
    public static void getFieldDemo() throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
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

    //获取成员方法
    public static void getMethodDemo() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> aClass = Class.forName("reflect_09.reflect.Student");

        //获取所有public成员方法
        Method[] methods = aClass.getMethods();
        for (Method method:methods){
            System.out.println(method);
        }
        /*
         * public void reflect_09.reflect.Student.method3()
         * public void reflect_09.reflect.Student.method2()
         * public void reflect_09.reflect.Student.method1()
         *
         * 同时获得所有父类以及实现的接口中的public方法
         * public java.lang.String reflect_09.reflect.Student.toString()
         * public final void java.lang.Object.wait(long,int) throws java.lang.InterruptedException
         * public final native void java.lang.Object.wait(long) throws java.lang.InterruptedException
         * public final void java.lang.Object.wait() throws java.lang.InterruptedException
         * public boolean java.lang.Object.equals(java.lang.Object)
         * public native int java.lang.Object.hashCode()
         * public final native java.lang.Class java.lang.Object.getClass()
         * public final native void java.lang.Object.notify()
         * public final native void java.lang.Object.notifyAll()
         */
        System.out.println("--------");

        //获取所有成员方法
        Method[] methods1 = aClass.getDeclaredMethods();
        for (Method method:methods1){
            System.out.println(method);
        }
        /* 仅本类的方法
         * public java.lang.String reflect_09.reflect.Student.toString()
         * private void reflect_09.reflect.Student.function()
         * public void reflect_09.reflect.Student.method1()
         * public void reflect_09.reflect.Student.method2()
         * public void reflect_09.reflect.Student.method3()
         */
        System.out.println("--------");

        //获取某个public成员方法
        Method method1 = aClass.getMethod("method1");
        //获取无参构造方法
        Constructor<?> con = aClass.getConstructor();
        //通过反射获取对象
        Object instance = con.newInstance();
        //public Object invoke(Object obj, Object... args)
        //Object：返回值类型
        //Object obj：调用方法的对象
        //Object... args：方法需要的参数
        method1.invoke(instance);
        Method method2 = aClass.getMethod("method2", String.class);
        method2.invoke(instance,"林青霞");
        Method method3 = aClass.getMethod("method3", String.class, int.class);
        method3.invoke(instance,"林青霞",24);

        System.out.println("--------");

        //获取任意成员方法
        Method function = aClass.getDeclaredMethod("function");
        //暴力反射 取消访问检查
        function.setAccessible(true);
        function.invoke(instance);
        System.out.println("--------");
    }

    //越过泛型检查
    public static void skipCheck() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        ArrayList<Integer> list=new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        System.out.println(list); // [10, 20, 30]

        Class<? extends ArrayList> aClass = list.getClass();
        Method add = aClass.getMethod("add", Object.class);
        add.invoke(list,"hello");
        add.invoke(list,"world");
        System.out.println(list); // [10, 20, 30, hello, world]

        System.out.println("--------");

    }


}
