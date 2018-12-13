package ru.stqa.pft.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.adressbook.model.GroupData;

import java.util.List;

public class GroupCreationTest extends TestBase {


    @Test
    public void testCreateGroup() throws Exception {
        app.getNavigationHelper().goToGroupPage();
        List<GroupData> before = app.getGroupHelper().getGroupList();
        app.getGroupHelper().createGroup(new GroupData("test", "test3", null));
        List<GroupData> after = app.getGroupHelper().getGroupList();
        Assert.assertEquals(after.size(), before.size() + 1);
    }


}
