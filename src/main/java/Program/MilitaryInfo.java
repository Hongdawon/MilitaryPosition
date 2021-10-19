package Program;

import Objects.SoldierList;

import java.io.*;
import java.util.Scanner;

public class MilitaryInfo implements Serializable {// 인스턴스

    // 프로그램에서 쓸 병사 정보 리스트
    // 이미 있는 정보, 편집될 정보, 추가 및 지울 정보를 다 관리 담당하는 리스트
    private static SoldierList soldierList;

    /**
     * 프로그램 시작
     */
    public void startMilitaryInfo() {

        // Soldier 객체들을 가지고 있는 soldierList 객체 부르기
        // 이미 저장된 병사 정보들이 들어있음
        soldierList = new SoldierList();
        runMainProgram();
    }

    /**
     * 메인 프로그램 시작
     * 사용자에게 원하는 메뉴 묻기 및 알맞는 프로그램 실행
     */
    public static void runMainProgram() {

        // 키보드 스케너 열기
        Scanner sc = new Scanner(System.in);
        // 연 키보드 스케너로 정보 관리 객체 열기
        MilitaryInfoManage manage = new MilitaryInfoManage(sc, soldierList);
        // 사용자가 선택한 메뉴 번호
        int choice;

        // EXIT 을 누를때까지 프로그램을 계속 실행
        while (true) {
            try {
                showInfo.showMenu();
                choice = sc.nextInt();

                if (choice < INIT_MENU.INPUT || choice > INIT_MENU.EXIT)
                    throw new MenuChoiceException(choice);

                switch (choice) {
                    case INIT_MENU.INPUT:
                        manage.inputData();
                        break;
                    case INIT_MENU.SEARCH:
                        manage.searchData();
                        break;
                    case INIT_MENU.DELETE:
                        manage.deleteData();
                        break;
                    case INIT_MENU.CHECKNBPEOPLE:

                    case INIT_MENU.EXIT:
                        manage.saveData();
                        System.out.println("프로그램을 종료합니다.");
                        return;

                }
            } catch (MenuChoiceException e) {
                e.showWrongChoice();
                System.out.println("메뉴 선택을 처음부터 다시 진행합니다. \n");
            }
        }
    }
}

