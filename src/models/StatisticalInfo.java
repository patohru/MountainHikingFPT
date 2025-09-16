package models;

public class StatisticalInfo {
    private String mountainCode;
    private int numberOfStudent;
    private double totalFee;

    public StatisticalInfo(String mountainCode, int numberOfStudent, double totalFee) {
        this.mountainCode = mountainCode;
        this.numberOfStudent = numberOfStudent;
        this.totalFee = totalFee;
    }

    public String getMountainCode() {
        return mountainCode;
    }

    public int getNumberOfStudent() {
        return numberOfStudent;
    }

    public double getTotalFee() {
        return totalFee;
    }

    public void setMountainCode(String mountainCode) {
        this.mountainCode = mountainCode;
    }

    public void setNumberOfStudent(int numberOfStudent) {
        this.numberOfStudent = numberOfStudent;
    }

    public void setTotalFee(double totalFee) {
        this.totalFee = totalFee;
    }

    @Override
    public String toString() {
        return String.format("MT%-10s | %-10s | %,-10.0f", mountainCode, numberOfStudent, totalFee);
    }
}
