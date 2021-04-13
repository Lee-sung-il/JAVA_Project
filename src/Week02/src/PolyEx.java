package Week02.src;

// 다형성
class A{
    int x = 10;
    public void  doA(){
        System.out.println("A doA()");
    }
    public void doC(){
        System.out.println("A doC()");
    }
}
class B extends A{
    int x = 100;
    int y = 200;

    // 매소드 오버라이딩(재정의)
    public void doA(){
        System.out.println("B doA()");
    }
    public void doB(){
        System.out.println("B doB()");
    }
}
public class PolyEx {
    public static void main(String[] args) {
        A ap = new A();
        B bp = new B();
        A aap = new B(); //다형성 - 부모타입으로 자식객체 생성(표현)
        //bp.doB();
        //bp.doC();
        bp.doA();
        aap.doA();
        aap.doC();
        //aap.doB();
        //다형성으로 생성한 객체(변수)는 부모클래스에 없고 자식클래스에만 있는
        //메소드는 바로 접근할 수 없고 형변환을 통해서 접근이 가능하다.
        B bbp = (B) aap;
        bbp.doB();
        //다형성으로 생성한 객체는 메소드 오버라이딩된 자식 메소드가 실행
        //변수는 부모클래스의 변수가 접근
        System.out.println(aap.x);
    }
}
