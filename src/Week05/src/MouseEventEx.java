package Week05.src;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

class MyMouseEvent implements MouseListener {
    JLabel la = new JLabel();

    MyMouseEvent(JLabel la) {
        this.la = la;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        la.setLocation(x, y);
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}

public class MouseEventEx extends JFrame {
    private JLabel la = new JLabel("Hello");
    private JPanel p = new JPanel();

    MouseEventEx() {
        this.setTitle("MouseEvent");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.formDesign();
        this.eventHandler();
        this.setSize(300, 300);
        this.setVisible(true);
    }

    public void formDesign() {
        this.add(p);
        p.setLayout(null);
        la.setSize(50, 20);
        la.setLocation(30, 30);
        p.add(la);
    }

    public void eventHandler() {
        //1)이벤트 소스 ->p
        //2)이벤트 소스에 귀를 달아준다.
        //3)이벤트리스너구현 - 외부(독립클래스)클래스로 구현
        //4)이벤트객체를 생성
        p.addMouseListener(new MyMouseEvent(la));

    }

    public static void main(String[] args) {
        new MouseEventEx();
    }
}
