package ru.stqa.pft.adressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.adressbook.model.ContactData;
import ru.stqa.pft.adressbook.model.Contacts;

import java.util.ArrayList;
import java.util.List;



public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void fillContactForm(ContactData contactData) {
        type(By.name("firstname"), contactData.getFirstName());
        type(By.name("lastname"), contactData.getSecondName());
        type(By.name("email"), contactData.getEmail());
        dropDown(By.name("bday"), contactData.getDay());
        click(By.xpath("//option[@value='5']"));
        dropDown(By.name("bmonth"), contactData.getMonth());
        click(By.xpath("//option[@value='1']"));
        type(By.name("byear"), contactData.getYear());
        type(By.name("mobile"), contactData.getMobileNumber());



    }

    public void returnToContactPage() {
        click(By.linkText("home"));
    }



    public void newContactButton() {
        click(By.linkText("add new"));
    }

    public void selectContactById(int id) {
        wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
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

    public void create(ContactData contact) {
        newContactButton();
        fillContactForm(contact);
        contactCache = null;
        enterButton();
    }

    public void delete(ContactData contact) {
        selectContactById(contact.getId());
        deleteContact();
        contactCache = null;
        acceptDeleteContact();
        returnToContactPage();

    }



    public void modify(ContactData contact) {
        selectContactById(contact.getId());
        editContact();
        fillContactForm(contact);
        updateContact();
        contactCache = null;
        returnToContactPage();

    }

    public int count() {
        return wd.findElements(By.name("selected[]")).size();
    }

    public boolean isThereAContact() {
        return isElementPresent(By.name("selected[]"));
    }

    public List<ContactData> list() {
        List<ContactData> contacts = new ArrayList<ContactData>();
        List<WebElement> elements = wd.findElements(By.cssSelector("tr[name~=entry]"));
        for (WebElement element: elements) {
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            String firstname = element.findElement(By.xpath("./td[2]")).getText();
            String secondname = element.findElement(By.xpath("./td[3]")).getText();
            ContactData contact = new ContactData().withId(id).withFirstname(firstname).withSecondname(secondname);
            contacts.add(contact);
        }
        return contacts;
    }

    private Contacts contactCache = null;

    public Contacts all() {
        if (contactCache != null) {
            return new Contacts(contactCache);
        }
        contactCache = new Contacts();
        List<WebElement> elements = wd.findElements(By.xpath("//tr[@name='entry']"));
        for (WebElement element: elements) {
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("id"));
            String firstname = element.findElements(By.tagName("td")).get(2).getText();
            String secondname = element.findElements(By.tagName("td")).get(1).getText();
            ContactData contact = new ContactData().withId(id).withFirstname(firstname).withSecondname(secondname);
            contactCache.add(contact);

        }
        return contactCache;
    }
}
