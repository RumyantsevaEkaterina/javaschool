package ru.stqa.pft.adressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.ContactData;
import ru.stqa.pft.adressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class ContactCreationTest extends TestBase {

    @Test
    public void testCreateContact() throws Exception {
        Contacts before = app.contact().all();
        ContactData contact = new ContactData()
                .withFirstname("Ekaterina").withSecondname("Rumiantceva").withEmail("katerinka_ru93@bk.ru").withDay("5").withMonth("January").withYear("1993").withMobileNumber("+79216598475");
        app.contact().create(contact);
        app.goTO().home();
        assertThat(app.contact().count(), equalTo(before.size() + 1));
        Contacts after = app.contact().all();
        assertThat(after, equalTo(
                before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
    }


}
