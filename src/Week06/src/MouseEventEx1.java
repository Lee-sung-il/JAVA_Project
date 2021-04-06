package Week06.src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseEventEx1 extends JFrame {
    private JPanel p = new JPanel();

    MouseEventEx1() {
        this.setTitle("MouseEventEx1");
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
        p.addMouseListener(new MyMouseListener());

    }

    class MyMouseListener extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getClickCount() == 2) {
                int r = (int) (Math.random() * 256); // 0 ~ 255
                int g = (int) (Math.random() * 256); // 0 ~ 255
                int b = (int) (Math.random() * 256); // 0 ~ 255

                p.setBackground(new Color(r, g, b));
            }
        }
    }

    public static void main(String[] args) {
        new MouseEventEx1();
    }
}
