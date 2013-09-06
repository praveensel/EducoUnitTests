package com.educo.tests.trash;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
public class Gridtest

{
    WebDriver driver;
    String baseUrl, nodeURL;

    @BeforeTest public void setup() throws MalformedURLException
    {
        baseUrl = "http://newtours.demoaut.com";
        nodeURL = "http://localhost:4444/wd/hub";
        DesiredCapabilities capability = DesiredCapabilities.firefox();
        capability.setBrowserName( "firefox");
        //capability.setPlatform(Platform.XP);
        driver = new RemoteWebDriver(new URL(nodeURL), capability);

    }

        @AfterTest
        public void afterTest()
        {
            driver. quit();
        }

            @Test
        public void simpleTest()
        {
            driver.get(baseUrl);
         Assert.assertEquals("Welcome: Mercury Tours", driver.getTitle());
        }
    }


