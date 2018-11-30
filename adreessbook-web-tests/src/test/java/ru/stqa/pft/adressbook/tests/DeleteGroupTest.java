package ru.stqa.pft.adressbook.tests;

import org.testng.annotations.Test;

public class DeleteGroupTest extends TestBase {


  @Test
  public void testDeleteGroup() {
    app.getNavigationHelper().goToGroupPage();
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().deleteGroups();
    app.getGroupHelper().returnToGroupPage();
  }


}
