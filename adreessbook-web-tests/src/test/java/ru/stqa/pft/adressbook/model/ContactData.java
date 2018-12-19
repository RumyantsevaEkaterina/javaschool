package ru.stqa.pft.adressbook.model;

public class ContactData {
    private int id = Integer.MAX_VALUE;;
    private String firstname;
    private String secondname;
    private String email;
    private String day;
    private String month;
    private String year;
    private String home;
    private String mobileNumber;
    private String workNumber;
    private String allPhones;
    private String email2;
    private String email3;
    private String allEmails;
    private String address;


    public int getId() {
        return id;
    }

    public ContactData withId(int id) {
        this.id= id;
        return this;
    }

    public ContactData withFirstName(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public ContactData withLastName(String secondname) {
        this.secondname = secondname;
        return this;
    }

    public ContactData withAllPhones(String allPhones) {
        this.allPhones = allPhones;
        return this;
    }

    public ContactData withAddress(String address) {
        this.address = address;
        return this;
    }

    public ContactData withEmail(String email) {
        this.email = email;
        return this;
    }

    public ContactData withEmail2(String email2) {
        this.email2 = email2;
        return this;
    }

    public ContactData withEmail3(String email3) {
        this.email3 = email3;
        return this;
    }

    public ContactData withAllEmails(String allEmails) {
        this.allEmails = allEmails;
        return this;
    }

    public ContactData withDay(String day) {
        this.day = day;
        return this;
    }

    public ContactData withMonth(String month) {
        this.month = month;
        return this;
    }

    public ContactData withYear(String year) {
        this.year = year;
        return this;
    }

    public ContactData withMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
        return this;
    }

    public ContactData withHomeNumber(String home) {
        this.home = home;
        return this;
    }

    public ContactData withWorkNumber(String workNumber) {
        this.workNumber = workNumber;
        return this;
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

    public String getAddress() {
        return address;
    }

    public String getEmail2() {
        return email2;
    }

    public String getEmail3() {
        return email3;
    }

    public String getAllEmails() {
        return allEmails;
    }

    public String getAllPhones() {
        return allPhones;
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

    public String getHomeNumber() {
        return home;
    }

    public String getWorkNumber() {
        return workNumber;
    }


    @Override
    public String toString() {
        return "ContactData{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", secondname='" + secondname + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactData that = (ContactData) o;

        if (id != that.id) return false;
        if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
        return secondname != null ? secondname.equals(that.secondname) : that.secondname == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
        result = 31 * result + (secondname != null ? secondname.hashCode() : 0);
        return result;
    }
}
