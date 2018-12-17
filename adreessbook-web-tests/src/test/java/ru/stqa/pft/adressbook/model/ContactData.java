package ru.stqa.pft.adressbook.model;

public class ContactData {
    private int id = Integer.MAX_VALUE;;
    private String firstname;
    private String secondname;
    private String email;
    private String day;
    private String month;
    private String year;
    private String mobileNumber;


    public int getId() {
        return id;
    }

    public ContactData withId(int id) {
        this.id= id;
        return this;
    }

    public ContactData withFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public ContactData withSecondname(String secondname) {
        this.secondname = secondname;
        return this;
    }

    public ContactData withEmail(String email) {
        this.email = email;
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
