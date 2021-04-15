package Week07.src;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ComboBoxEx extends JFrame {
    private JPanel p = new JPanel();
    private String[] fruits = {
            "apple", "banana", "kiwi", "mango", "pear", "peach", "berry", "strawberry", "blackberry"
    };
    private String[] names = {
            "kitae", "jaemoon", "hyosoo", "namyun"
    };
    private JComboBox<String> strCombo, nameCombo;

    private JLabel la1 = new JLabel("apple");
    private JLabel la2 = new JLabel("kitae");
    private JPanel p1 = new JPanel();


    ComboBoxEx() {
        this.setTitle("ComboBox");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.formDesign();
        this.eventHandler();
        this.setSize(300, 300);
        this.setVisible(true);

    }

    public void formDesign() {
        this.add(p);
        strCombo = new JComboBox<String>(fruits);
        nameCombo = new JComboBox<String>(names);
        p.add(strCombo);
        p.add(nameCombo);
        p.add(p1);
        p1.add(la1);
        p1.add(la2);
    }

    public void eventHandler() {
        strCombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                strCombo = (JComboBox) e.getSource();
                int index = strCombo.getSelectedIndex();
                la1.setText((String) strCombo.getItemAt(index));
            }
        });

        nameCombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nameCombo = (JComboBox) e.getSource();
                int index = nameCombo.getSelectedIndex();
                la2.setText((String) nameCombo.getItemAt(index));
            }
        });

    }

    public static void main(String[] args) {
        new ComboBoxEx();
    }
}
