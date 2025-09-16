package controllers;

import models.StatisticalInfo;
import models.User;

import java.util.HashMap;
import java.util.List;

public class StatisticalController extends HashMap<String, StatisticalInfo> {

    public StatisticalController() {
        super();
    }

    public StatisticalController(List<User> u) {
        super();
        statisticalize(u);
    }

    public void statisticalize(List<User> userList) {
        for(User u : userList) {
            String mountainCode = u.getMountainCode();
            if(mountainCode == null) continue;

            StatisticalInfo info = this.get(mountainCode);
            if(info == null) {
                info = new StatisticalInfo(mountainCode, 0, 0.0);
                this.put(mountainCode, info);
            }

            info.setNumberOfStudent(info.getNumberOfStudent() + 1);
            info.setTotalFee(info.getTotalFee() + u.getTuitionFee());
        }
    }

    public void show() {
        for (StatisticalInfo s : this.values()) {
            System.out.println(s);
        }
    }

}
