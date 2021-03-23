package Week04.src;

import javax.swing.*;
import java.awt.*;

public class LayoutEx extends JFrame {
    private JButton btn1 = new JButton("OK1");
    private JButton btn2 = new JButton("OK2");
    private JButton btn3 = new JButton("OK3");
    private JPanel p1 = new JPanel();
    private JPanel p2 = new JPanel();

    LayoutEx() {
        this.setTitle("LayoutEx");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.formDesign();
        this.eventHandler();
        this.setSize(300, 200);
        this.setVisible(true);
    }

    public void formDesign() {
//        this.setLayout(new BorderLayout());
        this.add(p1,BorderLayout.SOUTH);
        p1.setLayout(new GridLayout(1,2));
        p1.add(btn1);
        p1.add(p2);
        p2.setLayout(new GridLayout(2,1));
        p2.add(btn2);
        p2.add(btn3);


    }

    public void eventHandler() {
    }


    public static void main(String[] args) {
        new LayoutEx();
    }
}
