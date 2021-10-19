package Program;

import Objects.Soldier;
import Objects.SoldierList;

import java.io.*;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

class MilitaryInfoManage {

    private static Scanner sc;
    private static SoldierList soldierList;

    /**
     * 병사 정보 관리 객체
     * 이미 전에 설정해둔 스케너와 병사 리스트를 가져오기 및 셋업
     * @param sc 전에 설정해둔 스케너
     * @param soldierList 전에 가져온 이미 있는 병사 정보 리스트
     */
    public MilitaryInfoManage(Scanner sc, SoldierList soldierList) {
        this.sc = sc;
        this.soldierList = soldierList;
    }

    /**
     * 병사 정보 입력
     */
    public void inputData() {
        System.out.println("데이터 입력을 시작합니다...");
        // 병사 정보 입력 창 가져오기 및 입력된 정보 가져오기
        Soldier soldier = showInfo.showInputInfo(sc);
        System.out.println("로딩중...");

        // 이미 있는 정보인지 확인 및 결과 출력
        boolean isAdded = soldierList.addSoldier(soldier);
        if (isAdded) {
            System.out.println("데이터 입력이 완료되었습니다. \n");
        } else {
            System.out.println("이미 저장된 데이터입니다. \n");
        }

        // 현재 입력된 총 병사 수 출력
        System.out.println("총 " + soldierList.size() + " 명의 정보가 있습니다.");
    }

    /**
     * 병사 정보 검색
     */
    public void searchData() {
        System.out.println("데이터 검색을 시작합니다.");
        // 검색할 병사 이름과 군번 묻기
        System.out.print("이름: ");
        String name = sc.nextLine();
        System.out.print("군번: ");
        String militaryNumber = sc.nextLine();
        System.out.println("");

        // 병사 검색
        Soldier searchedSoldier = soldierList.searchSoldier(name, militaryNumber);
        // 검색 결과 출력
        if (searchedSoldier == null) {
            System.out.println("찾으시는 데이터가 존재하지 않습니다. \n");
        } else {
            showInfo.showOutputInfo(searchedSoldier);
            System.out.println("데이터 검색이 완료되었습니다.  \n");
        }
    }

    /**
     * 병사 정보 삭제
     */
    public void deleteData() {
        System.out.println("데이터 삭제를 시작합니다...");
        // 삭제할 병사 이름과 군번 묻기
        System.out.print("이름: ");
        String name = sc.nextLine();
        System.out.print("군번: ");
        String militaryNumber = sc.nextLine();

        // 병사 삭제
        boolean isDeleted = soldierList.deleteSoldier(name, militaryNumber);
        // 삭제 결과 출력
        if (isDeleted) {
            System.out.println("이름: " + name);
            System.out.println("군번: " + militaryNumber);
            System.out.println("데이터가 삭제 되었습니다.");
        } else {
            System.out.println("찾으시는 데이터가 존재하지 않습니다. \n");
        }
    }

    /**
     * 프로그램 실행후 지금까지 바뀐 모든 변경 사항 저장
     */
    public void saveData() {
        soldierList.saveSoldierList();
    }
}
