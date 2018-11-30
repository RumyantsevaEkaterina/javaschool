package ru.stqa.pft.adressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.BirthdayData;
import ru.stqa.pft.adressbook.model.PhoneData;

public class CreateContactTest extends TestBase {

    @Test
    public void testCreateContact() throws Exception {
        app.getContactHelper().newContactButton();
        app.getContactHelper().NameCreation("Ekaterina", "Rumiantceva");
        app.getContactHelper().EmailCreation("katerinka_ru93@bk.ru");
        app.getContactHelper().PhoneNumber(new PhoneData("352-65-44", "+79216598475"));
        app.getContactHelper().Birthday(new BirthdayData("5", "January", "1993"));
        app.getContactHelper().enterButton();
    }


}
