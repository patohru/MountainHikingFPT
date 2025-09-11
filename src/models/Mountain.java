package models;

public class Mountain {
    private String mountainCode;
    private String mountainName;
    private String province;
    private String description;

    public Mountain(String mountainCode, String mountainName, String province, String description) {
        this.mountainCode = mountainCode;
        this.mountainName = mountainName;
        this.province = province;
        this.description = description;
    }

    public String getMountainCode() {
        return mountainCode;
    }

    public String getMountainName() {
        return mountainName;
    }

    public String getProvince() {
        return province;
    }

    public String getDescription() {
        return description;
    }

    public void setMountainCode(String mountainCode) {
        this.mountainCode = mountainCode;
    }

    public void setMountainName(String mountainName) {
        this.mountainName = mountainName;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Mountain{" +
                "mountainCode='" + mountainCode + '\'' +
                ", mountainName='" + mountainName + '\'' +
                ", province='" + province + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
