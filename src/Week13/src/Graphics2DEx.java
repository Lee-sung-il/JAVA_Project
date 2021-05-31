package Week13.src;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;

class Draw2D extends JPanel {
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        double x = 50;
        for (int i = 0; i < 16; i++) {
            Line2D line = new Line2D.Double(x, 50, x, 200);

            Stroke st = new BasicStroke(i);
            g2.setStroke(st);
            g2.draw(line);
            x = x + 50;
        }
    }
}

public class Graphics2DEx extends JFrame {
    Graphics2DEx() {
        this.setTitle("2D Graphics");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.formDesign();
        this.eventHandler();
        this.add(new Draw2D());
        this.setSize(830, 300);
        this.setVisible(true);
    }

    public void formDesign() {
    }

    public void eventHandler() {
    }

    public static void main(String[] args) {
        new Graphics2DEx();
    }
}
