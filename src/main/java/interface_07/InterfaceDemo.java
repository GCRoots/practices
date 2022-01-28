package interface_07;

public class InterfaceDemo {

    public static void main(String[] args) {
        MyInterface my1=new MyInterfaceImplOne();
        MyInterface my2=new MyInterfaceImplTwo();

        my1.show1();
        my1.show2();
        my1.show3();

        System.out.println();
        System.out.println("----------");
        System.out.println();

        my2.show1();
        my2.show2();
        my2.show3();

        System.out.println();
        System.out.println("----------");
        System.out.println();

        MyInterface.show4();


    }

}
