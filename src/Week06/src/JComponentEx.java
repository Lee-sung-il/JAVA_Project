package Week06.src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JComponentEx extends JFrame {
    private JPanel p = new JPanel();
    private JButton btn1, btn2, btn3;

    JComponentEx() {
        this.setTitle("JComponent의 공통 메소드 예제");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.formDesign();
        this.eventHandler();
        this.setSize(260, 200);
        this.setVisible(true);
    }

    public void formDesign() {
        btn1 = new JButton("Magenta/Yellow Button");
        btn1.setBackground(Color.YELLOW);
        btn1.setForeground(Color.MAGENTA);
        btn1.setFont(new Font("Arial", Font.ITALIC, 20));
        btn1.setOpaque(true);
        btn1.setBorderPainted(false);
        btn2 = new JButton("     Disable Button     ");
        btn2.setEnabled(false);
        btn3 = new JButton("getX(), getY()");

        this.add(p);
        p.add(btn1);
        p.add(btn2);
        p.add(btn3);
    }

    public void eventHandler() {
        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton b = (JButton) e.getSource();
                JComponentEx f = (JComponentEx) b.getTopLevelAncestor();
                f.setTitle(b.getX() + "," +b.getY());
            }
        });
    }

    public static void main(String[] args) {
        new JComponentEx();
    }
}
