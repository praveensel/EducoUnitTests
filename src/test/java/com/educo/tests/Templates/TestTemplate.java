package com.educo.tests.Templates;

import com.educo.tests.Common.Properties.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;

public class TestTemplate {

    public static WebDriver driver;


    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {

        Properties.setProperties();
    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite() {
    }

    @BeforeMethod(alwaysRun = true)
    public void start(Method method) {
        startBrowser();
    }

    @AfterMethod(alwaysRun = true)
    public void stop() {
        stopBrowser();
    }

    protected void startBrowser() {
        //DriverProvider.getInstance();
        System.setProperty("webdriver.chrome.driver","D://selnium//chromedriver.exe");
        driver = new FirefoxDriver();

    }

    protected void stopBrowser() {

        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }


}
