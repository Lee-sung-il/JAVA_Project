package Week06.src;

import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class CheckBoxItemEx extends JFrame implements ItemListener {
    private JPanel p = new JPanel();
    private JCheckBox[] fruits = new JCheckBox[3];
    private String[] name = {"사과", "배", "체리"};
    private JLabel sumLabel;
    private int sum = 0;

    CheckBoxItemEx() {
        this.setTitle("체크박스와 itemEvent 예제");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.formDesign();
        this.eventHandler();
        this.setSize(250, 200);
        this.setVisible(true);
    }

    public void formDesign() {
        this.add(p);
        p.add(new JLabel("사과 100원, 배 500원, 체리 20000원"));

        for (int i = 0; i < fruits.length; i++) {
            fruits[i] = new JCheckBox(name[i]);
            fruits[i].setBorderPainted(true);
            p.add(fruits[i]);
        }

        sumLabel = new JLabel("현재 0원 입니다.");
        p.add(sumLabel);

    }

    public void eventHandler() {
        //이벤트 소스
        for (int i = 0; i < fruits.length; i++) {
            fruits[i].addItemListener(this);
        }
    }

    public static void main(String[] args) {
        new CheckBoxItemEx();
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
            if (e.getItem() == fruits[0]) {
                sum += 100;

            } else if (e.getItem() == fruits[1]) {
                sum += 500;

            } else if (e.getItem() == fruits[2]) {
                sum += 20000;
            }
        } else {
            if (e.getItem() == fruits[0]) {
                sum -= 100;

            } else if (e.getItem() == fruits[1]) {
                sum -= 500;

            } else if (e.getItem() == fruits[2]) {
                sum -= 20000;
            }
        }
        sumLabel.setText("현재 " + sum + " 원입니다.");
    }
}
