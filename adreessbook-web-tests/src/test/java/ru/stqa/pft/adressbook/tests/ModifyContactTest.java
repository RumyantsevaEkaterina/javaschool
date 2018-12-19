package ru.stqa.pft.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.ContactData;

import java.util.Comparator;
import java.util.Set;


public class ModifyContactTest  extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
        if (app.contact().list().size() == 0) {
            app.contact().create(new ContactData()
                    .withFirstname("Fiona").withSecondname("Piona").withDay("3").withMonth("May").withYear("1993"));
        }
        app.goTO().home();
    }

    @Test
    public void testModifyContact() {
        Set<ContactData> before = app.contact().all();
        ContactData modifiedContact = before.iterator().next();
        ContactData contact = new ContactData()
                    .withId(modifiedContact.getId()).withFirstname("Maria").withSecondname("Egorova").withDay("1").withMonth("January").withYear("1991");
        app.contact().modify(contact);
        Set<ContactData> after = app.contact().all();
        Assert.assertEquals(before.size(), after.size());

        before.remove(modifiedContact);
        before.add(contact);
        Assert.assertEquals(before, after);

    }


}
