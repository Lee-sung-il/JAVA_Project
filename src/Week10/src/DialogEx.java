package Week10.src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Dialog 상자 만들기
class MyDialog extends JDialog {
    private JTextField tf = new JTextField(10);
    private JButton okButton = new JButton("OK");

    MyDialog(JFrame frame, String title) {
        super(frame, title);
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
                MyDialog.this.setVisible(false);
            }
        });
    }
}

public class DialogEx extends JFrame implements ActionListener {
    private JButton btn = new JButton("Show Dialog");
    private MyDialog dialog = new MyDialog(this, "Test Dialog");

    DialogEx() {
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
        new DialogEx();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        dialog.setVisible(true);
    }
}
