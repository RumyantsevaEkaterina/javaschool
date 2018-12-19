package ru.stqa.pft.adressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.adressbook.model.ContactData;
import ru.stqa.pft.adressbook.model.Contacts;

import java.util.List;



public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void fillContactForm(ContactData contactData) {
        type(By.name("firstname"), contactData.getFirstName());
        type(By.name("lastname"), contactData.getSecondName());
        dropDown(By.name("bday"), contactData.getDay());
        click(By.xpath("//option[@value='5']"));
        dropDown(By.name("bmonth"), contactData.getMonth());
        click(By.xpath("//option[@value='1']"));
        type(By.name("home"), contactData.getHomeNumber());
        type(By.name("byear"), contactData.getYear());
        type(By.name("mobile"), contactData.getMobileNumber());
        type(By.name("work"), contactData.getWorkNumber());
        type(By.name("email"), contactData.getEmail());
        type(By.name("email2"), contactData.getEmail());
        type(By.name("email3"), contactData.getEmail());

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

    public void initContactModificationById(int id) {
        wd.findElement(By.cssSelector("a[href='edit.php?id="+ id +"']")).click();
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

    private Contacts contactCache = null;

    public Contacts all() {
        if (contactCache != null) {
            return new Contacts(contactCache);
        }
        contactCache = new Contacts();
        List<WebElement> elements = wd.findElements(By.xpath("//tr[@name='entry']"));
        for (WebElement element: elements) {
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("id"));
            String name = element.findElements(By.tagName("td")).get(2).getText();
            String lastName = element.findElements(By.tagName("td")).get(1).getText();
            String allPhones = element.findElement(By.xpath("./td[6]")).getText();
            String address = element.findElement(By.xpath("./td[4]")).getText();
            String allEmails = element.findElement(By.xpath("./td[5]")).getText();
            ContactData contact = new ContactData().withId(id).withFirstName(name).withLastName(lastName).withAllPhones(allPhones).withAddress(address).withAllEmails(allEmails);
            contactCache.add(contact);

        }
        return contactCache;
    }

    public ContactData infoFromEditForm(ContactData contact) {
        initContactModificationById(contact.getId());
        String firstName = wd.findElement(By.name("firstname")).getAttribute("value");
        String lastName = wd.findElement(By.name("lastname")).getAttribute("value");
        String home = wd.findElement(By.name("home")).getAttribute("value");
        String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
        String work = wd.findElement(By.name("work")).getAttribute("value");
        String address = wd.findElement(By.name("address")).getAttribute("value");
        String email = wd.findElement(By.name("email")).getAttribute("value");
        String email2 = wd.findElement(By.name("email2")).getAttribute("value");
        String email3 = wd.findElement(By.name("email3")).getAttribute("value");
        wd.navigate().back();
        return new ContactData()
                .withId(contact.getId())
                .withFirstName(firstName)
                .withLastName(lastName)
                .withHomeNumber(home)
                .withMobileNumber(mobile)
                .withWorkNumber(work)
                .withAddress(address)
                .withEmail(email)
                .withEmail2(email2)
                .withEmail3(email3);

    }
}
