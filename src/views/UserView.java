package views;

import controllers.MountainController;
import controllers.UserController;
import models.User;
import utils.Input;
import utils.Validation;

import java.io.EOFException;
import java.util.List;

public class UserView {
    private final User user = new User();
    private static final UserController userController = new UserController();
    private static final MountainController mountainController = new MountainController();

    public void init() {
        userController.readUser();
        mountainController.readMountain();
    }

    public boolean create() {
        String studentID = Input.checkValidString("Enter Student ID: ", "student_id");
        String name = Input.checkValidString("Enter Name: ", "name");
        String phone = Input.checkValidString("Enter Phone Number: ", "phone");
        String email = Input.checkValidString("Enter Email: ", "email");
        String mountainCode = Input.checkValidString("Enter Mountain Code: ", "mountain_code");

        return userController.create(studentID, name, phone, email, mountainCode);
    }

    public boolean saveData() {
        return userController.writeUser();
    }
}

