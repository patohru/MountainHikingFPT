package views;

import controllers.MountainController;
import controllers.UserController;
import models.User;
import utils.Input;

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

    public boolean update() {
        String studentID = Input.getString("Enter student code: ");
        User user = userController.getUserById(studentID);

        if(user == null) {
            System.out.println("The student has not registered yet.");
            return false;
        }

        String name = Input.checkValidUpdateString("Update name: ", user.getName(), "name");
        String phone = Input.checkValidUpdateString("Update phone number: ", user.getPhoneNumber(), "phone");
        String email = Input.checkValidUpdateString("Update email: ", user.getEmail(), "email");
        String mountainCode = Input.checkValidUpdateString("Update mountain code: ", user.getMountainCode(), "mountain_code");

        userController.update(studentID, name, phone, email, mountainCode);
        return true;
    }

    public boolean delete() {
        String userID = Input.getString("Enter student ID: ");
        if(!displayDeleteStudent(userID)) return false;

        if(Input.confirmYesNo("Are you sure you want to delete this registration? (Y/N): ")) {
            userController.delete(userID);
        }

        return true;
    }

    public boolean getAllUser() {
        List<User> userList = userController.getAllUser();

        if(userList.isEmpty()) {
            return false;
        } else {
            int line = 71;
            for(int i = 0; i < line; i++) {
                System.out.print("-");
            }
            System.out.println();

            System.out.println("Student ID    | Name              | Phone      | Peak Code | Fee       ");

            for(int i = 0; i < line; i++) {
                System.out.print("-");
            }
            System.out.println();

            for(User u : userList) {
                System.out.println(u.toString());
            }

            for(int i = 0; i < line; i++) {
                System.out.print("-");
            }
            System.out.println();
            return true;
        }
    }

    public boolean displayDeleteStudent(String studentID) {
        User user = userController.getUserById(studentID);

        if(user == null) {
            return false;
        } else {
            int line = 41;
            for(int i = 0; i < line; i++) {
                System.out.print("-");
            }
            System.out.println();

            System.out.printf("%-10s: %s%n", "Student ID", user.getStudentID());
            System.out.printf("%-10s: %s%n", "Name", user.getName());
            System.out.printf("%-10s: %s%n", "Phone", user.getPhoneNumber());
            System.out.printf("%-10s: MT%s%n", "Mountain", user.getMountainCode());
            System.out.printf("%-10s: %s%n", "Fee", user.getTuitionFee());

            for(int i = 0; i < line; i++) {
                System.out.print("-");
            }
            System.out.println();
        }

        return true;
    }

    public boolean saveData() {
        return userController.writeUser();
    }
}

