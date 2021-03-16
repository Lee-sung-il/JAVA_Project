package Week03.src;

import javax.swing.*;

public class NullContainerEx extends JFrame {
    private JLabel la = new JLabel("Hello, Press Buttons!");
    NullContainerEx() {
        this.setTitle("Null Container Sample");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.formDesign();
        this.eventHandler();
        this.setSize(300,200);
        this.setVisible(true);
    }

    private void formDesign() {
        this.setLayout(null);
        la.setLocation(130,50);
        la.setSize(200,20);
        this.add(la);

        for (int i = 1; i <= 9; i++) {
            JButton b = new JButton(Integer.toString(i));
            b.setLocation(i*15,i*15);
            b.setSize(50,20);
            this.add(b);
        }
    }

    private void eventHandler() {
    }

    public static void main(String[] args) {
        new NullContainerEx();
    }
}
