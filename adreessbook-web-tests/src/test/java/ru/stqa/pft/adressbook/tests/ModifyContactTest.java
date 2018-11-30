package ru.stqa.pft.adressbook.tests;

import org.testng.annotations.Test;

public class ModifyContactTest  extends TestBase {

    @Test
    public void testModifyContact() {
        app.getContactHelper().selectContact();
        app.getContactHelper().editContact();
        app.getContactHelper().NameCreation("Maria", "Egorova");
        app.getContactHelper().EmailCreation("marina_ru93@bk.ru");
        app.getContactHelper().updateContact();
        app.getNavigationHelper().returnHome();
    }
}
