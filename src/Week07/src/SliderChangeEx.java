package Week07.src;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class SliderChangeEx extends JFrame {
    private JLabel colorLabel = new JLabel("        SLIDER EXAMPLE      ");
    private JPanel p = new JPanel();
    private JSlider[] sl = new JSlider[3];

    SliderChangeEx() {
        this.setTitle("슬라이더와 ChangeEvent 예제");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.formDesign();
        this.eventHandler();
        this.setSize(300, 230);
        this.setVisible(true);
    }

    public void formDesign() {
        this.add(p);

        for (int i = 0; i < sl.length; i++) {
            sl[i] = new JSlider(JSlider.HORIZONTAL, 0, 255, 128);

            sl[i].setPaintLabels(true);
            sl[i].setPaintTicks(true);
            sl[i].setPaintTrack(true);
            sl[i].setMajorTickSpacing(50);
            sl[i].setMinorTickSpacing(10);


            p.add(sl[i]);

        }
        sl[0].setForeground(Color.RED);
        sl[1].setForeground(Color.GREEN);
        sl[2].setForeground(Color.BLUE);
        p.add(colorLabel);
    }

    public void eventHandler() {
        for (int i = 0; i < sl.length; i++) {
            sl[i].addChangeListener(new MyChangeListener());
        }

    }

    class MyChangeListener implements ChangeListener {

        @Override
        public void stateChanged(ChangeEvent e) {
            int r = sl[0].getValue();
            int g = sl[1].getValue();
            int b = sl[2].getValue();
            colorLabel.setOpaque(true);
            colorLabel.setBackground(new Color(r, g, b));
        }
    }

    public static void main(String[] args) {
        new SliderChangeEx();
    }
}

/*
    GUI
    1) Form Design
        1 프레임 생성
        2 배치관리자 지정
        3 컨포넌트 배치

   2)Event 처리
        1 이벤트 소스 찾기
        2 귀를 달아주기
        3 이벤트 리스너 구현
        4 객체 생성

    3)이벤트 리스너 구현
        1) 익명 충첩 클래스
        2) 내부/외부 클래스
        3 프레임 자체 구현
        4) Adapter 클래스 구현
 */
