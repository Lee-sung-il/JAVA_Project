package Project.src;

import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class DeleteForm extends JDialog {
    private JPanel contentPane;
    private RoundedButton buttonOK;
    private RoundedButton buttonCancel;
    private JLabel Title;
    private JTextField id_T;
    private JLabel id_L;
    private StudentDAO dao;
    private static final String username = "java";
    private static final String password = "12345";
    private static final String dataconn = "jdbc:mysql://localhost/Student_JAVA?serverTimezone=UTC";

    Connection sqlconn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    ResultSetMetaData rsmd;

    public DeleteForm() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        dao = new StudentDAO();

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
                DeleteForm.this.setVisible(false);
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
        StudentGUI studentGUI = new StudentGUI();
        if (dao.delete(id_T.getText())) {
            studentGUI.output_T.setText("삭제 되었습니다.");
        }else {
            studentGUI.output_T.setText("삭제 실패했습니다.");
        }
    }

    private void onCancel() {
        // add your code here if necessary
        StudentGUI studentGUI = new StudentGUI();
        studentGUI.setVisible(true);
        DeleteForm.this.setVisible(false);
    }


    public static void main(String[] args) {
        DeleteForm dialog = new DeleteForm();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
