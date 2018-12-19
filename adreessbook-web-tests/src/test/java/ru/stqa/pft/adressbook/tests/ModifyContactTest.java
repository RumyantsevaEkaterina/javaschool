package ru.stqa.pft.adressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.ContactData;
import ru.stqa.pft.adressbook.model.Contacts;

import java.util.Comparator;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;


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
        Contacts before = app.contact().all();
        ContactData modifiedContact = before.iterator().next();
        ContactData contact = new ContactData()
                    .withId(modifiedContact.getId()).withFirstname("Maria").withSecondname("Egorova").withDay("1").withMonth("January").withYear("1991");
        app.contact().modify(contact);
        Contacts after = app.contact().all();
        assertEquals(before.size(), after.size());
        assertThat(after,equalTo(before.without(modifiedContact).withAdded(contact)));

    }


}
