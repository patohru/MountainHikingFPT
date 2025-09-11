package models;

import java.util.List;

public interface I_User {
    boolean create(String studentID, String name, String phoneNumber, String email, String mountainCode, Double tuitionFee);

    boolean update(String studentID, String name, String phoneNumber, String email, String mountainCode, Double tuitionFee);

    List<User> getAllUser();

    boolean delete(String studentID);

    List<User> getUserByName(String name);

    List<User> filterByCampus(String campus);

    void statisticalByMountainPeak();

    User getUserById(String studentID);
}
