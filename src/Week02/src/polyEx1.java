package Week02.src;

//추상클래스
abstract class AA{
    //doA() 메소드를 무조건 오버라이딩시키는 방법은 무엇이나?
    //추상메소드로 정의하면 된다.
    //public void doA(){}
    {
        System.out.println("AA 클래스");
    }
    public abstract void doA(); // 추상메소드

    public void doB() {
        System.out.println("AA doB()");
    }
}
class BB extends AA{
    {
        System.out.println("BB 클래스");
    }

    @Override
    public void doA() {

    }
}
public class polyEx1 {
    public static void main(String[] args) {
//        AA ap = new AA();
        //추상 클래스는 객체를 만들 수 없다.
        //즉 단독으로는 객체를 만들 수 없지만 자식객체를 만들때는 만들어진다.
        BB bp = new BB();
        bp.doB();

    }
}
