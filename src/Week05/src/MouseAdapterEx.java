package Week05.src;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseAdapterEx extends JFrame {
    private  JLabel la = new JLabel("Java");
    private  JPanel p = new JPanel();

    MouseAdapterEx() {
        this.setTitle("Mouse Adapter");
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
        //3)리스너 구현
        p.addMouseListener(new MyAdapter());
    }

    public static void main(String[] args) {
        new MouseAdapterEx();
    }

    //이벤트 리스너 구현 - 내부클래스로 Adapter 클래스
    class MyAdapter extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent e) {
            int x = e.getX();
            int y = e.getY();
            la.setLocation(x, y);
        }
    }
}
