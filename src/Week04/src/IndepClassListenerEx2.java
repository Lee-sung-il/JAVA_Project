package Week04.src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class IndepClassListenerEx2 extends JFrame {
    private JButton btn = new JButton("Action");

    IndepClassListenerEx2() {
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
        btn.addActionListener(new MyActionListenerEx2());
    }

    class MyActionListenerEx2 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            btn = (JButton) e.getSource();
            if (btn.getText().equals("Action")) {
                btn.setText("액션");
            } else {
                btn.setText("Action");
            }
        }
    }

    public static void main(String[] args) {
        new IndepClassListener();
    }
}

