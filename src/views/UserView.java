package views;

import controllers.UserController;
import models.User;
import utils.Input;
import utils.Validation;

import java.io.EOFException;

public class UserView {
    private final User user = new User();
    private static final UserController userController = new UserController();

    public void init() {
        userController.readUser();
    }

    public boolean create() {
        String studentID = Input.checkValidString("Enter Student ID: ", "student_id");
        String name = Input.checkValidString("Enter Name: ", "name");
        String phone = Input.checkValidString("Enter Phone Number: ", "phone");
        String email = Input.checkValidString("Enter Email: ", "email");
        String mountainCode = Input.getString("Enter Mountain Code: ");

        return userController.create(studentID, name, phone, email, mountainCode);
    }

    public boolean saveData() {
        return userController.writeUser();
    }
}

