package ru.stqa.pft.adressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.adressbook.model.ContactData;


public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void Birthday(ContactData contactData) {
        dropDown(By.name("bday"), contactData.getDay());
        click(By.xpath("//option[@value='5']"));
        dropDown(By.name("bmonth"), contactData.getMonth());
        click(By.xpath("//option[@value='1']"));
        type(By.name("byear"), contactData.getYear());
        type(By.name("home"), contactData.getHomeNumber());
        type(By.name("mobile"), contactData.getMobileNumber());
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

    public void editContact() {
        click(By.xpath("//img[@alt='Edit']"));
    }

    public void updateContact() {
        click(By.xpath("(//input[@name='update'])[2]"));
    }

}
