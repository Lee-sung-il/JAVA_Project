package Week10.src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Dialog 상자 만들기
class MyModalDialog extends JDialog {
    private JTextField tf = new JTextField(10);
    private JButton okButton = new JButton("OK");

    MyModalDialog(JFrame frame, String title) {
        super(frame, title,true); //모달다이얼로그
        this.dialogDesign();
        this.dialogEvent();
        this.setSize(200, 100);
    }

    public void dialogDesign() {
        this.setLayout(new FlowLayout());
        this.add(tf);
        this.add(okButton);
    }

    public void dialogEvent() {
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MyModalDialog.this.setVisible(false);
            }
        });
    }

    public String getInput() {
        if (tf.getText().length() == 0) {
            return null;
        } else return tf.getText();
    }
}

public class DialogEx2 extends JFrame implements ActionListener {
    private JButton btn = new JButton("Show Dialog");
    private MyModalDialog dialog = new MyModalDialog(this, "Test Modal Dialog");

    DialogEx2() {
        this.setTitle("DialogEx 예제");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.formDesign();
        this.eventHandler();
        this.setSize(300, 300);
        this.setVisible(true);
    }

    public void formDesign() {
        this.add(btn);
    }

    public void eventHandler() {
        btn.addActionListener(this);
    }

    public static void main(String[] args) {
        new DialogEx2();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        dialog.setVisible(true);

        String text = dialog.getInput();

        if (text == null) return;
        JButton btn = (JButton) e.getSource();
        btn.setText(text);
    }
}
