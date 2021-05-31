package Week12.src;

import javax.swing.*;
import java.awt.*;

public class GraphicsColorFontEx extends JFrame {
    GraphicsColorFontEx() {
        this.setTitle("Color, Font 사용예제");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(new MyPanel());
        this.setSize(350, 470);
        this.setVisible(true);
    }

    class MyPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.BLUE);
            g.drawString("I LOVE JAVA ~~", 30, 30);
            g.setColor(new Color(255, 0, 0));
            g.setFont(new Font("Arial", Font.ITALIC, 30));
            g.drawString("How Much ?", 30, 60);
            g.setColor(new Color(0x00ff00ff));
            for (int i = 1; i <= 5; i++) {
                g.setFont(new Font("Jokerman", Font.ITALIC, i * 10));
                g.drawString("this much!!", 30, 60 + i * 60);
            }

        }
    }

    public static void main(String[] args) {
        new GraphicsColorFontEx();
    }
}
