package Week06.src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyEventEx extends JFrame {
    private JLabel la = new JLabel("Love Java");
    private JPanel p = new JPanel();
    KeyEventEx() {
        this.setTitle("+,-키로 폰트크기 조절");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.formDesign();
        this.eventHandler();
        this.setSize(300,200);
        this.setVisible(true);

        la.setFocusable(true);
        la.requestFocus();
    }

    public void formDesign() {
        this.add(p);
        p.add(la);
        la.setFont(new Font("Arial",Font.PLAIN,10));
    }

    public void eventHandler() {
        la.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyChar() == '+') {
                    Font f = la.getFont();
                    int size = f.getSize();
                    la.setFont(new Font("Arial",Font.PLAIN,size+5));
                }else if (e.getKeyChar() == '-') {
                    Font f = la.getFont();
                    int size = f.getSize();
                    la.setFont(new Font("Arial",Font.PLAIN,size-5));
                }

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
    }

    public static void main(String[] args) {
        new KeyEventEx();
    }
}
