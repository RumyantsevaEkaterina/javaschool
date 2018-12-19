package ru.stqa.pft.adressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.GroupData;
import ru.stqa.pft.adressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

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
        Groups before = app.group().all();
        GroupData modifiedGroup = before.iterator().next();
        GroupData group = new GroupData()
                .withId(modifiedGroup.getId()).withName("test333").withHeader("testhead1").withFooter("543");
        app.group().modify(group);
        app.goTO().home();
        Groups after = app.group().all();
        assertEquals(after.size(),before.size());
        assertThat(after, equalTo(before.without(modifiedGroup).withAdded(group)));

    }


}
