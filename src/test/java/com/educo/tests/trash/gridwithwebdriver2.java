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
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class gridwithwebdriver2 {

    public WebDriver driver;


    @Parameters({"browser"})

    @BeforeClass
    public void setup(@Optional("chrome")String browser) throws MalformedURLException, InterruptedException {
        DesiredCapabilities capability=null;

        if(browser.equalsIgnoreCase("chrome")){
            System.out.println("fchromex");
            System.setProperty("webdriver.chrome.driver","D://selnium//chromedriver.exe");
            capability= DesiredCapabilities.chrome();
            capability.setBrowserName("chrome");
            capability.setPlatform(org.openqa.selenium.Platform.ANY);
            //capability.setVersion("");
        }

        if(browser.equalsIgnoreCase("iexplore")){
            System.out.println("iexplore");
            capability= DesiredCapabilities.firefox();
            capability.setBrowserName("firefox");
            capability.setPlatform(org.openqa.selenium.Platform.WINDOWS);
            //capability.setVersion("");
        }
        System.setProperty("webdriver.chrome.driver","D://selnium//chromedriver.exe");
        driver = new RemoteWebDriver(new URL("http://192.168.100.85:5555/wd/hub"), capability);
        driver.navigate().to("http://google.com");

    }

    @Test
    public void test_third() throws InterruptedException{
        Thread.sleep(3000);
        WebElement search_editbox	=	driver.findElement(By.name("q"));
        WebElement search_button	=	driver.findElement(By.name("btnG"));
        search_editbox.clear();
        search_editbox.sendKeys("third");
        search_button.click();

    }

    @Test
    public void test_fourth(){
        WebElement search_editbox	=	driver.findElement(By.name("q"));
        WebElement search_button	=	driver.findElement(By.name("btnG"));
        search_editbox.clear();
        search_editbox.sendKeys("foruth");
        search_button.click();

    }

    @AfterClass
    public void tearDown(){
        //Close the browser
        //   driver.quit();

    }
}