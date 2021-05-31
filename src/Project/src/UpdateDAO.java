package Project.src;

import javax.swing.*;
import java.awt.event.*;

public class UpdateDAO extends JDialog {
    private JPanel contentPane;
    private RoundedButton buttonOK;
    private RoundedButton buttonCancel;
    private JLabel Title;
    private JTextField id_T;
    private JTextField name_T;
    private JTextField dept_T;
    private JLabel id_L;
    private JLabel name_L;
    private JLabel dept_L;
    private JLabel score_L;
    private JTextField score_T;
    private StudentDAO dao;

    public UpdateDAO() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        dao = new StudentDAO();



        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
                UpdateDAO.this.setVisible(false);
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

    private void onOK() {
        // add your code here
        if (dao.update(id_T.getText(), name_T.getText(), dept_T.getText(),score_T.getText())) {
            StudentGUI studentGUI = new StudentGUI();
               studentGUI.output_T.setText("수정 되었습니다.");
        }else {
            StudentGUI studentGUI = new StudentGUI();
            studentGUI.output_T.setText("수정 실패했습니다.");
        }
    }

    private void onCancel() {
        // add your code here if necessary
        StudentGUI studentGUI = new StudentGUI();
        studentGUI.setVisible(true);
        dispose();
    }

    public static void main(String[] args) {
        UpdateDAO dialog = new UpdateDAO();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }

}
