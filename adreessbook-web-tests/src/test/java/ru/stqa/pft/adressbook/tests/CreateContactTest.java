package ru.stqa.pft.adressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.ContactData;


public class CreateContactTest extends TestBase {

    @Test
    public void testCreateContact() throws Exception {
        app.getContactHelper().createContact(new ContactData("Ekaterina", "Rumiantceva","katerinka_ru93@bk.ru","5","January","1993",  "+79216598475"));
    }


}
