package Week05.src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseEventEx2 extends JFrame implements MouseListener, MouseMotionListener {
    private JPanel p = new JPanel();
    private JLabel la = new JLabel("No Mouse Event");

    MouseEventEx2() {
        this.setTitle("MouseEvent");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.formDesign();
        this.eventHandler();
        this.setSize(300, 200);
        this.setVisible(true);
    }

    public void formDesign() {
        this.add(p);
        p.add(la);
    }

    public void eventHandler() {
        p.addMouseListener(this);
        p.addMouseMotionListener(this);
    }

    public static void main(String[] args) {
        new MouseEventEx2();
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        la.setText("MousePressed(" + e.getX()+"," +e.getY() +")");
        System.out.println("MousePressed");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        la.setText("MouseReleased(" + e.getX()+"," +e.getY() +")");
        System.out.println("MouseReleased");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        p.setBackground(Color.YELLOW);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        p.setBackground(Color.GREEN);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        la.setText("MouseDragged(" + e.getX()+"," +e.getY() +")");
        System.out.println("MouseDragged");
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        la.setText("MouseMoved(" + e.getX()+"," +e.getY() +")");
        System.out.println("MouseMoved");
    }
}
