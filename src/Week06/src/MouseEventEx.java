package Week06.src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseEventEx extends JFrame {
    private JPanel p = new JPanel();

    MouseEventEx() {
        this.setTitle("MouseEvent");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.formDesign();
        this.eventHandler();
        this.setSize(300, 200);
        this.setVisible(true);
    }

    public void formDesign() {
        this.add(p);
    }

    public void eventHandler() {
        //익명중첩클래스로 이벤트 리스너 구현
        p.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int r = (int) (Math.random() * 256); // 0 ~ 255
                    int g = (int) (Math.random() * 256); // 0 ~ 255
                    int b = (int) (Math.random() * 256); // 0 ~ 255

                    p.setBackground(new Color(r, g, b));
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {


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
        });
    }

    public static void main(String[] args) {
        new MouseEventEx();
    }
}
