package Project.src;

import javax.swing.*;
import java.awt.event.*;

public class InsertDAO extends JDialog {
    private JPanel contentPane;
    private RoundedButton buttonOK;
    private RoundedButton buttonCancel;
    private JTextField id_T;
    private JTextField name_T;
    private JTextField dept_T;
    private JLabel id_L;
    private JLabel name_L;
    private JLabel dept_L;
    private JLabel Title;
    private JLabel score_L;
    private JTextField score_T;
    private StudentDAO dao;

    public InsertDAO() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        dao = new StudentDAO();

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
                InsertDAO.this.setVisible(false);
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK()  {
        // add your code here
        if (dao.insert(id_T.getText(), name_T.getText(), dept_T.getText(), score_T.getText())) {
            StudentGUI studentGUI = new StudentGUI();
            studentGUI.output_T.setText("등록이 되었습니다.");
        } else {
            StudentGUI studentGUI = new StudentGUI();
            studentGUI.output_T.setText("등록하는데 오류가 발생했습니다.");
        }
        id_T.setText("");
        name_T.setText("");
        dept_T.setText("");
        score_T.setText("");
    }

    private void onCancel() {
        // add your code here if necessary
        StudentGUI studentGUI = new StudentGUI();
        studentGUI.setVisible(true);
        dispose();
    }

    public static void main(String[] args) {
        InsertDAO dialog = new InsertDAO();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
