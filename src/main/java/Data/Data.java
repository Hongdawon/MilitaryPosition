package Data;

import Objects.Soldier;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

public class Data {

    // Soldier List
    private static ArrayList<Soldier> soldierList = new ArrayList<>();
    // JSON Object
    private static JSONArray jsonArray;

    /**
     * 프로그램 시작할때 데이터 가져오는 생성자
     */
    public Data() {
        setJsonArray();
        setSoldierList();
    }

    /**
     * 셋업된 병사 정보 리스트 반환
     * @return
     */
    public static ArrayList<Soldier> getSoldierList() {
        return soldierList;
    }

    /**
     * 이미 있는 JSON 정보들을 array 형태로 가져오기
     */
    public static void setJsonArray() {
        InputStream is = Data.class.getResourceAsStream("./soldiers.json");
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        JSONTokener jt = new JSONTokener(reader);
        jsonArray = new JSONArray(jt);
    }

    /**
     * 이미 있는 병사 정보 리스트 셋업
     */
    public static void setSoldierList() {

        ArrayList<String> soldierInfo;
        for (int i = 0; i < jsonArray.length(); i++) {
            soldierInfo = new ArrayList<>();
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            Iterator<String> iterator = jsonObject.keys();
            while (iterator.hasNext()) {
                String key = iterator.next();
                soldierInfo.add(jsonObject.get(key).toString());
            }
            Soldier soldier = new Soldier(soldierInfo);
            soldierList.add(soldier);
        }
    }

    /**
     * 현재 데이터 저장
     */
    public static void saveData() {
        File prevData = new File("/soldiers.json");
        prevData.delete();
        File newData = new File("./Data/soldiers.json");
        try {
            newData.createNewFile();
        } catch (IOException e) {
            System.out.println("정보 저장에 실패했습니다.");
            e.printStackTrace();
        }
        ObjectMapper mapper = new ObjectMapper();
        try {
            for (Soldier soldier : soldierList) {
                mapper.writeValue(new File("/soldiers.json"), soldier);
            }
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
