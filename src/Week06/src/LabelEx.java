package Week06.src;

import javax.swing.*;

public class LabelEx extends JFrame {
    private JPanel p = new JPanel();
    private JLabel textLabel, imageLabel, label;
    LabelEx() {
        this.setTitle("레이블 예제");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.formDesign();
        this.eventHandler();
        this.setSize(400,600);
        this.setVisible(true);
    }

    public void formDesign() {
        textLabel = new JLabel("사랑합니다.");
        ImageIcon beauty = new ImageIcon("images/beauty.jpg");
        imageLabel = new JLabel(beauty);
        ImageIcon normalIcon = new ImageIcon("images/normalIcon.gif");
        label = new JLabel("보고싶으면 전화하세요",normalIcon, SwingConstants.CENTER);
        this.add(p);
        p.add(textLabel);
        p.add(imageLabel);
        p.add(label);
    }

    public void eventHandler() {
    }

    public static void main(String[] args) {
        new LabelEx();
    }
}
