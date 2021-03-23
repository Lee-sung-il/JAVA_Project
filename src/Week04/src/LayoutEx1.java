package Week04.src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LayoutEx1 extends JFrame implements ActionListener{
    private JButton btn_add = new JButton("add");
    private JButton btn_div = new JButton("div");
    private JButton btn_mul = new JButton("mul");
    private JButton btn_sub = new JButton("sub");
    private JButton btn_1 = new JButton("BTN1");
    private JButton btn_2 = new JButton("BTN2");
    private JButton btn_3 = new JButton("BTN3");
    private JButton btn_4 = new JButton("BTN4");
    private JButton btn_5 = new JButton("BTN5");
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
        this.add(btn_mul, BorderLayout.WEST);
        this.add(btn_div, BorderLayout.EAST);
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
        //3)프레임 자체에서 구현
        btn_add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand() == "add") {
                    btn_add.setText("더하기");
                } else {
                    btn_add.setText("add");
                }
            }
        });

        btn_sub.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand() == "sub") {
                    btn_sub.setText("빼기");
                } else {
                    btn_sub.setText("sub");
                }
            }
        });
       btn_mul.addActionListener(new MyAction());
       btn_div.addActionListener(new MyAction_Div());

       btn_1.addActionListener(this);
       btn_2.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == "BTN1") {
            btn_1.setText("이벤트");
        }else if (e.getActionCommand() == "이벤트"){
            btn_1.setText("BTN1");
        }
        if (e.getActionCommand() == "BTN2") {
            btn_2.setText("이벤트2");
        }else if (e.getActionCommand() == "이벤트2"){
            btn_2.setText("BTN2");
        }

//        btn_1 = (JButton) e.getSource();
//
//        if (btn_1.getText().equals("BTN1")) {
//            btn_1.setText("이벤트");
//        }else if (btn_1.getText().equals("이벤트")){
//            btn_1.setText("BTN1");
//        }
//
//        btn_2 = (JButton) e.getSource();
//        if (btn_2.getText().equals("BTN2")) {
//            btn_2.setText("이벤트2");
//        }else if (btn_2.getText().equals("이벤트2")){
//            btn_2.setText("BTN2");
//        }
    }

    //내부클래스로 이벤트 리스너구현
    class MyAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand() == "mul") {
                btn_mul.setText("곱하기");
            }else {
                btn_mul.setText("mul");
            }

        }
    }

    class MyAction_Div implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand() == "div") {
                btn_div.setText("나누기");
            }else {
                btn_div.setText("div");
            }
        }
    }

    public static void main(String[] args) {
        new LayoutEx1();
    }
}
