package Week05.src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyCodeEx extends JFrame {
    private JPanel p = new JPanel();
    private JLabel la = new JLabel("AAA");

    KeyCodeEx() {
        this.setTitle("Key Code 예제 : F1키:초록색, %키:노란색");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.formDesign();
        this.eventHandler();
        this.setSize(300, 200);
        this.setVisible(true);
        //패널이 포카스를 가지도록 포커스를 준다.
        p.setFocusable(true);
        p.requestFocus();
    }

    public void formDesign() {
        this.add(p);
        p.setLayout(new BorderLayout());
        p.add(la);
    }

    public void eventHandler() {
        //1)이벤트 소스 2)귀를 달아주고, 3) 이벤트리스너 구현 4) 객체생성
        p.addKeyListener(new MyKeyListener());
    }

    public static void main(String[] args) {
        new KeyCodeEx();
    }

    class MyKeyListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            la.setText(KeyEvent.getKeyText(e.getKeyCode())+"키가 눌러짐");
            if (e.getKeyChar() == '%') {
                p.setBackground(Color.GREEN);
            }else if (e.getKeyCode() == KeyEvent.VK_F1) {
                p.setBackground(Color.YELLOW);

            }
        }
    }
}
