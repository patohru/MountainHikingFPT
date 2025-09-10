package models;

import java.util.List;

public interface I_User {
    boolean register(String studentID, String name, String phoneNumber, String email, String mountainCode, String tuitionFee);

    boolean update(String studentID, String name, String phoneNumber, String email, String mountainCode, String tuitionFee);

    List<User> getAllUser();

    boolean delete(String studentID);

    List<User> getUserByName(String name);

    List<User> filterByCampus(String campus);

    void statisticalizeByMountainPeak();
}
