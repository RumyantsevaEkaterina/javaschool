package ru.stqa.pft.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.GroupData;

import java.util.Set;

public class GroupModificatonTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTO().groupPage();
        if (app.group().all().size() == 0) {
            app.group().create(new GroupData().withName("test3"));
        }

    }

    @Test
    public void testGroupModification() {
        Set<GroupData> before = app.group().all();
        GroupData modifiedGroup = before.iterator().next();
        GroupData group = new GroupData()
                .withId(modifiedGroup.getId()).withName("test333").withHeader("testhead1").withFooter("543");
        app.group().modify(group);
        app.goTO().home();
        Set<GroupData> after = app.group().all();
        Assert.assertEquals(after.size(), before.size());

        before.remove(modifiedGroup);
        before.add(group);
        Assert.assertEquals(before, after);

    }


}
