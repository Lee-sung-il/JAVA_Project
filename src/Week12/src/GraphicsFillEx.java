package Week12.src;

import javax.swing.*;
import java.awt.*;

public class GraphicsFillEx extends JFrame {
    GraphicsFillEx() {
        this.setTitle("fillXXX 사용예제");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.formDesign();
        this.eventHandler();
        this.add(new MyPanel());
        this.setSize(100, 500);
        this.setVisible(true);
    }

    class MyPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.RED);
            g.fillRect(10, 10, 50, 50);
            g.setColor(Color.BLUE);
            g.fillOval(10, 70, 50, 50);
            g.setColor(Color.GREEN);
            g.fillRoundRect(10, 130, 50, 50, 20, 20);
            g.setColor(Color.MAGENTA);
            g.fillArc(10, 190, 50, 50, 0, 270);
            g.setColor(Color.ORANGE);
            int[] x = {30, 10, 30, 60};
            int[] y = {250, 275, 300, 275};
            g.fillPolygon(x, y, 4);
            g.setColor(Color.RED);
            g.fillArc(10, 350, 50, 50, 90, 120);
            g.setColor(Color.BLUE);
            g.fillArc(10, 350, 50, 50, 210, 120);
            g.setColor(Color.YELLOW);
            g.fillArc(10, 350, 50, 50, 330, 120);

//            int xArea = 400, yArea = 400;
//
//            int xLine = xArea / 2, yLine = yArea / 2;
//
//            int xPoint = (xArea - xLine) / 2, yPoint = (yArea - yLine) / 2;
//
//            g.setColor(Color.blue);
//            g.fillOval(xPoint, yPoint, xLine, yLine);
//
//            g.setColor(Color.red);
//
//            g.fillArc(xPoint, yPoint, xLine, yLine, 180, -180);
//
//            g.setColor(Color.blue);
//
//            g.fillOval((xLine / 2) + xPoint, (yLine / 4) + yPoint, xLine / 2, yLine / 2);
//
//            g.setColor(Color.red);
//
//            g.fillOval(xPoint, (yLine / 4) + yPoint, xLine / 2, yLine / 2);
//            g.setColor(Color.blue);
//
//            g.fillOval(xPoint, yPoint, xLine, yLine);
//
//            g.setColor(Color.red);
//
//            g.fillArc(xPoint, yPoint, xLine, yLine, 135, -180);
//
//            g.setColor(Color.red);
//
//            g.fillOval(xPoint + (xLine / 13), yPoint + (yLine / 13), xLine / 2, yLine / 2);
//
//            g.setColor(Color.blue);
//
//            g.fillOval(xPoint + (xLine / 2) - (xLine / 13), yPoint + (yLine / 2) - (yLine / 13), xLine / 2, yLine / 2);
//
//            g.setColor(Color.blue);
//
//            g.fillOval(xPoint, yPoint, xLine, yLine);
//
//            g.setColor(Color.red);
//
//            g.fillArc(xPoint, yPoint, xLine, yLine, 148, -180);
//
//            g.setColor(Color.red);
//
//            g.fillOval(xPoint+(xLine/24), yPoint+(xLine/8), xLine/2, yLine/2);
//
//            g.setColor(Color.blue);
//
//            g.fillOval(xPoint+(xLine/2)-(xLine/24), yPoint+(yLine/2)-(xLine/8), xLine/2, yLine/2);

            g.setColor(Color.RED);
            g.fillArc(0,0,200,200,0,180);
            g.setColor(Color.BLUE);
            g.fillArc(0,0,200,200,180,180);
            g.setColor(Color.BLUE);
            g.fillArc(100,50,100,100,0,180);
            g.setColor(Color.RED);
            g.fillArc(0,50,100,100,180,180);

        }
    }

    public void formDesign() {
    }

    public void eventHandler() {
    }

    public static void main(String[] args) {
        new GraphicsFillEx();
    }
}
