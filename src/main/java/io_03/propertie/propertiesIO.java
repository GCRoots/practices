package io_03.propertie;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class propertiesIO {

    public static void main(String[] args) throws IOException {

        String fileName="src/main/java/io_03/propertie/demo.txt";

        //写入文件
        myStore(fileName);

        //读取文件
        myLoad(fileName);
        
    }

    private static void myLoad(String fileName) throws IOException {
        Properties properties=new Properties();

        FileReader reader=new FileReader(fileName);
        properties.load(reader);
        reader.close();

        System.out.println(properties);

    }

    private static void myStore(String fileName) throws IOException {
        Properties properties=new Properties();

        properties.setProperty("demo001","刘欢");
        properties.setProperty("demo002","路飞");
        properties.setProperty("demo003","阿狸");
        properties.setProperty("demo004","墨菲");

        FileWriter writer=new FileWriter(fileName);

        properties.store(writer,null);
        writer.close();

    }

}
