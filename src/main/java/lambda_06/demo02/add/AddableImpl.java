package lambda_06.demo02.add;

public class AddableImpl implements Addable{
    @Override
    public int add(int a, int b) {
        System.out.println("实现类");
        return a+b;
    }
}
