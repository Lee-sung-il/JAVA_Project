package Week07.src;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class ListEventEx extends JFrame {
    private JPanel p = new JPanel();
    private JTextField tf = new JTextField(10);
    private Vector<String > v = new Vector<String>();
    private JList<String > nameList = new JList<String>(v);
    private JLabel la = new JLabel("List");
    ListEventEx() {
        this.setTitle("ListEventEx");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.formDesign();
        this.eventHandler();
        this.setSize(300,300);
        this.setVisible(true);
    }

    public void formDesign() {
        this.add(p);
        p.add(new JLabel("이름 입력후 <Enter> 키"));
        p.add(tf);
        v.add("Kim");
        v.add("Lee");
        nameList.setVisibleRowCount(5);
        nameList.setFixedCellWidth(100);
        p.add(new JScrollPane(nameList));
        p.add(la);
    }

    public void eventHandler() {
        //이벤트 소스 -tf
        tf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                v.addElement(tf.getText());
                tf.setText("");
                nameList.setListData(v);
            }
        });
        //이벤트 소스 -nameList
        //이벤트 - listSelectionListener
        nameList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                String text = nameList.getSelectedValue();
               la.setText(text);
            }
        });
    }

    public static void main(String[] args) {
        new ListEventEx();
    }
}
