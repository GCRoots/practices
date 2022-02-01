package reflect_09.reflect;

public class Student {

    private String name;
    int age;
    public String address;

    public Student() {
    }

    private Student(String name) {
        this.name = name;
    }

    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    private void function(){
        System.out.println("function");
    }

    public void method1(){
        System.out.println("method1");
    }

    public void method2(String name){
        System.out.println("method2:"+name);
    }

    public void method3(String name,int age){
        System.out.println("method3:"+name+","+age);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }
}
