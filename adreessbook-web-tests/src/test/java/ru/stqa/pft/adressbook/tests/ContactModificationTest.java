package ru.stqa.pft.adressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.ContactData;
import ru.stqa.pft.adressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;


public class ContactModificationTest extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
        if (app.contact().all().size() == 0) {
            app.contact().create(new ContactData()
                    .withFirstName("Fiona")
                    .withLastName("Piona")
                    .withDay("3")
                    .withMonth("May")
                    .withYear("1993"));
        }
        app.goTO().home();
    }

    @Test
    public void testModifyContact() {
        Contacts before = app.contact().all();
        ContactData modifiedContact = before.iterator().next();
        ContactData contact = new ContactData()
                    .withId(modifiedContact.getId())
                .withFirstName("Maria")
                .withLastName("Egorova")
                .withDay("1")
                .withMonth("January")
                .withYear("1991")
                .withMobileNumber("89325698754")
                .withHomeNumber("2514569")
                .withWorkNumber("1256987");
        app.contact().modify(contact);
        assertEquals(app.contact().count() ,before.size());
        Contacts after = app.contact().all();
        assertThat(after,equalTo(before.without(modifiedContact).withAdded(contact)));

    }


}
