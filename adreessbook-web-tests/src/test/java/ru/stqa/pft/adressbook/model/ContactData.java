package ru.stqa.pft.adressbook.model;

public class ContactData {
    private final String day;
    private final String month;
    private final String year;
    private final String homeNumber;
    private final String mobileNumber;


    public ContactData(String day, String month, String year, String homeNumber, String mobileNumber) {
        this.day = day;
        this.month = month;
        this.year = year;
        this.homeNumber = homeNumber;
        this.mobileNumber = mobileNumber;
    }

    public String getDay() {
        return day;
    }

    public String getMonth() {
        return month;
    }

    public String getYear() {
        return year;
    }

    public String getHomeNumber() {
        return homeNumber;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }
}
