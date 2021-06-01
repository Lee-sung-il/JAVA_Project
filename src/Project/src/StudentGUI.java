package Project.src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class StudentGUI extends JFrame implements ActionListener {
    private InsertForm insertForm = new InsertForm();
    private UpdateForm updateForm = new UpdateForm();
    private DeleteForm deleteForm = new DeleteForm();
    private Exit exit = new Exit(this, "종료");
    private InquireForm inquireForm = new InquireForm(this, "테이블 조회");
    public JTextArea output_T;
    private RoundedButton regist, update, delete, exitBtn, InquireBtn, longOut;
    private JPanel side_P, input_P, south_P;
    private ArrayList<Student> al;
    private StudentDAO dao;

    StudentGUI() {
        this.setTitle("학생관리프로그램 관리자 모드");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.formDesign();
        this.eventHandler();
        this.setLocation(300, 500);
        this.setSize(1000, 230);
        this.setVisible(true);
        dao = new StudentDAO();
        al = new ArrayList<Student>();
    }

    public void formDesign() {
        side_P = new JPanel();
        input_P = new JPanel();
        south_P = new JPanel();
        output_T = new JTextArea();

        regist = new RoundedButton("등록");
        update = new RoundedButton("수정");
        delete = new RoundedButton("삭제");
        exitBtn = new RoundedButton("종료");
        InquireBtn = new RoundedButton("테이블 조회");


        this.add(side_P, BorderLayout.WEST);
        side_P.setLayout(new GridLayout(2, 1));
        side_P.add(input_P);
        input_P.setLayout(new GridLayout(3, 2));

        this.add(output_T, BorderLayout.CENTER);
        this.add(south_P, BorderLayout.SOUTH);
        south_P.add(regist);
        south_P.add(InquireBtn);
        south_P.add(update);
        south_P.add(delete);
        south_P.add(exitBtn);


    }

    public void eventHandler() {

        regist.addActionListener(this);
        update.addActionListener(this);
        delete.addActionListener(this);
        exitBtn.addActionListener(this);
        InquireBtn.addActionListener(this);
    }

    public static void main(String[] args) {
//        new StudentGUI();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("등록")) {
            this.setVisible(false);
            insertForm.setSize(300, 300);
            insertForm.setVisible(true);
        } else if (e.getActionCommand().equals("수정")) {
            this.setVisible(false);
            updateForm.setSize(300, 300);
            updateForm.setVisible(true);
        } else if (e.getActionCommand().equals("삭제")) {
            this.setVisible(false);
            deleteForm.setSize(300, 300);
            deleteForm.setVisible(true);
        } else if (e.getActionCommand().equals("테이블 조회")) {
            inquireForm.table.setAutoCreateRowSorter(true);
            dao.tableInquire(inquireForm.table);
            inquireForm.setSize(600, 300);
            inquireForm.setVisible(true);
        } else if (e.getActionCommand().equals("종료")) {
            this.setVisible(false);
            exit.setSize(300, 300);
            exit.setVisible(true);
        }
    }
}


