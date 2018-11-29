package ru.stqa.pft.adressbook;

import org.testng.annotations.*;
import org.openqa.selenium.*;


public class DeleteGroupTest extends TestBase{


  @Test
  public void testDeleteGroup() {
    goToGroupPage();
    selectGroup();
    deleteGroups();
    returnToGroupPage();
  }


}
