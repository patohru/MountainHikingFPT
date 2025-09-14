package models;

import java.io.Serializable;

public class User implements Serializable {
    private static final long serialVersionUID = 5305293927933091843L;
    private String StudentID;
    private String name;
    private String phoneNumber;
    private String email;
    private String mountainCode;
    private double tuitionFee;

    public User() {}

    public User(String studentID, String name, String phoneNumber, String email, String mountainCode, double tuitionFee) {
        StudentID = studentID;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.mountainCode = mountainCode;
        this.tuitionFee = tuitionFee;
    }

    public String getStudentID() {
        return StudentID;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getMountainCode() {
        return mountainCode;
    }

    public double getTuitionFee() {
        return tuitionFee;
    }

    public void setStudentID(String studentID) {
        StudentID = studentID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMountainCode(String mountainCode) {
        this.mountainCode = mountainCode;
    }

    public void setTuitionFee(double tuitionFee) {
        this.tuitionFee = tuitionFee;
    }

    @Override
    public String toString() {
        return "User{" +
                "StudentID='" + StudentID + '\'' +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", mountainCode='" + mountainCode + '\'' +
                ", tuitionFee=" + tuitionFee +
                '}';
    }
}
