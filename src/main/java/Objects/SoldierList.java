package Objects;

import java.util.ArrayList;
import Data.Data;

public class SoldierList {

    // 병사 정보 리스트 객체
    ArrayList<Soldier> soldierList;

    /**
     * 병사 정보 리스트를 데이터 객체를 통해 가져오기 및 셋업
     */
    public SoldierList() {
        Data data = new Data();
        setSoldierList(data.getSoldierList());
    }

    /**
     * 병사 정보 리스트 반환
     * @return
     */
    public ArrayList<Soldier> getSoldierList() {
        return soldierList;
    }

    /**
     * 병사 정보 리스트 셋업
     * @param soldierList
     */
    public void setSoldierList(ArrayList<Soldier> soldierList) {
        this.soldierList = soldierList;
    }

    /**
     * 새로 입력된 병사 정보 저장
     */
    public boolean addSoldier(Soldier soldier) {
        if (soldierList.contains(soldier)) {
            return false;
        }
        soldierList.add(soldier);
        return true;
    }

    /**
     * 병사 검색 및 결과 반환
     * @param name 검색할 병사 이름
     * @param militaryNumber 검색할 병사 군번
     * @return 검색된 병사 아니면 결과없음
     */
    public Soldier searchSoldier(String name, String militaryNumber) {
        // 현재까지 저장된 병사 리스트에서 겸색
        for (Soldier soldier : soldierList) {
            // 정보가 있으면 병사 객체 반환
            if (soldier.name.equals(name) && soldier.MilitaryNumber.equals(militaryNumber)) {
                return soldier;
            }
        }
        // 정보가 없으면 결과없음 반환
        return null;
    }

    /**
     * 병사 삭제 및 결과 반환
     * @param name 삭제할 병사 이름
     * @param militaryNumber 삭제할 병사 군번
     * @return 삭제된 병사 결과
     */
    public boolean deleteSoldier(String name, String militaryNumber) {
        // 현재까지 저장된 병사 리스트에서 검색
        for (int i = 0; i < soldierList.size(); i++) {
            // 병사 리스트의 병사
            Soldier soldier = soldierList.get(i);
            // 정보가 일치하면 병사 리스트에서 병사 삭제
            if (soldier.name.equals(name) && soldier.MilitaryNumber.equals(militaryNumber)) {
                soldierList.remove(i);
                return true;
            }
        }
        return false;
    }

    /**
     * 데이터를 통해 정리된 데이터 저장
     */
    public void saveSoldierList() {
        Data.saveData();
    }

    /**
     * @return 총 저장된 병사 수 반환
     */
    public int size() {
        return soldierList.size();
    }
}
