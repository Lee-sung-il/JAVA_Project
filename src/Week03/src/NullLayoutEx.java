package Week03.src;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;

public class NullLayoutEx extends JFrame {
    private JButton btn = new JButton("OK");

    NullLayoutEx(){
        this.setTitle("Null Layout");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.formDesign();
        this.eventHandler();
        this.setSize(300,300);
        this.setVisible(true);
    }

    private void eventHandler() {
    }

    private void formDesign() {
        this.setLayout(null); //배치관리자 해지
        btn.setBounds(100, 100, 100, 30);
        this.add(btn);
        btn.setBackground(Color.RED);
        btn.setOpaque(true);
        btn.setBorderPainted(false);
        btn.setForeground(Color.yellow);



        // btn.setSize(100, 50);
        // btn.setLocation(100, 100);


    }
    public static void main(String[] args){
        new NullLayoutEx();
    }
}

