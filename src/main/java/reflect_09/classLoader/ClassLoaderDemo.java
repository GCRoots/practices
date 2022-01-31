package reflect_09.classLoader;

public class ClassLoaderDemo {
    public static void main(String[] args) {
        ClassLoader c=ClassLoader.getSystemClassLoader();
        System.out.println(c);  //AppClassLoader

        ClassLoader c2 = c.getParent();
        System.out.println(c2); //ExtClassLoader

        ClassLoader c3 = c2.getParent();
        System.out.println(c3); //null

    }

}
