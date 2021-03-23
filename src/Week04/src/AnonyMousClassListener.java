package Week04.src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AnonyMousClassListener extends JFrame {
    private JButton btn = new JButton("Action");

    AnonyMousClassListener() {
        this.setTitle("Action ListenerEx 에제");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.formDesign();
        this.eventHandler();
        this.setSize(350, 150);
        this.setVisible(true);
    }

    public void formDesign() {
        this.setLayout(new FlowLayout());
        this.add(btn);
    }

    public void eventHandler() {
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand() == "Action") {
                    btn.setText("액션");
                }else {
                    btn.setText("Action");
                }
                setTitle(btn.getText());
            }
        });
    }

    public static void main(String[] args) {
        new AnonyMousClassListener();
    }
}
