package ru.stqa.pft.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.ContactData;

import java.util.List;


public class CreateContactTest extends TestBase {

    @Test
    public void testCreateContact() throws Exception {
        List<ContactData> before = app.contact().list();
        ContactData contact = new ContactData()
                .withFirstname("Ekaterina").withSecondname("Rumiantceva").withEmail("katerinka_ru93@bk.ru").withDay("5").withMonth("January").withYear("1993").withMobileNumber("+79216598475");
        app.contact().create(contact);
        app.goTO().home();
        List<ContactData> after = app.contact().list();
        Assert.assertEquals(after.size(), before.size()+1);

        //before.add(contact);
        //Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
        //before.sort(byId);
        //after.sort(byId);
        //Assert.assertEquals(before, after);
    }


}
