package Week10.src;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class StudentDAO {
    private Scanner scan;
    private ArrayList<Student> al;

    private String id;
    private String name;
    private int score;

    public StudentDAO() {
        scan = new Scanner(System.in);
        al = new ArrayList<Student>();
    }

    public boolean insert(String id, String name, int score) {
        for (int i = 0; i < al.size(); i++) {
            Student s = al.get(i);
            if (id.equals(s.getId()))
                return false;
        }
        if (score < 100 && score > 0) {
            try {
                Student stu = new Student(id, name, score);
                al.add(stu);
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    public String inquire() {
        String str = "";
        for (int i = 0; i < al.size(); i++) {
            str = str + "ID:" + al.get(i).getId() + " 이름:" + al.get(i).getName()
                    + " 성적:" + al.get(i).getScore() + '\n';
        }
        return str;
    }

    public boolean update(String id, String name, int score) {
        for (int i = 0; i < al.size(); i++) {
            Student stu = al.get(i);
            if (id.equals(stu.getId())) {
                al.remove(i);
            } else {
                System.out.println("수정할 ID가 없습니다.");
                return false;
            }
        }
        Student stu = new Student(id, name, score);
        al.add(stu);
        return true;
    }

    public boolean delete(String del_id) {
        boolean found = false;
        int tempIndex = 0;
        for (int i = 0; i < al.size(); i++) {
            Student stu = al.get(i);
            if (del_id.equals(stu.getId())) {
                found = true;
                tempIndex = i;
            }

        }
        if (found) {
            al.remove(tempIndex);
            System.out.println("ID가 삭제됨");
        } else {
            System.out.println("삭제할 ID가 없읍!");
        }
        return true;
    }

    public boolean scoreSort() {
        Collections.sort(al,Student.scoreComparator);
        inquire();
        return true;
    }

    public boolean nameSort() {
        Collections.sort(al, Student.nameComparator);
        inquire();
        return true;
    }
}
