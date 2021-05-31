package Week12.src;

import javax.swing.*;
import java.awt.*;

class DrawCanvas extends JPanel {
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponents(g); //캔버스 초기화
        g.setColor(Color.RED);
        g.drawLine(10, 10, 100, 100);

        g.drawOval(100, 100, 200, 100);
        g.drawRect(30, 300, 100, 100);
        g.drawRoundRect(30, 450, 100, 100, 30, 40);

        g.setColor(new Color(0x000000ff));
        g.fillRect(30, 500, 50, 50);
        g.drawArc(30, 300, 100, 100, 90, 270);
        int[] x = {80, 40, 80, 120};
        int[] y = {40, 120, 200, 120};
        g.drawPolygon(x, y, 4);
    }
}

public class DrawEx extends JFrame {
    DrawEx() {
        this.setTitle("Draw");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(new DrawCanvas());
        this.setSize(300, 800);
        this.setVisible(true);
    }


    public static void main(String[] args) {
        new DrawEx();
    }
}
