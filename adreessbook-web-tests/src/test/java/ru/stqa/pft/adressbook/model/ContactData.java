package ru.stqa.pft.adressbook.model;

public class ContactData {
    private final String firstname;
    private final String secondname;
    private final String email;
    private final String day;
    private final String month;
    private final String year;
    private final String mobileNumber;


    public ContactData(String firstname,String secondname,String email, String day, String month, String year, String mobileNumber) {
        this.firstname = firstname;
        this.secondname = secondname;
        this.email = email;
        this.day = day;
        this.month = month;
        this.year = year;
        this.mobileNumber = mobileNumber;
    }

    public String getFirstName() {
        return firstname;
    }

    public String getSecondName() {
        return secondname;
    }

    public String getEmail() {
        return email;
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

    public String getMobileNumber() {
        return mobileNumber;
    }
}
