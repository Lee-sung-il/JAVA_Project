package Week11.src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OptionPaneEx1 extends JFrame {
    private JPanel p = new JPanel();
    private JButton inputBtn = new JButton("Input Name");
    private JButton confirmBtn = new JButton("confirm");
    private JButton messageBtn = new JButton("Message");
    private JTextField tf = new JTextField(10);

    OptionPaneEx1() {
        this.setTitle("옵션 팬 예제 ");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.formDesign();
        this.eventHandler();
        this.setSize(500, 200);
        this.setVisible(true);
    }

    public void formDesign() {
        this.add(p, BorderLayout.NORTH);
        p.setBackground(Color.GRAY);
        p.add(inputBtn);
        p.add(confirmBtn);
        p.add(messageBtn);
        p.add(tf);
    }

    public void eventHandler() {
        inputBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //입력 다이얼로그 생성
                String name = JOptionPane.showInputDialog("이름을 입력하세요.");
                if (name != null)
                    tf.setText(name); //사용자가 입력한 문자열을 텍스트필드 창에 출력
            }
        });
        confirmBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //확인 다이얼로그 생성
                int result = JOptionPane.showConfirmDialog(null,"계속할 것입니까?",
                        "confirm",JOptionPane.YES_NO_OPTION);
                // 사용자가 선택한 버튼에 따라 문자열을 텍스트필드 창에 출력
                if (result == JOptionPane.CLOSED_OPTION) {
                    tf.setText("Just Closed without Selection");
                }else if (result == JOptionPane.YES_OPTION) {
                    tf.setText("Yes");
                }else {
                    tf.setText("No");
                }
            }
        });
        messageBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //메시지 다이얼로그 생성
                JOptionPane.showMessageDialog(null,"조심하세요","Message",
                        JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    public static void main(String[] args) {
        new OptionPaneEx1();
    }

}
