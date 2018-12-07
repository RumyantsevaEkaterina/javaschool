package ru.stqa.pft.adressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.ContactData;

public class DeleteContactTest extends TestBase {

    @Test
    public void testDeleteContact() {
        if (! app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactData("Ekaterina", "Rumiantceva","katerinka_ru93@bk.ru","5","January","1993", "+79216598475"));
        }
        app.getNavigationHelper().returnHome();
        app.getContactHelper().selectContact();
        app.getContactHelper().deleteContact();
        app.getContactHelper().acceptDeleteContact();
        app.getNavigationHelper().returnHome();
    }


}
