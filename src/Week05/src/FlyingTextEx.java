package Week05.src;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

//프레임자체에서 리스너 구횬
public class FlyingTextEx extends JFrame{
    private JPanel p = new JPanel();
    private JLabel la = new JLabel("HELLO");

    FlyingTextEx() {
        this.setTitle("상,화,좌,우 키를 이용하여 텍스트 움직이기");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.formDesign();
        this.eventHandler();
        this.setSize(300, 300);
        this.setVisible(true);

        //패널에 포커스 준다.
        p.setFocusable(true);
        p.requestFocus();
    }

    public void formDesign() {
        this.add(p);
        p.setLayout(null);
        la.setSize(50, 20);
        la.setLocation(50, 50);
        p.add(la);
    }

    public void eventHandler() {
        p.addKeyListener(new MyKeyListener());
    }

    class MyKeyListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();

            switch (keyCode) {
                case KeyEvent.VK_UP:
                    la.setLocation(la.getX(), la.getY() - 10);
                    break;
                case KeyEvent.VK_DOWN:
                    la.setLocation(la.getX(), la.getY() + 10);
                    break;
                case KeyEvent.VK_RIGHT:
                    la.setLocation(la.getX() + 10, la.getY());
                    break;
                case KeyEvent.VK_LEFT:
                    la.setLocation(la.getX() - 10, la.getY());
                    break;
            }

        }
    }

    public static void main(String[] args) {
        new FlyingTextEx();
    }


}
