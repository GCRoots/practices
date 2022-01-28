package lambda_06.demo02.fly;

public class FlyableImpl implements Flyable{
    @Override
    public void fly(String s) {
        System.out.println(s);
        System.out.println("实现类");
    }
}
