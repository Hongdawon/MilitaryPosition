package Objects;

import java.util.ArrayList;

public class Soldier {
    String name;
    String MilitaryNumber;
    String birth;
    String position;
    String discharge;
    String enlist;

    public Soldier(String name, String MilitaryNumber, String birth, String position,String dischrge,String enlist) {
        this.name = name;
        this.MilitaryNumber = MilitaryNumber;
        this.birth = birth;
        this.position = position;
        this.discharge=dischrge;
        this.enlist=enlist;
    }

    public Soldier(ArrayList<String> soldierInfo) {
        for (int i = 0; i < soldierInfo.size(); i++) {
            String info = soldierInfo.get(i);
            if (i == 0) this.name = info;
            else if (i == 1) this.MilitaryNumber = info;
            else if (i == 2) this.birth = info;
            else if (i == 3) this.position = info;
            else if (i == 4) this.discharge = info;
            else this.enlist = info;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMilitaryNumber() {
        return MilitaryNumber;
    }

    public void setMilitaryNumber(String militaryNumber) {
        MilitaryNumber = militaryNumber;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDischarge() {
        return discharge;
    }

    public void setDischarge(String discharge) {
        this.discharge = discharge;
    }

    public String getEnlist() {
        return enlist;
    }

    public void setEnlist(String enlist) {
        this.enlist = enlist;
    }
}
