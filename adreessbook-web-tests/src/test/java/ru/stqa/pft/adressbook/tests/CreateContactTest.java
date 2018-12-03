package ru.stqa.pft.adressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.ContactData;


public class CreateContactTest extends TestBase {

    @Test
    public void testCreateContact() throws Exception {
        app.getContactHelper().newContactButton();
        app.getContactHelper().NameCreation("Ekaterina", "Rumiantceva");
        app.getContactHelper().EmailCreation("katerinka_ru93@bk.ru");
        app.getContactHelper().Birthday(new ContactData("5", "January", "1993", "352-65-52", "+79216598475"));
        app.getContactHelper().enterButton();
    }


}
