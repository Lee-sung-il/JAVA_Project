package Project.src;

import com.mysql.cj.util.StringUtils;
import javafx.scene.input.InputMethodTextRun;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class StudentDAO extends JFrame {
    private Scanner scan;
    private ArrayList<Student> al;
    private ArrayList<UserVo> userVo;

    private String id;
    private String name;
    private String dept;
    private int score;

    private static final String username = "java";
    private static final String password = "12345";
    private static final String dataconn = "jdbc:mysql://localhost/Student_JAVA?serverTimezone=UTC";

    Connection sqlconn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;


    public StudentDAO() {
        scan = new Scanner(System.in);
        al = new ArrayList<Student>();
        userVo = new ArrayList<UserVo>();
    }


    public boolean insert(String id, String name, String dept, String score) {
        Student stu = null;
        ArrayList<Student> arrayList;
        if (id.equals("")) {
            JOptionPane.showMessageDialog(this, "학번을 입력하세요");
            return false;
        } else if (name.equals("")) {
            JOptionPane.showMessageDialog(this, "이름을 입력하세요");
            return false;
        } else if (dept.equals("")) {
            JOptionPane.showMessageDialog(this, "학과를 입력하세요");
            return false;
        } else if (score.equals("")) {
            JOptionPane.showMessageDialog(this, "성적을 입력하세요");
            return false;
        }
        try {
            Class.forName("com.mysql.jdbc.Driver");
            sqlconn = DriverManager.getConnection(dataconn, username, password);
            pst = sqlconn.prepareStatement("select * from Student");
            rs = pst.executeQuery();
            while (rs.next()) {
                stu = new Student();
                stu.setId(rs.getString("ID"));
                stu.setName(rs.getString("NAME"));
                stu.setDept(rs.getString("DEPT"));
                stu.setScore(rs.getInt("SCORE"));
            }
            if (id.equals(stu.getId())) {
                JOptionPane.showMessageDialog(this, "중복 등록되었습니다.");
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (Integer.parseInt(String.valueOf(score)) <= 100 && Integer.parseInt(String.valueOf(score)) >= 0) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                sqlconn = DriverManager.getConnection(dataconn, username, password);
                pst = sqlconn.prepareStatement("insert into Student(id, name, dept, score) values (?,?,?,?)");
                pst.setString(1, id);
                pst.setString(2, name);
                pst.setString(3, dept);
                pst.setInt(4, Integer.parseInt(score));
                pst.executeUpdate();
                JOptionPane.showMessageDialog(this, "등록되었습니다.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(this, "1에서 100까지 입력해주세요");
            return false;
        }
        return true;
    }


    public boolean update(String id, String name, String dept, String score) {
        Student stu = new Student();
        ArrayList<Student> arrayList;
        boolean result = false;
        if (id.equals("")) {
            JOptionPane.showMessageDialog(this, "학번을 입력하세요");
            return false;
        } else if (name.equals("")) {
            JOptionPane.showMessageDialog(this, "이름을 입력하세요");
            return false;
        } else if (dept.equals("")) {
            JOptionPane.showMessageDialog(this, "학과를 입력하세요");
            return false;
        } else if (score.equals("")) {
            JOptionPane.showMessageDialog(this, "성적을 입력하세요");
            return false;
        }
        try {
            Class.forName("com.mysql.jdbc.Driver");
            sqlconn = DriverManager.getConnection(dataconn, username, password);
            pst = sqlconn.prepareStatement("select * from Student");
            rs = pst.executeQuery();
            while (rs.next()) {
                stu.setId(rs.getString(2));
            }
            if (!stu.getId().equals(id)) {
                JOptionPane.showMessageDialog(this, "수정에 실패 했습니다.");
                result = false;
            } else if (id.equals("1")) {
                JOptionPane.showMessageDialog(this, "관리자는 수정 할수 없습니다.");
                result = false;
            } else {
                JOptionPane.showMessageDialog(this, "수정되었습니다.");
                result = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (Integer.parseInt(String.valueOf(score)) <= 100 && Integer.parseInt(String.valueOf(score)) >= 0) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                sqlconn = DriverManager.getConnection(dataconn, username, password);
                pst = sqlconn.prepareStatement("update Student SET NAME = ?, DEPT = ? , SCORE = ? WHERE ID = ? AND ID <> '1'");
                pst.setString(1, name);
                pst.setString(2, dept);
                pst.setInt(3, Integer.parseInt(String.valueOf(Integer.parseInt(score))));
                pst.setString(4, id);
                pst.executeUpdate();


            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(this, "1에서 100까지 입력해주세요");
            result = false;
        }
        return result;
    }


    public boolean delete(String id) {
        Student stu = new Student();
        ArrayList<Student> arrayList;
        boolean result = false;
        if (id.equals("")) {
            JOptionPane.showMessageDialog(this, "학번을 입력하세요");
            return false;
        }
        try {
            Class.forName("com.mysql.jdbc.Driver");
            sqlconn = DriverManager.getConnection(dataconn, username, password);
            pst = sqlconn.prepareStatement("select * from Student");
            rs = pst.executeQuery();
            while (rs.next()) {
                stu.setId(rs.getString(2));
            }
            if (!stu.getId().equals(id)) {
                JOptionPane.showMessageDialog(this, "삭제에 실패 했습니다.");
                result = false;
            } else if (id.equals("1")) {
                JOptionPane.showMessageDialog(this, "관리자는 삭제 할수 없습니다.");
                result = false;
            } else {
                JOptionPane.showMessageDialog(this, "삭제 되었습니다.");
                result = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            Class.forName("com.mysql.jdbc.Driver");
            sqlconn = DriverManager.getConnection(dataconn, username, password);
            pst = sqlconn.prepareStatement("delete from Student WHERE ID = ? AND ID <> '1'");
            pst.setString(1, id);
            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean tableInquire(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setNumRows(0);
        table.setAutoCreateRowSorter(false);
        boolean result = false;
        Object[] rowName = new Object[5];
        try {
            Class.forName("com.mysql.jdbc.Driver");
            sqlconn = DriverManager.getConnection(dataconn, username, password);
            pst = sqlconn.prepareStatement("select  *, (CASE WHEN (SCORE <= '100' AND SCORE>= '95') THEN 'A+'\n" +
                    "             WHEN (SCORE >= '90') then 'A'\n" +
                    "             WHEN (SCORE>= '85') THEN 'B+'\n" +
                    "             WHEN (SCORE>= '80' AND SCORE < '85') THEN 'B'\n" +
                    "             WHEN (SCORE >= '75' ) then 'C+'\n" +
                    "             WHEN (SCORE>= '70' AND SCORE < '75') THEN 'C'\n" +
                    "             WHEN (SCORE >= '65' ) then 'D+'\n" +
                    "             WHEN (SCORE>= '60' AND SCORE < '65') THEN 'D'\n" +
                    "             ELSE 'F'\n" +
                    "           END) AS 'Grade' from Student");
            rs = pst.executeQuery();
            while (rs.next()) {
                rowName[0] = rs.getString(2);
                rowName[1] = rs.getString(3);
                rowName[2] = rs.getString(4);
                rowName[3] = rs.getInt(5);
                rowName[4] = rs.getString("Grade");
                model.addRow(rowName);
            }
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean searchDAO(JTable table, JTextField jTextField, String itemAt) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setNumRows(0);
        boolean result = false;
        table.setAutoCreateRowSorter(false);
        Object[] rowName = new Object[5];
        switch (itemAt) {
            case "학번":
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    sqlconn = DriverManager.getConnection(dataconn, username, password);
                    pst = sqlconn.prepareStatement("select  *, (CASE WHEN (SCORE <= '100' AND SCORE>= '95') THEN 'A+'\n" +
                            "             WHEN (SCORE >= '90') then 'A'\n" +
                            "             WHEN (SCORE>= '85') THEN 'B+'\n" +
                            "             WHEN (SCORE>= '80' AND SCORE < '85') THEN 'B'\n" +
                            "             WHEN (SCORE >= '75' ) then 'C+'\n" +
                            "             WHEN (SCORE>= '70' AND SCORE < '75') THEN 'C'\n" +
                            "             WHEN (SCORE >= '65' ) then 'D+'\n" +
                            "             WHEN (SCORE>= '60' AND SCORE < '65') THEN 'D'\n" +
                            "             ELSE 'F'\n" +
                            "           END) AS 'Grade'from Student WHERE ID = ?");
                    pst.setString(1, jTextField.getText());
                    rs = pst.executeQuery();
                    while (rs.next()) {
                        rowName[0] = rs.getString(2);
                        rowName[1] = rs.getString(3);
                        rowName[2] = rs.getString(4);
                        rowName[3] = rs.getInt(5);
                        rowName[4] = rs.getString("Grade");
                        model.addRow(rowName);
                    }
                    result = true;
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case "이름":
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    sqlconn = DriverManager.getConnection(dataconn, username, password);
                    pst = sqlconn.prepareStatement("select  *, (CASE WHEN (SCORE <= '100' AND SCORE>= '95') THEN 'A+'\n" +
                            "             WHEN (SCORE >= '90') then 'A'\n" +
                            "             WHEN (SCORE>= '85') THEN 'B+'\n" +
                            "             WHEN (SCORE>= '80' AND SCORE < '85') THEN 'B'\n" +
                            "             WHEN (SCORE >= '75' ) then 'C+'\n" +
                            "             WHEN (SCORE>= '70' AND SCORE < '75') THEN 'C'\n" +
                            "             WHEN (SCORE >= '65' ) then 'D+'\n" +
                            "             WHEN (SCORE>= '60' AND SCORE < '65') THEN 'D'\n" +
                            "             ELSE 'F'\n" +
                            "           END) AS 'Grade'from Student WHERE NAME = ?");
                    pst.setString(1, jTextField.getText());
                    rs = pst.executeQuery();
                    while (rs.next()) {
                        rowName[0] = rs.getString(2);
                        rowName[1] = rs.getString(3);
                        rowName[2] = rs.getString(4);
                        rowName[3] = rs.getInt(5);
                        rowName[4] = rs.getString("Grade");
                        model.addRow(rowName);
                    }
                    result = true;
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case "학과":
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    sqlconn = DriverManager.getConnection(dataconn, username, password);
                    pst = sqlconn.prepareStatement("select  *, (CASE WHEN (SCORE <= '100' AND SCORE>= '95') THEN 'A+'\n" +
                            "             WHEN (SCORE >= '90') then 'A'\n" +
                            "             WHEN (SCORE>= '85') THEN 'B+'\n" +
                            "             WHEN (SCORE>= '80' AND SCORE < '85') THEN 'B'\n" +
                            "             WHEN (SCORE >= '75' ) then 'C+'\n" +
                            "             WHEN (SCORE>= '70' AND SCORE < '75') THEN 'C'\n" +
                            "             WHEN (SCORE >= '65' ) then 'D+'\n" +
                            "             WHEN (SCORE>= '60' AND SCORE < '65') THEN 'D'\n" +
                            "             ELSE 'F'\n" +
                            "           END) AS 'Grade'from Student WHERE DEPT like '%' ? '%'");
                    pst.setString(1, jTextField.getText());
                    rs = pst.executeQuery();
                    while (rs.next()) {
                        rowName[0] = rs.getString(2);
                        rowName[1] = rs.getString(3);
                        rowName[2] = rs.getString(4);
                        rowName[3] = rs.getInt(5);
                        rowName[4] = rs.getString("Grade");
                        model.addRow(rowName);
                    }
                    result = true;
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case "성적":
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    sqlconn = DriverManager.getConnection(dataconn, username, password);
                    pst = sqlconn.prepareStatement("select  *, (CASE WHEN (SCORE <= '100' AND SCORE>= '95') THEN 'A+'\n" +
                            "             WHEN (SCORE >= '90') then 'A'\n" +
                            "             WHEN (SCORE>= '85') THEN 'B+'\n" +
                            "             WHEN (SCORE>= '80' AND SCORE < '85') THEN 'B'\n" +
                            "             WHEN (SCORE >= '75' ) then 'C+'\n" +
                            "             WHEN (SCORE>= '70' AND SCORE < '75') THEN 'C'\n" +
                            "             WHEN (SCORE >= '65' ) then 'D+'\n" +
                            "             WHEN (SCORE>= '60' AND SCORE < '65') THEN 'D'\n" +
                            "             ELSE 'F'\n" +
                            "           END) AS 'Grade'from Student WHERE SCORE = ?");
                    pst.setString(1, jTextField.getText());
                    rs = pst.executeQuery();
                    while (rs.next()) {
                        rowName[0] = rs.getString(2);
                        rowName[1] = rs.getString(3);
                        rowName[2] = rs.getString(4);
                        rowName[3] = rs.getInt(5);
                        rowName[4] = rs.getString("Grade");
                        model.addRow(rowName);
                    }
                    result = true;
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;

        }

        return result;

    }

    public boolean ResetDAO(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setNumRows(0);
        boolean result = false;
        table.setAutoCreateRowSorter(false);
        Object[] rowName = new Object[5];
        try {
            Class.forName("com.mysql.jdbc.Driver");
            sqlconn = DriverManager.getConnection(dataconn, username, password);
            pst = sqlconn.prepareStatement("select  *, (CASE WHEN (SCORE <= '100' AND SCORE>= '95') THEN 'A+'\n" +
                    "             WHEN (SCORE >= '90') then 'A'\n" +
                    "             WHEN (SCORE>= '85') THEN 'B+'\n" +
                    "             WHEN (SCORE>= '80' AND SCORE < '85') THEN 'B'\n" +
                    "             WHEN (SCORE >= '75' ) then 'C+'\n" +
                    "             WHEN (SCORE>= '70' AND SCORE < '75') THEN 'C'\n" +
                    "             WHEN (SCORE >= '65' ) then 'D+'\n" +
                    "             WHEN (SCORE>= '60' AND SCORE < '65') THEN 'D'\n" +
                    "             ELSE 'F'\n" +
                    "           END) AS 'Grade'from Student");
            rs = pst.executeQuery();
            while (rs.next()) {
                rowName[0] = rs.getString(2);
                rowName[1] = rs.getString(3);
                rowName[2] = rs.getString(4);
                rowName[3] = rs.getInt(5);
                rowName[4] = rs.getString("Grade");
                model.addRow(rowName);
            }
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean tableNameSort(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setNumRows(0);
        boolean result = false;
        table.setAutoCreateRowSorter(false);
        Object[] rowName = new Object[5];
        try {
            Class.forName("com.mysql.jdbc.Driver");
            sqlconn = DriverManager.getConnection(dataconn, username, password);
            pst = sqlconn.prepareStatement("select  *, (CASE WHEN (SCORE <= '100' AND SCORE>= '95') THEN 'A+'\n" +
                    "             WHEN (SCORE >= '90') then 'A'\n" +
                    "             WHEN (SCORE>= '85') THEN 'B+'\n" +
                    "             WHEN (SCORE>= '80' AND SCORE < '85') THEN 'B'\n" +
                    "             WHEN (SCORE >= '75' ) then 'C+'\n" +
                    "             WHEN (SCORE>= '70' AND SCORE < '75') THEN 'C'\n" +
                    "             WHEN (SCORE >= '65' ) then 'D+'\n" +
                    "             WHEN (SCORE>= '60' AND SCORE < '65') THEN 'D'\n" +
                    "             ELSE 'F'\n" +
                    "           END) AS 'Grade'from Student " +
                    "ORDER BY NAME ASC ,SCORE DESC ");
            rs = pst.executeQuery();
            while (rs.next()) {
                rowName[0] = rs.getString(2);
                rowName[1] = rs.getString(3);
                rowName[2] = rs.getString(4);
                rowName[3] = rs.getInt(5);
                rowName[4] = rs.getString("Grade");
                model.addRow(rowName);
            }
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean tableScoreSort(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setNumRows(0);
        boolean result = false;
        table.setAutoCreateRowSorter(false);
        Object[] rowName = new Object[5];
        try {
            Class.forName("com.mysql.jdbc.Driver");
            sqlconn = DriverManager.getConnection(dataconn, username, password);
            pst = sqlconn.prepareStatement("select  *, (CASE WHEN (SCORE <= '100' AND SCORE>= '95') THEN 'A+'\n" +
                    "             WHEN (SCORE >= '90') then 'A'\n" +
                    "             WHEN (SCORE>= '85') THEN 'B+'\n" +
                    "             WHEN (SCORE>= '80' AND SCORE < '85') THEN 'B'\n" +
                    "             WHEN (SCORE >= '75' ) then 'C+'\n" +
                    "             WHEN (SCORE>= '70' AND SCORE < '75') THEN 'C'\n" +
                    "             WHEN (SCORE >= '65' ) then 'D+학점'\n" +
                    "             WHEN (SCORE>= '60' AND SCORE < '65') THEN 'D'\n" +
                    "             ELSE 'F'\n" +
                    "           END) AS 'Grade'from Student " +
                    "ORDER BY SCORE DESC ,NAME ASC");
            rs = pst.executeQuery();
            while (rs.next()) {
                rowName[0] = rs.getString(2);
                rowName[1] = rs.getString(3);
                rowName[2] = rs.getString(4);
                rowName[3] = rs.getInt(5);
                rowName[4] = rs.getString("Grade");
                model.addRow(rowName);
            }
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean login(String user, char[] pw) {
        UserVo userVo = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            sqlconn = DriverManager.getConnection(dataconn, username, password);
            pst = sqlconn.prepareStatement("select * from USERS");
            rs = pst.executeQuery();
            while (rs.next()) {
                userVo = new UserVo(id, pw);
                userVo.setId(rs.getString("ID"));
                userVo.setPassword(rs.getString("PASSWORD"));
            }
            if (user.equals(userVo.getId()) && new String(pw).equals(userVo.getPassword())) {
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "로그인 실패");
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }


}