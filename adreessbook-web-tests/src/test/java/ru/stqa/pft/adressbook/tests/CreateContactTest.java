package ru.stqa.pft.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.ContactData;

import java.util.List;
import java.util.Set;


public class CreateContactTest extends TestBase {

    @Test
    public void testCreateContact() throws Exception {
        Set<ContactData> before = app.contact().all();
        ContactData contact = new ContactData()
                .withFirstname("Ekaterina").withSecondname("Rumiantceva").withEmail("katerinka_ru93@bk.ru").withDay("5").withMonth("January").withYear("1993").withMobileNumber("+79216598475");
        app.contact().create(contact);
        app.goTO().home();
        Set<ContactData> after = app.contact().all();
        Assert.assertEquals(after.size(), before.size()+1);

        contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt());
        before.add(contact);
        Assert.assertEquals(before,after);
    }


}
