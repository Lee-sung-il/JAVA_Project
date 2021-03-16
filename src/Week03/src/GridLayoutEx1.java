package Week03.src;

import javax.swing.*;
import java.awt.*;

public class GridLayoutEx1 extends JFrame {
    private JLabel name = new JLabel("이름");
    private JLabel student_ID = new JLabel("학번");
    private JLabel department = new JLabel("학과");
    private JLabel subject = new JLabel("과목");
    private JTextField field_name = new JTextField("");
    private JTextField field_student_ID = new JTextField("");
    private JTextField field_department = new JTextField("");
    private JTextField field_subject = new JTextField("");
    GridLayoutEx1() {
        this.setTitle("GridLayout Sample");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.formDesign();
        this.eventHandler();
        this.setSize(300,200);
        this.setVisible(true);
    }

    private void formDesign() {
        this.setLayout(new GridLayout(4, 2,5,5));
        this.add(name);
        this.add(field_name);
        this.add(student_ID);
        this.add(field_student_ID);
        this.add(department);
        this.add(field_department);
        this.add(subject);
        this.add(field_subject);


    }

    private void eventHandler() {
    }

    public static void main(String[] args) {
        new GridLayoutEx1();
    }
}
