package ru.stqa.pft.adressbook;

public class PhoneData {
    private final String homeNumber;
    private final String mobileNumber;

    public PhoneData(String homeNumber, String mobileNumber) {
        this.homeNumber = homeNumber;
        this.mobileNumber = mobileNumber;
    }

    public String getHomeNumber() {
        return homeNumber;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }
}
