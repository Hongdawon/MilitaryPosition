package Program;

import Objects.Soldier;

import java.util.Scanner;

class showInfo {

    public static void showMenu() {
        System.out.println("선택하세요...");
        System.out.println("1.데이터 입력");
        System.out.println("2.데이터 검색");
        System.out.println("3.데이터 삭제");
        System.out.println("4.프로그램 종료");
        System.out.print("선택: ");
    }

    public static Soldier showInputInfo(Scanner sc) {
        System.out.print("이름: ");
        String name = sc.nextLine();
        System.out.print("생년월일(ex:001111): ");
        String birth = sc.nextLine();
        System.out.print("과목: ");
        String position = sc.nextLine();
        System.out.print("군번: ");
        String MilitaryNumber = sc.nextLine();
        System.out.print("입대일: ");
        String enlist = sc.nextLine();
        System.out.print("전역일: ");
        String discharge = sc.nextLine();
        return new Soldier(name, birth, position, MilitaryNumber, enlist, discharge);
    }

    public static void showOutputInfo(Soldier soldier) {
        System.out.println("이름: " + soldier.getName());
        System.out.println("생년월일: " + soldier.getBirth());
        System.out.println("과목: " + soldier.getPosition()  );
        System.out.println("군번: " + soldier.getMilitaryNumber());
        System.out.println("입대일: " + soldier.getEnlist());
        System.out.println("전역일: " + soldier.getDischarge());
        System.out.println(""); // 줄 구분을 위해
    }

}
