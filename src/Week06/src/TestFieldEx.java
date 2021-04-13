package Week06.src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestFieldEx extends JFrame {
    private JPanel p = new JPanel();
    private JLabel la1 = new JLabel("이름 ");
    private JLabel la2 = new JLabel("학과 ");
    private JLabel la3 = new JLabel("주소 ");
    private JTextField textField1 = new JTextField(20);
    private JTextField textField2 = new JTextField("컴퓨터공학과", 20);
    private JTextField textField3 = new JTextField("서울시 ...", 20);
    private TextArea ta = new TextArea(7,30);

    TestFieldEx() {
        this.setTitle("텍스트필드 만들기 예제");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.formDesign();
        this.eventHandler();
        this.setSize(300, 300);
        this.setVisible(true);
    }

    public void formDesign() {
        this.add(p);
        p.add(la1);
        p.add(textField1);
        p.add(la2);
        p.add(textField2);
        p.add(la3);
        p.add(textField3);
        p.add(new JScrollPane(ta));

    }

    public void eventHandler() {
        textField1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ta.append(textField1.getText() + "\n");
                textField1.setText("");
            }
        });
        textField2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ta.append(textField2.getText() + "\n");
                textField2.setText("");
            }
        });
        textField3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ta.append(textField3.getText() + "\n");
                textField3.setText("");
            }
        });
    }

    public static void main(String[] args) {
        new TestFieldEx();
    }
}
