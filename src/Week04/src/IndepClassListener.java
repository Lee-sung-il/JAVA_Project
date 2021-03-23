package Week04.src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class IndepClassListener extends JFrame {
    private JButton btn = new JButton("Action");

    IndepClassListener() {
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
        btn.addActionListener(new MyActionListener());
    }



    public static void main(String[] args) {
        new IndepClassListener();
    }
}

class MyActionListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btn = (JButton) e.getSource();
        if (btn.getText().equals("Action")) {
            btn.setText("액션");
        }else {
            btn.setText("Action");
        }
    }
}