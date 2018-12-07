package ru.stqa.pft.adressbook.tests;

import org.testng.annotations.*;
import ru.stqa.pft.adressbook.model.GroupData;

public class GroupCreationTest extends TestBase {


    @Test
    public void testCreateGroup() throws Exception {
        app.getNavigationHelper().goToGroupPage();
        app.getGroupHelper().createGroup(new GroupData("test", "test3", null));

    }


}
