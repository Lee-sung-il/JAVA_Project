package Week04.src;
//익명중첩클래스 : 상위클래스의 메소드를 재정의하고자 할때
//클래스를 별도로 정의하지 않고 직접 생성과 동시에 메소드를 재정의
class Inner {
    public void print() {
        System.out.println("Inner print()....");
    }
}
public class AnonyEx {
    public static void doA(Inner obj) {
        obj.print();
    }

    public static void main(String[] args) {
        //익명중첩클래스
         AnonyEx.doA(new Inner(){
            public void print() {
                System.out.println("재정의된 print()....");
            }
        });
    }
}
