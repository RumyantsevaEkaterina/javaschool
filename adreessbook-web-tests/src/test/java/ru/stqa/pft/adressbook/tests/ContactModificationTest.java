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
        if (app.db().contacts().size() == 0) {
            app.contact().create(new ContactData()
                    .withFirstName("Fiona")
                    .withLastName("Piona"));
        }
        app.goTO().home();
    }

    @Test
    public void testModifyContact() {
        Contacts before = app.db().contacts();
        ContactData modifiedContact = before.iterator().next();
        ContactData contact = new ContactData()
                .withId(modifiedContact.getId())
                .withFirstName("Maria")
                .withLastName("Egorova")
                .withMobileNumber("89325698754")
                .withHomeNumber("2514569")
                .withWorkNumber("1256987")
                .withEmail("maria@mail.ru");
        app.goTO().home();
        app.contact().modify(contact);
        assertEquals(app.contact().count() ,before.size());
        Contacts after = app.db().contacts();
        assertThat(after,equalTo(before.without(modifiedContact).withAdded(contact)));

    }


}
