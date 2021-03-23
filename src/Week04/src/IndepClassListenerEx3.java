package Week04.src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class IndepClassListenerEx3 extends JFrame implements ActionListener {
    private JButton btn = new JButton("Action");

    IndepClassListenerEx3() {
        this.setTitle("Action Listener 에제");
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
        btn.addActionListener(this);
    }


    public static void main(String[] args) {
        new IndepClassListenerEx3();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == "Action") {
            btn.setText("액션");
        }else {
            btn.setText("Action");
        }
        setTitle(btn.getText());
    }
}

