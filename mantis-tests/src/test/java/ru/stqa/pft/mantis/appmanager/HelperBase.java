package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.io.File;

public class HelperBase {

    protected ApplicationManager app;
    public WebDriver wd;

    public HelperBase(ApplicationManager app) {
        this.app = app;
        this.wd = app.getDriver();
    }


    public void click(By locator) {
        wd.findElement( locator ).click();
    }

    public void type(By locator, String text) {
        click( locator );
        if (text != null) {
            String existingText = wd.findElement(locator).getAttribute("value");
            if (! text.equals(existingText)) {
                wd.findElement(locator ).clear();
                wd.findElement(locator).sendKeys(text);
            }
        }
    }

    public void attach(By locator, File file) {
        if (file != null ) {
            System.out.println(file.getAbsolutePath() );
            wd.findElement( locator ).sendKeys( file.getAbsolutePath() );
        }
    }

    public void select(By locator, String text) {
        wd.findElement( locator ).click();
        new Select( wd.findElement(locator)).selectByVisibleText( text );
        wd.findElement(locator).click();
    }

    public void selectByValue(By locator, String text) {
        wd.findElement( locator ).click();
        new Select( wd.findElement(locator)).selectByValue(text);
        wd.findElement(locator).click();
    }


    public String closeAlertAndGetItsText(boolean acceptNextAlert) {
        try {
            Alert alert = wd.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }

    public boolean isAlertPresent() {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    public boolean isElementPresent(By locator) {
        try {
            wd.findElement( locator );
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }
}