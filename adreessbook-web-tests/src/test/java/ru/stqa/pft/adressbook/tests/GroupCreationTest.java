package ru.stqa.pft.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.adressbook.model.GroupData;

public class GroupCreationTest extends TestBase {


    @Test
    public void testCreateGroup() throws Exception {
        app.getNavigationHelper().goToGroupPage();
        int before=app.getGroupHelper().getGroupCount();
        app.getGroupHelper().createGroup(new GroupData("test", "test3", null));
        int after =app.getGroupHelper().getGroupCount();
        Assert.assertEquals(after, before + 1);
    }


}
