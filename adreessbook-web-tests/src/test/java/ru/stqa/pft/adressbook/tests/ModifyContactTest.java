package ru.stqa.pft.adressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.ContactData;


public class ModifyContactTest  extends TestBase {

    @Test
    public void testModifyContact() {
        if (! app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactData("Ekaterina", "Rumiantceva","katerinka_ru93@bk.ru","5","January","1993", "+79216598475"));
        }
        app.getNavigationHelper().returnHome();
        app.getContactHelper().selectContact();
        app.getContactHelper().editContact();
        app.getContactHelper().Contact(new ContactData("Maria", "Egorova",null,"1","January","1991", null));
        app.getContactHelper().updateContact();
        app.getNavigationHelper().returnHome();
    }
}
