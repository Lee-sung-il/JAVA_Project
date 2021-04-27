package Week09.src;

import java.util.Scanner;

public class TestUI {
    private Scanner scan;

    TestUI() {
        scan = new Scanner(System.in);
    }

    private void showUsage() {
        boolean bFlag = true;

        while (bFlag) {
            System.out.println("사용방법");
            System.out.println("1.등록 2.조회 3.수정 4.삭제 5.종료");

            String menu = scan.nextLine();
            if (menu.equals("5") == true) {
                System.out.println("시스템종료");
                bFlag = false;
                return;
            }else {
                getUserInput(menu); // 재귀적 호출
            }
        }

    }

    private void getUserInput(String strMenu) {
        if (strMenu.equals("1") == true) { //등록
            System.out.println("등록메뉴");
            return;
        } else if (strMenu.equals("2") == true) { //조회
            System.out.println("조회메뉴");
            return;
        }else if (strMenu.equals("3") == true) { //수정
            System.out.println("수정메뉴");
            return;
        }else if (strMenu.equals("4") == true) { //삭제
            System.out.println("삭제");
            return;
        } else {
            System.out.println("1~5까지 입력하시오.");
            return;
        }
    }

    public static void main(String[] args) {
        TestUI ui = new TestUI();
        ui.showUsage();
    }


}
