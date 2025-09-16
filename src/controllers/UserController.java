package controllers;

import models.I_User;
import models.User;

import utils.Files;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserController extends ArrayList<User> implements I_User {
    public void readUser() {
        this.clear();
        List<Object> list;
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
            return Files.writeListObjectToFile("registrations.dat", list);
        } catch (IOException e) {
            return false;
        }
    }

    @Override
    public boolean create(String studentID, String name, String phoneNumber, String email, String mountainCode) {
        String checkPhone = "^0(?:32|33|34|35|36|37|38|39|86|96|97|98|81|82|83|84|85|88|91|94)\\d{7}$";
        double tuitionFee;

        try {
            tuitionFee = phoneNumber.matches(checkPhone) ?  6000000.0 - (6000000.0 * 0.35) : 6000000.0;
            if(getUserById(studentID) != null) {
                System.out.println("IDs already exist");
                return false;
            }

            User newUser = new User(studentID, name, phoneNumber, email, mountainCode, tuitionFee);
            this.add(newUser);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean update(String studentID, String name, String phoneNumber, String email, String mountainCode) {
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
        List<Object> users = getAllUserExcept(studentID);
        User student = getUserById(studentID);
        if(getUserById(studentID) == null) return false;

        try {
            Files.writeListObjectToFile("temp.dat", users);
            File oldFile = new File("registrations.dat");
            oldFile.delete();
            new File("temp.dat").renameTo(oldFile);

        } catch (IOException e) {
            return false;
        }

        readUser();
        return true;
    }

    @Override
    public List<User> getUserByName(String name) {
        List<User> users = new ArrayList<>();
        String username = name.trim().toLowerCase();
        for(User u : this) {
            if(u.getName() != null && u.getName().trim().toLowerCase().contains(username)) {
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
        List<User> filterUsers = new ArrayList<>();

        for(User u : this) {
            String studentCampus = u.getStudentID().substring(0, 2);
            if(campus.equals(studentCampus)) {
                filterUsers.add(u);
            }
        }
        return filterUsers;
    }

    @Override
    public void statisticalByMountainPeak() {

    }

    public List<Object> getAllUserExcept(String studentID) {
        List<Object> users = new ArrayList<>();

        for(User u : this) {
            if(!u.getStudentID().equals(studentID)) {
                users.add(u);
            }
        }

        return users;
    }
}
