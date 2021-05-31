package Week13.src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.Vector;

// 캔버스 만들기
class MyDrawLine extends JPanel {
    //시작점과 끝점을 저장할 벡터 준비
    Vector<Point> vStart = new Vector<>();
    Vector<Point> vEnd = new Vector<>();

    MyDrawLine() {
        // 마우스를 누를때 이벤트 발생
        this.addMouseListener(new MouseAdapter() {
            // 마우스를 누를때 시작점이 저장
            @Override
            public void mousePressed(MouseEvent e) {
                Point startP = e.getPoint();
                vStart.add(startP);
            }

            // 마우스를 뗄때 끝점이 저장
            @Override
            public void mouseReleased(MouseEvent e) {
                Point endP = e.getPoint();
                vEnd.add(endP);

                //패널에 다시 그리기를 요청
                repaint();
            }
        });

        this.addMouseMotionListener(new MouseMotionListener() {
            // 곡선은 점들간의 연결인데, 끝점이 다음 시작점이 된다.
            @Override
            public void mouseDragged(MouseEvent e) {
                Point endP = e.getPoint();
                vEnd.addElement(endP);

                int sx = (int) vStart.lastElement().getX();
                int sy = (int) vStart.lastElement().getY();
                int ex = (int) vEnd.lastElement().getX();
                int ey = (int) vEnd.lastElement().getY();

                //현재 그리고 있는 선을 그린다.
                MyDrawLine.this.getGraphics().drawLine(sx, sy, ex, ey);
                vStart.add(endP);
            }

            @Override
            public void mouseMoved(MouseEvent e) {

            }
        });

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        //그리기
        g.setColor(Color.BLUE);
        for (int i = 0; i < vStart.size(); i++) {
            Point s = vStart.elementAt(i);
            Point e = vEnd.elementAt(i);

            //시작점과 끝점에 대한 선을 그리다.
            g.drawLine((int) s.getX(), (int) s.getY(), (int) e.getX(), (int) e.getY());
        }
    }

}

public class DrawLineEx extends JFrame {
    DrawLineEx() {
        this.setTitle("Draw Line");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.formDesign();
        this.eventHandler();
        this.add(new MyDrawLine());
        this.setSize(300, 300);
        this.setVisible(true);
    }

    public void formDesign() {
    }

    public void eventHandler() {
    }

    public static void main(String[] args) {
        new DrawLineEx();
    }
}
