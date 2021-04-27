package Week09.src;

import java.util.Scanner;

public class StudentDAO {
    private Scanner scan;
    private Student[] list;
    private int cnt;

    private String id;
    private String name;
    private int score;

    public StudentDAO() {
        scan = new Scanner(System.in);
        list = new Student[100];
    }

    public Student[] list() {
        return list;
    }

    public void update(Student new_stu, int i) {
        list[i] = new_stu;
    }



    public Student[] getList() {
        return list;
    }

    public void setList(Student[] list) {
        this.list = list;
    }

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    public void insert() {
        System.out.println("학번입력>>");
        id = scan.nextLine();
        System.out.println("이름 입력>>");
        name = scan.nextLine();
        System.out.println("성적 입력>>");
        score = Integer.parseInt(scan.nextLine());

        Student stu = new Student(id, name, score);
        if (cnt > list.length - 1) {
            System.out.println("더 이상 등록할 수 없습니다.");
        }
        for (int i = 0; i < cnt; i++) {
            if (stu.equals(list[i])) {
                System.out.println("등록된 ID 입니다.");
            }
        }
        list[cnt++] = stu;
        System.out.println("등록이 완료됨!!");
    }

    public void inquire() {
        for (int i = 0; i < cnt; i++) {
            System.out.println("ID : " + list[i].getId() + " 이름 : " + list[i].getName() + " 성적 : "
                    + list[i].getScore());
        }
    }

    public void update() {
        System.out.println("수정할 학생 ID : ");
        id = scan.nextLine().trim();

        for (int i = 0; i < cnt; i++) {
            if (id.equals(list[i].getId())) {
                System.out.println("수정 ID 입력 >>");
                String new_id = scan.nextLine();
                System.out.println("수정 할 이름 >>");
                String new_name = scan.nextLine();
                System.out.println("수정 할 성적 >>");
                int new_score = Integer.parseInt(scan.nextLine());

                Student new_stu = new Student(new_id, new_name, new_score);
                list[i] = new_stu;
                System.out.println("수정완료");
            }
        }
    }
    public void  delete() {
        System.out.println("삭제할 학생 ID를 입력하세요 >>");
        String del_id = scan.nextLine();
        boolean found = false;
        int tempIndex = 0;
        for (int i = tempIndex; i < cnt; i++) {
            if (del_id.equals(list[i].getId())) {
                found =true;
                tempIndex = i;
            }

        }
        if (found) {
            list[tempIndex] = null;
            for (int i = tempIndex; i < cnt; i++) {
                list[i] = list[i + 1];
            }
            cnt--;
        }else {
            System.out.println("삭제할 ID가 없읍!");
        }
    }
}
