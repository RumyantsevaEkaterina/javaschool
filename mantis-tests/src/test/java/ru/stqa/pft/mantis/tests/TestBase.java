package ru.stqa.pft.mantis.tests;

import org.openqa.selenium.remote.BrowserType;
import ru.stqa.pft.mantis.appmanager.ApplicationManager;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {

    protected static final ApplicationManager app
            = new ApplicationManager(System.getProperty("browser",BrowserType.FIREFOX));


    @BeforeSuite
    public void setUp() throws Exception {
        app.Init();
    }

    @AfterSuite (alwaysRun = true)
    public void tearDown() {
        app.stop();
    }


}
