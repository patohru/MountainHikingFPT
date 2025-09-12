package controllers;

import models.I_User;
import models.User;

import utils.Files;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserController extends ArrayList<User> implements I_User {
    public void readUser() {
        this.clear();
        List<Object> list = new ArrayList<>();
        list = Files.readFromFile("registrations.dat");

        for(Object obj : list) {
            if(obj instanceof User) {
                this.add((User) obj);
            }
        }
    }

    public boolean writeUser() {
        List<Object> list = new ArrayList<>();
        for(User u : this) {
            list.add((Object) u);
        }

        try {
            Files.writeListObjectToFile("registrations.dat", list);
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    @Override
    public boolean create(String studentID, String name, String phoneNumber, String email, String mountainCode) {
        String checkPhone = "^(?:(?:0|(?:\\+84|84))(?:32|33|34|35|36|37|38|39|86|96|97|98|81|82|83|84|85|88|91|94))\\d{7}$\n";
        double tuitionFee;

        try {
            if(phoneNumber.matches(checkPhone)) {
                tuitionFee = 6000000.0 * 0.35;
            } else {
                tuitionFee = 6000000.0;
            }

            User newUser = new User(studentID, name, phoneNumber, email, mountainCode, tuitionFee);
            if(!getUserByName(name).isEmpty()) {
                System.out.println(name + " already exists");
                return false;
            }

            this.add(newUser);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean update(String studentID, String name, String phoneNumber, String email, String mountainCode, Double tuitionFee) {
        User user = getUserById(studentID);

        try {
            user.setName(name);
            user.setPhoneNumber(phoneNumber);
            user.setEmail(email);
            user.setMountainCode(mountainCode);
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    @Override
    public List<User> getAllUser() {
        return new ArrayList<>(this);
    }

    @Override
    public boolean delete(String studentID) {
        return false;
    }

    @Override
    public List<User> getUserByName(String name) {
        List<User> users = new ArrayList<>();

        for(User u : this) {
            if(u.getName().contains(name.toUpperCase()) || u.getName().contains(name.toLowerCase())) {
                users.add(u);
            }
        }

        return users;
    }

    @Override
    public User getUserById(String studentID) {
        User user = null;
        for(User u : this) {
            if(u.getStudentID().equals(studentID)) {
                user = u;
                break;
            }
        }

        return user;
    }

    @Override
    public List<User> filterByCampus(String campus) {
        return Collections.emptyList();
    }

    @Override
    public void statisticalByMountainPeak() {

    }
}
