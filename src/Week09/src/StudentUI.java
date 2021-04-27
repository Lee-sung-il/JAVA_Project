package Week09.src;

import java.util.Scanner;

public class StudentUI {
    private Scanner scan;
    private StudentDAO dao; //로직 당담 클래스
    private Student[] temp;

    public StudentUI() {
        scan = new Scanner(System.in);
        dao = new StudentDAO();
        temp = dao.list();
    }

    private void showUsage() {
        boolean bFlag = true;
        while (bFlag) {
            System.out.println("****사용 방법****");
            System.out.println("1.등록, 2.조회, 3.수정, 4.삭제, 0.종료");

            String menu = scan.nextLine();

            if (menu.equals("0")) {
                System.out.println("시스템 종료");
                bFlag = false;
                return;
            } else {
                getUserInput(menu);
            }
        }
    }

    private void getUserInput(String strMenu) {
        if (strMenu.equals("1")) {
            System.out.println("등록");
            dao.insert();
        } else if (strMenu.equals("2")) {
            System.out.println("조회");
            dao.inquire();
        } else if (strMenu.equals("3")) {
            System.out.println("수정");
            dao.update();
        } else if (strMenu.equals("4")) {
            System.out.println("삭제");
            dao.delete();
        } else {
            System.out.println("1~4사이의 숫자를 사용하세요");
        }

    }

    public static void main(String[] args) {
        StudentUI ui = new StudentUI();
        ui.showUsage();
    }


}
