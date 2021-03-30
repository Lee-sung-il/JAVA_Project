package Week05.src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyListenerEx extends JFrame {
    private JLabel[] keyMessage;
    private JPanel p = new JPanel();

    public KeyListenerEx() {
        this.setTitle("KeyListener");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.formDesign();
        this.eventHandler();
        this.setSize(350, 150);
        this.setVisible(true);

        p.setFocusable(true);
        p.requestFocus();
    }

    public void formDesign() {
        this.add(p);
        keyMessage = new JLabel[3];

        keyMessage[0] = new JLabel("  getKeyCode()  ");
        keyMessage[1] = new JLabel("  getKeyChar()  ");
        keyMessage[2] = new JLabel("  getKeyText()  ");

        for (int i = 0; i < 3; i++) {
            p.add(keyMessage[i]);
            keyMessage[i].setOpaque(true);
            keyMessage[i].setBackground(Color.YELLOW);
        }
    }

    public void eventHandler() {
        p.addKeyListener(new MyKeyListener());
    }

    public static void main(String[] args) {
        new KeyListenerEx();
    }

    class MyKeyListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();
            char keyChar = e.getKeyChar();
            keyMessage[0].setText(Integer.toString(keyCode));
            keyMessage[1].setText(Character.toString(keyChar));
            keyMessage[2].setText(KeyEvent.getKeyText(keyCode));

            System.out.println("KeyPressed");
        }

        @Override
        public void keyReleased(KeyEvent e) {
            System.out.println("keyReleased");
        }

        @Override
        public void keyTyped(KeyEvent e) {
            System.out.println("keyTyped");
        }
    }
}
