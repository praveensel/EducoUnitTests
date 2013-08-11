package com.educo.tests.trash; /**
 * @author Gaurang Shah
 * To Demonstrate how to configure webdirver with Selenium Grid
 */
import org.junit.AfterClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Gridwithwebdriver {

    public WebDriver driver;

    @Parameters({"browser"})
    @BeforeClass
    public void setup(String browser) throws MalformedURLException {
        DesiredCapabilities capability=null;

        if(browser.equalsIgnoreCase("chrome")){
            System.out.println("chrome");
            System.setProperty("webdriver.chrome.driver","D://selnium//chromedriver.exe");
            capability= DesiredCapabilities.chrome();
            capability.setBrowserName("chrome");
            capability.setPlatform(org.openqa.selenium.Platform.ANY);
            //capability.setVersion("");
        }

        if(browser.equalsIgnoreCase("firefox")){
            System.out.println("iexplore");
            System.setProperty("webdriver.ie.driver"," D:\\Intellij IDEAWorkspace\\selenium-tests-master\\src\\test\\resources\\IEDriver\\IEDriverServer.exe");
            capability= DesiredCapabilities.firefox();
            capability.setBrowserName("firefox");
            capability.setPlatform(org.openqa.selenium.Platform.WINDOWS);

            //capability.setVersion("");
        }

        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability);
        driver.navigate().to("http://google.com");

    }

    @Test
    public void test_first() throws InterruptedException{
        Thread.sleep(3000);
        WebElement search_editbox	=	driver.findElement(By.name("q"));
        WebElement search_button	=	driver.findElement(By.name("btnG"));
        search_editbox.clear();
        search_editbox.sendKeys("first");
        search_button.click();
    }

    @Test
    public void test_second(){
        WebElement search_editbox	=	driver.findElement(By.name("q"));
        WebElement search_button	=	driver.findElement(By.name("btnG"));
        search_editbox.clear();
        search_editbox.sendKeys("second");
        search_button.click();
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}