package ru.stqa.pft.adressbook.model;

public class ContactData {
    private int id;
    private final String firstname;
    private final String secondname;
    private final String email;
    private final String day;
    private final String month;
    private final String year;
    private final String mobileNumber;


    public ContactData(String firstname,String secondname,String email, String day, String month, String year, String mobileNumber) {
        this.id = Integer.MAX_VALUE;
        this.firstname = firstname;
        this.secondname = secondname;
        this.email = email;
        this.day = day;
        this.month = month;
        this.year = year;
        this.mobileNumber = mobileNumber;
    }

    public ContactData(int id, String firstname, String secondname, String email, String day, String month, String year, String mobileNumber) {
        this.id = id;
        this.firstname = firstname;
        this.secondname = secondname;
        this.email = email;
        this.day = day;
        this.month = month;
        this.year = year;
        this.mobileNumber = mobileNumber;
    }

    public int getId() { return id;
    }

    public void setId(int id) {
        this.id= id;
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

        if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
        return secondname != null ? secondname.equals(that.secondname) : that.secondname == null;
    }

    @Override
    public int hashCode() {
        int result = firstname != null ? firstname.hashCode() : 0;
        result = 31 * result + (secondname != null ? secondname.hashCode() : 0);
        return result;
    }
}
