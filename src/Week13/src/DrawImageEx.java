package Week13.src;

import javax.swing.*;
import java.awt.*;

// 캔버스 만들기
class MyImage extends JPanel {
    ImageIcon icon = new ImageIcon("images/img.jpg");
    Image img = icon.getImage();

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g); //캔버스 초기화
//        g.drawImage(img, 0, 0, this);
//        g.drawImage(img, 20, 20, this.getWidth(), this.getHeight(), this);
        //원본(50,130) 에서 (400,300)의 영역 패널상 (20,20)에서 (400, 300)
        g.drawImage(img, 20, 20, 400, 300, 50, 130, 400, 300, this);
    }
}

public class DrawImageEx extends JFrame {
    DrawImageEx() {
        this.setTitle("Image Draw");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.formDesign();
        this.eventHandler();
        this.add(new MyImage());
        this.setSize(680, 540);
        this.setVisible(true);
    }

    public void formDesign() {
    }

    public void eventHandler() {
    }

    public static void main(String[] args) {
        new DrawImageEx();
    }
}
