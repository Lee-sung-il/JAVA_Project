package Week12.src;

import javax.swing.*;
import java.awt.*;

public class PaintJPanelEx extends JFrame {
    private MyPanel panel = new MyPanel();
    PaintJPanelEx() {
        this.setTitle("JPanel의 PaintCompent()예제");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(panel);
        this.setSize(250, 220);
        this.setVisible(true);
    }

    class MyPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.BLUE);
            g.drawRect(10, 10, 50, 50);
            g.drawRect(50, 50, 50, 50);
            g.setColor(Color.MAGENTA);
            g.drawRect(90, 90, 50, 50);
        }
    }


    public static void main(String[] args) {
        new PaintJPanelEx();
    }
}
