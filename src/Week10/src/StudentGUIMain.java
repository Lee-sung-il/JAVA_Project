package Week10.src;

import Week10.src.Student;
import Week10.src.StudentDAO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;

public class StudentGUIMain extends JFrame implements FocusListener, ActionListener {
    private JLabel id_L, name_L, score_L;
    private JTextField id_T, name_T, score_T;
    private JTextArea output_T;
    private JButton regist, view, update, delete, exit,score_sort,name_sort;
    private JPanel side_P, input_P, south_P;
    private StudentDAO dao;
    private ArrayList<Student> al;

    StudentGUIMain() {
        this.setTitle("학생관리프로그램");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.formDesign();
        this.eventHandler();
        this.setSize(600, 230);
        this.setVisible(true);

        dao = new StudentDAO();
        al = new ArrayList<Student>();
    }

    public void formDesign() {
        side_P = new JPanel();
        input_P = new JPanel();
        south_P = new JPanel();

        id_L = new JLabel("ID:");
        name_L = new JLabel("이름:");
        score_L = new JLabel("성적:");

        id_T = new JTextField();
        name_T = new JTextField();
        score_T = new JTextField();

        output_T = new JTextArea("AAA");

        regist = new JButton("등록");
        view = new JButton("조회");
        update = new JButton("수정");
        delete = new JButton("삭제");
        exit = new JButton("종료");
        score_sort = new JButton("성적순 정렬");
        name_sort = new JButton("이름순 정렬");

        this.add(side_P, BorderLayout.WEST);
        side_P.setLayout(new GridLayout(2, 1));
        side_P.add(input_P);
        input_P.setLayout(new GridLayout(3, 2));
        input_P.add(id_L);
        input_P.add(id_T);
        input_P.add(name_L);
        input_P.add(name_T);
        input_P.add(score_L);
        input_P.add(score_T);

        this.add(output_T, BorderLayout.CENTER);
        this.add(south_P, BorderLayout.SOUTH);
        south_P.add(regist);
        south_P.add(view);
        south_P.add(update);
        south_P.add(delete);
        south_P.add(score_sort);
        south_P.add(name_sort);
        south_P.add(exit);

        name_T.setEditable(false);
        score_T.setEditable(false);

        regist.setEnabled(false);
        view.setEnabled(false);
    }

    public void eventHandler() {
        id_T.addFocusListener(this);
        name_T.addFocusListener(this);
        score_T.addFocusListener(this);

        regist.addActionListener(this);
        view.addActionListener(this);
        update.addActionListener(this);
        delete.addActionListener(this);
        exit.addActionListener(this);
        score_sort.addActionListener(this);
        name_sort.addActionListener(this);
    }

    public static void main(String[] args) {
        new StudentGUIMain();
    }

    @Override
    public void focusGained(FocusEvent e) {
        if (e.getSource().equals(id_T)) {
            output_T.setText("ID를 입력해주세요" + '\n');
        } else if (e.getSource().equals(name_T)) {
            output_T.setText("이름을 입력해주세요" + '\n');
        } else if (e.getSource().equals(score_T)) {
            output_T.setText("성적를 입력해주세요" + '\n');
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        if (e.getSource().equals(id_T)) {
            if (id_T.getText() == "") {
                output_T.setText("ID가 없습니다.");
            } else {
                name_T.setEditable(true);
            }
        } else if (e.getSource().equals(name_T)) {
            if (name_T.getText() == "") {
                output_T.setText("이름이 없습니다.");
            } else {
                score_T.setEditable(true);
            }
        } else if (e.getSource().equals(score_T)) {
            if (score_T.getText() == "") {
                output_T.setText("성적이 없습니다.");
            } else {
                regist.setEnabled(true);
                regist.requestFocus();
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("등록")) {
            if (dao.insert(id_T.getText(), name_T.getText(), Integer.parseInt(score_T.getText()))) {
                output_T.setText("등록이 되었습니다.");
            } else {
                output_T.setText("같은 ID가 존재합니다.");
            }
            id_T.setText("");
            name_T.setText("");
            score_T.setText("");
            view.setEnabled(true);
        } else if (e.getActionCommand().equals("조회")) {
            output_T.setText(dao.inquire());
        } else if (e.getActionCommand().equals("종료")) {
            System.exit(0);
        } else if (e.getActionCommand().equals("수정")) {
        if (dao.update(id_T.getText(),name_T.getText(),Integer.parseInt(score_T.getText()))) {
            output_T.setText("수정 되었습니다.");
            }
        } else if (e.getActionCommand().equals("삭제")) {
            if (dao.delete(id_T.getText())){
                output_T.setText("삭제 되었습니다.");
            }
        }else if (e.getActionCommand().equals("성적순 정렬")) {
            if (dao.scoreSort()) {
                output_T.setText("성적순으로 정렬되었습니다.");
            }
        }else if (e.getActionCommand().equals("이름순 정렬")) {
            if (dao.nameSort()) {
                output_T.setText("이름순으로 정렬되었습니다.");
            }
        }

    }
}
