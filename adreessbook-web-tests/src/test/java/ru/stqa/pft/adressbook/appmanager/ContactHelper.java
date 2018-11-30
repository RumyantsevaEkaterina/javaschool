package ru.stqa.pft.adressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import ru.stqa.pft.adressbook.model.BirthdayData;
import ru.stqa.pft.adressbook.model.PhoneData;

public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void Birthday(BirthdayData birthdayData) {
        dropDown(By.name("bday"), birthdayData.getDay());
        click(By.xpath("//option[@value='5']"));
        dropDown(By.name("bmonth"), birthdayData.getMonth());
        click(By.xpath("//option[@value='1']"));
        type(By.name("byear"), birthdayData.getYear());
    }

    public void PhoneNumber(PhoneData phoneData) {
        type(By.name("home"), phoneData.getHomeNumber());
        type(By.name("mobile"), phoneData.getMobileNumber());

    }

    public void EmailCreation(String email) {
        type(By.name("email"), email);

    }

    public void NameCreation(String firstName, String secondName) {
        type(By.name("firstname"), firstName);
        type(By.name("lastname"), secondName);
    }

    public void newContactButton() {
        click(By.linkText("add new"));
    }

    public void selectContact() {
        click(By.name("selected[]"));
    }


    public void deleteContact() {
        click(By.xpath("//input[@value='Delete']"));
    }

    public void acceptDeleteContact() {
        wd.switchTo().alert().accept();
    }

    public void enterButton() {
        click(By.xpath("(//input[@name='submit'])[2]"));
    }

}
