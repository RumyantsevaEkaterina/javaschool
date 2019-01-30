package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.mantis.model.UserData;

import static org.testng.Assert.assertTrue;

public class UserHelper extends HelperBase {

    public UserHelper(ApplicationManager wd) {
        super((ApplicationManager) wd);
    }
}