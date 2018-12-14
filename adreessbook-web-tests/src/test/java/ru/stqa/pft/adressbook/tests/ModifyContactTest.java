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
            app.contact().create(new ContactData("Ekaterina", "Rumiantceva", "katerinka_ru93@bk.ru", "5", "January", "1993", "+79216598475"));
        }
        app.goTO().home();
    }

    @Test
    public void testModifyContact() {
        List<ContactData> before = app.contact().list();
        ContactData contact = new ContactData("Maria", "Egorova",null,"1","January","1991", null);
        int index = before.size() - 1;
        app.contact().modify(contact, index);
        List<ContactData> after = app.contact().list();
        Assert.assertEquals(after.size(), before.size());

        before.remove(index);
        before.add(contact);
        Comparator<? super ContactData> byId = (c1, c2) ->Integer.compare(c1.getId(), c2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);

    }


}
