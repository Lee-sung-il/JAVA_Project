package Week04.src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LayoutEx1 extends JFrame {
    private JButton btn_add = new JButton("add");
    private JButton btn_div = new JButton("div");
    private JButton btn_mul = new JButton("mul");
    private JButton btn_sub = new JButton("sub");
    private JButton btn_1 = new JButton("1");
    private JButton btn_2 = new JButton("2");
    private JButton btn_3 = new JButton("3");
    private JButton btn_4 = new JButton("4");
    private JButton btn_5 = new JButton("5");
    private JPanel p1 = new JPanel();

    LayoutEx1() {
        this.setTitle("LayoutEx1");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.formDesign();
        this.eventHandler();
        this.setSize(300, 200);
        this.setVisible(true);
    }

    public void formDesign() {
        this.add(btn_add, BorderLayout.NORTH);
        this.add(btn_div, BorderLayout.WEST);
        this.add(btn_mul, BorderLayout.EAST);
        this.add(btn_sub, BorderLayout.SOUTH);
        this.add(p1, BorderLayout.CENTER);
        p1.setLayout(new GridLayout(2, 3));
        p1.add(btn_1);
        p1.add(btn_2);
        p1.add(btn_3);
        p1.add(btn_4);
        p1.add(btn_5);
    }

    public void eventHandler() {
        //1)이벤트 소스찾디(btn_n)
        //2)소스에 귀를 달아준다.
        //이벤트 리스너 구현(1. 익명중첩클래스(객체이 동시에 된다.)
        btn_add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

    }

    public static void main(String[] args) {
        new LayoutEx1();
    }
}
