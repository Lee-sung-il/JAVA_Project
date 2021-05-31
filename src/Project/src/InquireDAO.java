package Project.src;


import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.*;


public class InquireDAO extends JDialog {

    String[] colName = {"학번", "이름", "학과", "성적", "학점"};
    String[] combo = {"선택","학번", "이름", "학과", "성적"};
    DefaultTableModel model = new DefaultTableModel(colName, 0) {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    public JTable table = new JTable(model);
    private JComboBox<String> comboBox = new JComboBox<String>(combo);
    private RoundedButton exitBtn = new RoundedButton("종료");
    private RoundedButton searchBtn = new RoundedButton("검색");
    private RoundedButton resetBtn = new RoundedButton("초기화");
    private RoundedButton ShortBtn = new RoundedButton("테이블 자체 정렬");
    private RoundedButton scoreSortBtn = new RoundedButton("성적 순으로 정렬");
    private RoundedButton nameSortBtn = new RoundedButton("이름 순으로 정렬");
    private JPanel side_P, input_P, south_P;
    private JScrollPane jScrollPane = new JScrollPane(table);
    private JTextField textField = new JTextField(20);
    private StudentDAO dao;

    public InquireDAO(JFrame frame, String title) {
        super(frame, title);
        this.dialogDesign();
        this.dialogEvent();
        this.setSize(200, 100);
        dao = new StudentDAO();
    }

    public void dialogDesign() {
        south_P = new JPanel();
        side_P = new JPanel();
        this.add(side_P, BorderLayout.NORTH);
        side_P.add(comboBox);
        side_P.add(textField);
        side_P.add(searchBtn);
        side_P.add(resetBtn);

//        table.getTableHeader().setReorderingAllowed(false); // 컬럼들 이동 불가
//        table.getTableHeader().setResizingAllowed(false); // 컬럼 크기 조절 불가

        this.add(jScrollPane, BorderLayout.CENTER);
        this.add(south_P, BorderLayout.SOUTH);
        south_P.add(ShortBtn);
        south_P.add(nameSortBtn);
        south_P.add(scoreSortBtn);
        south_P.add(exitBtn);

    }

    public void dialogEvent() {
        exitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InquireDAO.this.setVisible(false);
            }
        });


        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (comboBox.getItemAt(comboBox.getSelectedIndex()).toString().equals("선택")) {
                    JOptionPane.showMessageDialog(null,"다른 값을 선택하세요");
                    return;
                }

                searchBtn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        dao.searchDAO(table,textField,comboBox.getItemAt(comboBox.getSelectedIndex()).toString());
                    }
                });
                textField.setText("");
            }
        });



        searchBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText("");
            }
        });

        ShortBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                table.setAutoCreateRowSorter(true);
            }
        });


        resetBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                table.setRowSorter(null);
                dao.ResetDAO(table);
            }
        });
        nameSortBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                table.setAutoCreateRowSorter(false);
                table.setRowSorter(null);
                dao.tableNameSort(table);
            }
        });
        scoreSortBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                table.setRowSorter(null);
                dao.tableScoreSort(table);
            }
        });


    }

}

