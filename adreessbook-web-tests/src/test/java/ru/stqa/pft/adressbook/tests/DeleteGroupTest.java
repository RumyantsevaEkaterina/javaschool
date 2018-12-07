package ru.stqa.pft.adressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.GroupData;

public class DeleteGroupTest extends TestBase {


  @Test
  public void testDeleteGroup() {
    app.getNavigationHelper().goToGroupPage();
    if (! app.getGroupHelper().isThereAGroup()) {
      app.getGroupHelper().createGroup(new GroupData("test1", null, null));
    }
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().deleteGroups();
    app.getGroupHelper().returnToGroupPage();
  }


}
