package Week07.src;

import javax.swing.*;

public class ListEx extends JFrame {
    private JPanel p = new JPanel();
    private JList<String> strList, scrollList;
    private JList<ImageIcon> imageList;
    private String[] fruits = {"apple", "banana", "kiwi", "mango",
            "pear", "peach", "berry", "strawberry", "blackberry"};
    private ImageIcon[] images = {new ImageIcon("images/icon1.png"),
            new ImageIcon("images/icon2.png"), new ImageIcon("images/icon3.png"),
            new ImageIcon("images/icon4.png")};

    ListEx() {
        this.setTitle("ListEx");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.formDesign();
        this.eventHandler();
        this.setSize(300, 300);
        this.setVisible(true);
    }

    public void formDesign() {
        this.add(p);
        strList = new JList<String>(fruits);
        imageList = new JList<ImageIcon>(images);
        scrollList = new JList<String >(fruits);
        p.add(strList);
        p.add(imageList);
        p.add(new JScrollPane(scrollList));
    }

    public void eventHandler() {
    }

    public static void main(String[] args) {
        new ListEx();
    }
}
