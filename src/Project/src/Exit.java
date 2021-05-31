package Project.src;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


class MyImage extends JPanel {
    ImageIcon icon = new ImageIcon("images/ByeBye.jpg");
    Image img = icon.getImage();

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g); //캔버스 초기화
//        g.drawImage(img, 0, 0, this);
        g.drawImage(img, 20, 20, this.getWidth(), this.getHeight(), this);
        //원본(50,130) 에서 (400,300)의 영역 패널상 (20,20)에서 (400, 300)
//        g.drawImage(img, 20, 20, 400, 300, 50, 130, 400, 300, this);
    }
}
public class Exit extends JDialog {


    private JLabel Title = new JLabel("정말 종료하시겠습니까?");
    private RoundedButton exitBtn = new RoundedButton("종료");
    private RoundedButton CancelBtn = new RoundedButton("취소");
    private JPanel side_P, input_P, south_P;
//    private ImageIcon icon = new ImageIcon("images/ByeBye.jpg");
//    private JLabel imgIcon = new JLabel(icon);


    public Exit(JFrame frame, String title) {
        super(frame, title);
        this.dialogDesign();
        this.dialogEvent();
        this.setSize(200, 100);

    }

    public void dialogDesign() {
        south_P = new JPanel();
        side_P = new JPanel();
        this.add(side_P, BorderLayout.NORTH);
        side_P.add(Title);

        this.add(new MyImage(), BorderLayout.CENTER);
        this.add(south_P, BorderLayout.SOUTH);
        south_P.add(exitBtn);
        south_P.add(CancelBtn);

    }

    public void dialogEvent() {
        exitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        CancelBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StudentGUI studentGUI = new StudentGUI();
                Exit.this.setVisible(false);
            }
        });
    }
    

}

