package Week07.src;

import javax.swing.*;

public class SliderEx extends JFrame {
    private JPanel p = new JPanel();
    private JSlider sl = new JSlider(JSlider.HORIZONTAL, 0,200,100);
    SliderEx() {
        this.setTitle("Slider");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.formDesign();
        this.eventHandler();
        this.setSize(300,100);
        this.setVisible(true);
    }

    public void formDesign() {
        this.add(p);
        sl.setPaintLabels(true);
        sl.setPaintTrack(true);
        sl.setPaintTicks(true);
        sl.setMajorTickSpacing(50);
        sl.setMajorTickSpacing(10);
        p.add(sl);
    }

    public void eventHandler() {
    }

    public static void main(String[] args) {
        new SliderEx();
    }
}
