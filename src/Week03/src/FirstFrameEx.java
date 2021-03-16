package Week03.src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FirstFrameEx extends JFrame {
    private JButton btn = new JButton("OK");

    FirstFrameEx() {
        this.setTitle("첫번째 프레임");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.formDesign(); // 폼 디자인
        this.eventHandler(); // 이벤트 처리
        this.setSize(300, 200);
        this.setVisible(true);
    }

    private void formDesign() {
        //2) 배치관리자 지정
//        this.setLayout(new FlowLayout());
        this.setLayout(new BorderLayout());
//        this.add(btn);
        Container contentPane = this.getContentPane();
        contentPane.add(btn);
    }

    private void eventHandler() {
        //1) 이벤트 소스를 찾느다. 2) 이벤트 소스에 귀를 달아준다.
        //3)이벤트 객체를 만들어 넣어준다.
        //4)이벤트 객체는 이벤트 리스너를 구현하여 만들어준다.

        btn.addActionListener(new MyAction());

      /*  btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand() ==  "OK") {
                    btn.setText("확인");
                }else {
                    btn.setText("OK");
                }
            }
        });*/
    }

    // 내부 클래스로 이벤트 리스너 구현
    class MyAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand() == "OK") {
                btn.setText("클릭");
            }else {
                btn.setText("OK");
            }

        }
    }


    public static void main(String[] args) {
        new FirstFrameEx();
//        FirstFrameEx fm = new FirstFrameEx();
    }
}
