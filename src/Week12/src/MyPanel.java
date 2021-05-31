package Week12.src;

import javax.swing.*;
import java.awt.*;

// 캔버스 만들기
class MyCanvas extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // 패널네에 이전에 그려지 진상을 지우기 위해 호출

        g.setColor(Color.RED); // 붓의 색상을 지정
        g.drawRect(10, 10, 50, 50);
        g.setColor(Color.BLUE);
        g.drawRect(100, 100, 100, 100);

        g.drawString("자바는 재미 있다.",30,30);
        g.drawString("얼마나? 하늘만큼 땅만큼",60,60);

    }
}

public class MyPanel extends JFrame {
    MyPanel() {
        this.setTitle("Graphics");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //캔버스 붙이기
        this.add(new MyCanvas());
        this.setSize(300, 300);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new MyPanel();
    }
}
