package Week02.src;

//인터페이스는 상수와 추상메소드만 가진다.
interface Connectable {

    //public abstract void useInternet();
    public void useInternet(); // 추상메소드
//  public void doA() {}

}

class Device1 implements Connectable {

    @Override
    public void useInternet() {

        System.out.println("디바이스는 인터넷을 이용한다.");

    }
}

class SmartPhone1 extends Device1 {

    @Override
    public void useInternet() {

        System.out.println("SmartPhone이 인터넷을 이욥한다.");

    }

}
class TabletPC1 extends Device1 {

    @Override
    public void useInternet() {

        System.out.println("TabletPc가 인터넷을 이용한다.");

    }
}

class Refrigerator implements Connectable {

    @Override
    public void useInternet() {
        System.out.println("냉장고도 인터넷에 접속한다.");
    }
}

public class ConnectInternet1 {

    //메소드 파라미터의 다형성
    public void serveInternet(Connectable c) {
        c.useInternet();
    }

    public static void main(String[] args) {

        ConnectInternet1 ci = new ConnectInternet1();
        SmartPhone1 sp = new SmartPhone1();
        ci.serveInternet(sp);
        TabletPC1 pc = new TabletPC1();
        ci.serveInternet(pc);
        Refrigerator rg = new Refrigerator();
        ci.serveInternet(rg);

    }
}
