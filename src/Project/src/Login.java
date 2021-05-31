package Project.src;

import javax.swing.*;
import java.awt.event.*;

public class Login extends JDialog {
    private JPanel contentPane;
    private RoundedButton login;
    private RoundedButton Cancel;
    private JTextField id_T;
    private JPasswordField password_T;
    private JLabel loginForm;
    private JLabel id;
    private StudentDAO dao;
    private StudentGUI studentGUI;

    public Login() {
//        this.setAlwaysOnTop(true);
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(login);
        dao = new StudentDAO();

        login.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        Cancel.addActionListener(new ActionListener() {
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
        if(dao.login(id_T.getText(),password_T.getPassword())) {
            System.out.println("로그인에 성공했습니다.");
            Login.this.setVisible(false);
            studentGUI = new StudentGUI();


        }else {
            id_T.setText("");
            password_T.setText("");
            System.out.println("로그인에 실패 했습니다.");
        }

    }

    private void onCancel() {
        // add your code here if necessary
        Login.this.setVisible(false);
    }

    public static void main(String[] args) {
        Login dialog = new Login();
        dialog.pack();
        dialog.setVisible(true);
//        System.exit(0);
    }


}
