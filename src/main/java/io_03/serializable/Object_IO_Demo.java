package io_03.serializable;


import io_03.serializable.pojo.Student;

import java.io.*;

public class Object_IO_Demo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("src/main/java/io_03/serializable/serial.txt"));
        ObjectInputStream ois=new ObjectInputStream(new FileInputStream("src/main/java/io_03/serializable/serial.txt"));

        Student studentOut =new Student("001","路安","15","鞍山南路");


        //序列化
        oos.writeObject(studentOut);
        //反序列化
        Student studentIn=(Student)ois.readObject();
        System.out.println(studentIn.toString());

        oos.close();
        ois.close();

    }

}
