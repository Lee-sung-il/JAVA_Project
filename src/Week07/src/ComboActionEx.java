package Week07.src;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ComboActionEx extends JFrame {
    private JPanel p = new JPanel();
    private String[] fruits = {"apple", "banana", "kiwi", "mango"};
    private ImageIcon[] images = {
            new ImageIcon("images/apple.jpg"),
            new ImageIcon("images/banana.jpg"),
            new ImageIcon("images/kiwi.jpg"),
            new ImageIcon("images/mango.jpg"),
    };
    private JLabel textLabel = new JLabel("apple");
    private JLabel imgLabel = new JLabel(images[0]);
    private JComboBox<String> strCombo = new JComboBox<String>(fruits);

    ComboActionEx() {
        this.setTitle("ComboBox Event");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.formDesign();
        this.eventHandler();
        this.setSize(300, 250);
        this.setVisible(true);
    }

    public void formDesign() {
        this.add(p);
        p.add(strCombo);
        p.add(imgLabel);
        p.add(textLabel);
    }

    public void eventHandler() {
        //이벤트 - 콤보박스(strCombo)
      /*  strCombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                strCombo = (JComboBox<String>) e.getSource();
                int index = strCombo.getSelectedIndex();
                imgLabel.setIcon(images[index]);
            }
        });
*/
        strCombo.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                int index = strCombo.getSelectedIndex();
                String text = (String) strCombo.getSelectedItem();
                imgLabel.setIcon(images[index]);
                textLabel.setText(text);
            }
        });
    }

    public static void main(String[] args) {
        new ComboActionEx();
    }
}
