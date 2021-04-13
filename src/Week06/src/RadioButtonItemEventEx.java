package Week06.src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class RadioButtonItemEventEx extends JFrame {
    private JPanel p = new JPanel();
    private JRadioButton[] radio = new JRadioButton[3];
    private String[] text = {"사과", "배", "체리"};
    private ImageIcon[] image = {
            new ImageIcon("images/apple.jpg"),
            new ImageIcon("images/pear.jpg"),
            new ImageIcon("images/cherry.jpg")
    };
    private JLabel imageLabel = new JLabel("AAA");

    RadioButtonItemEventEx() {
        this.setTitle("라디오버튼 Item 이벤트 예제");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.formDesign();
        this.eventHandler();
        this.setSize(250, 200);
        this.setVisible(true);
    }

    public void formDesign() {
        ButtonGroup g = new ButtonGroup();
        p.setBackground(Color.gray);
        this.add(p, BorderLayout.NORTH);
        for (int i = 0; i < radio.length; i++) {
            radio[i] = new JRadioButton(text[i]);
            g.add(radio[i]);
            p.add(radio[i]);
        }

        this.add(imageLabel, BorderLayout.CENTER);
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
    }

    public void eventHandler() {
        for (int i = 0; i < radio.length; i++) {
            radio[i].addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent e) {
                    if (e.getStateChange() == ItemEvent.DESELECTED) {
                        return;
                    }
                    if (radio[0].isSelected()) {
                        imageLabel.setIcon(image[0]);
                    } else if (radio[1].isSelected()) {
                        imageLabel.setIcon(image[1]);
                    } else if (radio[2].isSelected()) {
                        imageLabel.setIcon(image[2]);
                    }
                }
            });
        }
    }

    public static void main(String[] args) {
        new RadioButtonItemEventEx();
    }

}
