package sudentSystem_01.manager;

import sudentSystem_01.pojo.Student;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentManager {

    public static void main(String[] args) {

        ArrayList<Student> array=new ArrayList<>();

        while (true){
            System.out.println("------欢迎使用学生管理系统------");
            System.out.println("1 添加学生信息");
            System.out.println("2 删除学生信息");
            System.out.println("3 修改学生信息");
            System.out.println("4 查看所有学生信息");
            System.out.println("5 退出");
            System.out.println();
            System.out.println("------请做出选择------");

            Scanner scanner=new Scanner(System.in);
            String line=scanner.nextLine();

            switch (line){
                case "1":
//                    System.out.println("添加学生信息");
                    addStudent(array);
                    break;
                case "2":
//                    System.out.println("删除学生信息");
                    delStudent(array);
                    break;
                case "3":
//                    System.out.println("修改学生信息");
                    updateStudent(array);
                    break;
                case "4":
//                    System.out.println("查看所有学生信息");
                    if (array.isEmpty()){
                        System.out.println("暂无信息，请先添加信息\n");
                    }else{
                        System.out.println("学号\t\t\t姓名\t\t\t年龄\t\t\t居住地址");
                        for (int i=0;i<array.size();i++){
                            Student student=array.get(i);
                            System.out.println(student.getSid()+"\t\t\t"+student.getName()+"\t\t\t"+
                                    student.getAge()+"\t\t\t"+student.getAddrerss());
                        }
                    }
                    break;
                case "5":
                    System.out.println("谢谢使用");
                    System.exit(0); //JVM退出
                default:
                    System.out.println("输入有误，请重新输入");
                    System.out.println();

            }
        }


    }

    public static void addStudent(ArrayList<Student> array){

        Scanner scanner=new Scanner(System.in);


        System.out.print("请输入学生学号：");
        String sid = scanner.nextLine();

        while (isUsed(array,sid)){
            System.out.print("该学号已使用，请重新输入学生学号：");
            sid = scanner.nextLine();
        }

        System.out.print("请输入学生姓名：");
        String name = scanner.nextLine();
        System.out.print("请输入学生年龄：");
        String age = scanner.nextLine();
        System.out.print("请输入学生居住地址：");
        String address = scanner.nextLine();

        Student student=new Student(sid,name,age,address);

        array.add(student);

        System.out.println("添加学生信息成功");
        System.out.println();

    }

    public static boolean isUsed(ArrayList<Student> array,String sid){
        boolean flag=false;

        for (int i=0;i<array.size();i++){
            if (array.get(i).getSid().equals(sid)){
                flag=true;
                break;
            }
        }

        return flag;
    }

    public static void delStudent(ArrayList<Student> array){

        Scanner scanner=new Scanner(System.in);
        System.out.print("请输入欲删除学生学号：");
        String sid = scanner.nextLine();

        int index=-1;

        for (int i=0;i<array.size();i++){
            if (array.get(i).getSid().equals(sid)){
                index=i;
                break;
            }
        }

        if (index!=-1){
            array.remove(index);
            System.out.println("删除学生信息成功");
            System.out.println();
        }else {
            System.out.println("欲删除学生信息不存在");
            System.out.println();
        }



    }

    public static void updateStudent(ArrayList<Student> array){

        Scanner scanner=new Scanner(System.in);

        System.out.print("请输入欲修改学生学号：");
        String sid = scanner.nextLine();

        int index=-1;
        for (int i=0;i<array.size();i++){
            if (array.get(i).getSid().equals(sid)){
                index=i;
                break;
            }
        }

        if (index!=-1){
            System.out.print("请输入修改后的学生姓名：");
            String name = scanner.nextLine();
            System.out.print("请输入修改后的学生年龄：");
            String age = scanner.nextLine();
            System.out.print("请输入修改后的学生居住地址：");
            String address = scanner.nextLine();

//                array.get(i).setName(name);
//                array.get(i).setAge(age);
//                array.get(i).setAddrerss(address);

            Student student=new Student(sid,name,age,address);
            array.set(index,student);

            System.out.println("修改学生信息成功");
            System.out.println();
        }else {
            System.out.println("欲删除学生信息不存在");
            System.out.println();
        }



    }


}
