package Week03.src;

import javax.swing.*;
import java.awt.*;

public class LayoutEx extends JFrame {
    private JButton btn1 = new JButton("Btn1");
    private JButton btn2 = new JButton("Btn2");
    private JButton btn3 = new JButton("Btn3");
    private JPanel p = new JPanel();

    LayoutEx() {
        this.setTitle("Layout 예제");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.formDesign();
        this.eventHandler();
        this.setSize(300, 200);
        this.setVisible(true);
    }

    private void formDesign() {
//        this.setLayout(new BorderLayout());
        this.add(p, BorderLayout.NORTH);
//        p.setLayout(new FlowLayout());
        p.add(btn1);
        p.add(btn2);
        this.add(btn3, BorderLayout.CENTER);
    }

    private void eventHandler() {
    }

    public static void main(String[] args) {
        new LayoutEx();
    }
}
