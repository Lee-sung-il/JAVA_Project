package Week03.src;

import javax.swing.*;
import java.awt.*;

public class LayoutEx1 extends JFrame {
    private BorderLayout bd = new BorderLayout();
    private JPanel p = new JPanel();
    private GridLayout  gd = new GridLayout(1,2);
    private JButton btn1 = new JButton("btn1");
    private JButton btn2 = new JButton("btn2");
    private JButton btn3 = new JButton("btn3");
    private JPanel p1 = new JPanel();
    LayoutEx1() {
        this.setTitle("LayoutEx()");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.formDesign();
        this.eventHandler();
        this.setSize(300, 200);
        this.setVisible(true);
    }


    private void formDesign() {
        this.add(p,BorderLayout.SOUTH);
        p.setLayout(gd);
        p.add(btn1);
//        p.add(btn2);
        p.add(p1);
        p1.setLayout(new GridLayout(2,1));
        p1.add(btn2);
        p1.add(btn3);

    }

    private void eventHandler() {
    }

    public static void main(String[] args) {
        new LayoutEx1();
    }
}
