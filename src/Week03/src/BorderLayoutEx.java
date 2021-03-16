package Week03.src;

import javax.swing.*;
import java.awt.*;

public class BorderLayoutEx extends JFrame {
    private JButton btn1 = new JButton("Btn1");
    private JButton btn2 = new JButton("Btn2");
    private JButton btn3 = new JButton("Btn3");
    private JButton btn4 = new JButton("Btn4");
    private JButton btn5 = new JButton("Btn5");

    BorderLayoutEx() {
        this.setTitle("BorderLayout");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.formDesign();
        this.eventHandler();
        this.setSize(300, 200);
        this.setVisible(true);
    }

    private void formDesign() {
        //1) 배치관리자 지정
//        프레임의 기본 배치관리자는 BorderLayout
//        this.setLayout(new BorderLayout());
//        this.add(btn1, BorderLayout.NORTH);
//        this.add(btn2,BorderLayout.SOUTH);
//        this.add(btn3,BorderLayout.WEST);
//        this.add(btn4,BorderLayout.EAST);
//        this.add(btn5,BorderLayout.CENTER);
        this.add(btn5);
        this.add(btn4);




    }

    private void eventHandler() {
    }


    public static void main(String[] args) {
        new BorderLayoutEx();
    }
}
