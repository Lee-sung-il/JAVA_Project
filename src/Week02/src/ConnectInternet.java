package Week02.src;

//추상클래스
abstract class Device {

    //이 메소드를 무조건 오버라이딩 시키려면?? -> 추상메소드로 정의하면 된다.

    public abstract void useInternet();

   /* public void useInternet() {

        System.out.println("디바이스가 인터넷을 이용한다.");

    }*/
}

class SmartPhone extends Device{

   /* public void useSmartPhone() {

        System.out.println("SmartPhone으로 인터넷을 접속한다.");

    }*/

    //메소드 오버라이딩

    @Override
    public void useInternet() {

        System.out.println("SmartPhone으로 인터넷을 접속한다.");

    }
}
class TabletPC  extends Device {

    /*public void useTabletPC() {

        System.out.println("TabletPC로 인터넷을 접속한다.");

    }*/

    //메소드 오버라이딩

    @Override
    public void useInternet() {

        System.out.println("TabletPC로 인터넷을 접속한다.");

    }
}
public class ConnectInternet {
    // 상속을 이용하지 않는 경우 : 각 디바이스 지원하기 위한 각각의 기지국이 있어야 한다.

    /*  public void serveInternet(SmartPhone sp) {
        sp.useSmartPhone();
    }
    public void serveInternet(TabletPC pc) {
        pc.useTabletPC();
    }*/

    // 상속을 이용하는 경우

    // 파라미터의 다형성에 의해 Device 타입은 모두 받아 들일 수 있다.

   /* public void  serveInternet(Device d) {

        if (d instanceof SmartPhone) {

            ((SmartPhone) d).useSmartPhone();

        }else if (d instanceof TabletPC) {

            ((TabletPC) d).useTabletPC();

        }
    }*/

    //오버라이딩을 이용하는 경우
    public void serveInternet(Device d) {

        d.useInternet();

    }

    public static void main(String[] args) {

        ConnectInternet ci = new ConnectInternet();
        SmartPhone sp = new SmartPhone();
        ci.serveInternet(sp);
        TabletPC pc = new TabletPC();
        ci.serveInternet(pc);

    }
}
