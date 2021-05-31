package Week13.src;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;

class MyPanel1 extends JPanel {
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        //안티엘라어징
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        //도형의 두께 설정
        g2.setStroke(new BasicStroke(3));

        // (0,0)에서 흰색, (0,70) 에서 빨간색
        GradientPaint gp = new GradientPaint(0, 10, Color.WHITE, 0, 70, Color.RED);
        g2.setColor(Color.RED);
        g2.setPaint(gp);
        g2.fill(new Rectangle2D.Float(10, 10, 70, 80));

        g2.setPaint(gp);
        g2.fill(new RoundRectangle2D.Float(110,10,80,70,20,20));
    }
}

public class GradientEx extends JFrame {
    GradientEx() {
        this.setTitle("Gradient");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.formDesign();
        this.eventHandler();
        this.add(new MyPanel1());
        this.setSize(600, 130);
        this.setVisible(true);
    }

    public void formDesign() {
    }

    public void eventHandler() {
    }

    public static void main(String[] args) {
        new GradientEx();
    }
}
