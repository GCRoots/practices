package file_03;

import java.io.*;

//复制文件夹到另一文件夹下
public class copyFiles {

    public static void main(String[] args) throws IOException {

        //源文件夹
        File srcFile=new File("E:\\kindle");
        //目的文件夹
        File destFile=new File("G:\\");

        copyFolder(srcFile,destFile);
    }

    //复制文件夹
    public static void copyFolder(File srcFile,File destFile) throws IOException {
        //判断源文件srcFile是否是文件夹
        if (srcFile.isDirectory()){
            //目录，在目的文件夹下创建与源文件srcFile同名的文件夹
            String srcFileName=srcFile.getName();
            File newFolder=new File(destFile,srcFileName);
            if (!newFolder.exists()){
                newFolder.mkdir();
            }

            //递归实现文件夹复制
            File[] files=srcFile.listFiles();
            for (File file:files){
                copyFolder(file,newFolder);
            }

        }else {
            //文件，直接复制
            File newFile=new File(destFile,srcFile.getName());
            copyFile(srcFile,newFile);

        }



    }

    //字节缓冲流复制文件
    public static void copyFile(File srcFile,File destFile) throws IOException {
        BufferedInputStream bis=new BufferedInputStream(new FileInputStream(srcFile));
        BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream(destFile));

        byte[] bytes=new byte[4096];
        int len;
        while ((len=bis.read(bytes))!=-1){
            bos.write(bytes,0,len);
        }
        bos.close();
        bis.close();
    }

}
