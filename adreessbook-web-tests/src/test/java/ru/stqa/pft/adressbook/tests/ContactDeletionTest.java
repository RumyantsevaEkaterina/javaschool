package ru.stqa.pft.adressbook.tests;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.ContactData;
import ru.stqa.pft.adressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class ContactDeletionTest extends TestBase {
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
    public void testDeleteContact() {
        Contacts before = app.contact().all();
        ContactData deletedContact = before.iterator().next();
        app.contact().delete(deletedContact);
        Assert.assertEquals(app.contact().count(), before.size()-1 );
        Contacts after = app.contact().all();
        assertThat(after, equalTo(before.without(deletedContact)));
    }




}
