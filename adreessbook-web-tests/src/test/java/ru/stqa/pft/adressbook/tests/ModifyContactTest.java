package ru.stqa.pft.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;


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
        List<ContactData> before = app.contact().list();
        ContactData contact = new ContactData()
                    .withFirstname("Maria").withSecondname("Egorova").withDay("1").withMonth("January").withYear("1991");
        int index = before.size() - 2;
        app.contact().modify(contact, index);
        List<ContactData> after = app.contact().list();
        Assert.assertEquals(before.size(), after.size());

        before.remove(index);
        before.add(contact);
        Comparator<? super ContactData> byId = (c1, c2) ->Integer.compare(c1.getId(), c2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);

    }


}
