package Week03.src;

import javax.swing.*;
import java.awt.*;

public class ContentPaneEx extends JFrame {
    private JButton btn_ok = new JButton("OK");
    private JButton btn_cancel = new JButton("Cancel");
    private JButton btn_ignore = new JButton("Ignore");
    private JPanel p = new JPanel();

    ContentPaneEx() {
        this.setTitle("ContentPane 과 JFrame");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.formDesign();
        this.eventHandler();
        this.setSize(300, 150);
        this.setVisible(true);

    }

    private void formDesign() {
//        this.setLayout(new FlowLayout());
//        this.add(new JButton("OK"));
        this.add(p);
        p.setLayout(new FlowLayout());
        p.add(btn_ok);
        p.add(btn_cancel);
        p.add(btn_ignore);
        p.setBackground(Color.YELLOW);


    }


    private void eventHandler() {
    }


    public static void main(String[] args) {
        new ContentPaneEx();

    }
}
