package com.educo.tests.TestCases;

import com.educo.tests.Helpers.Staticprovider;
import com.educo.tests.PageOBjects.InsHomePage.InsHomePageObjects;
import com.educo.tests.PageOBjects.LoginPage.UsaLoginPageObjects;
import com.educo.tests.PageOBjects.Tools.SyllabusPageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: admin
 * Date: 8/9/13
 * Time: 12:25 PM
 * To change this template use File | Settings | File Templates.
 */
public class SyllabusPageTests {
    public WebDriver driver;

    @Parameters({"browser"})
    @BeforeClass
    public void propsetup(@Optional("Chrome") String browser) {
        com.educo.tests.Common.Properties.Properties.setProperties();
        System.setProperty("org.uncommons.reportng.stylesheet","C://Custommcss//report.css");
    }

    @BeforeTest
    public void b4test() {
        System.out.println("@BeforeTest");
    }

    @Parameters({"browser"})
    @BeforeMethod
    public void setup(@Optional("chrome") String browser) throws MalformedURLException, InterruptedException {
        com.educo.tests.Common.Properties.Properties.setProperties();
        DesiredCapabilities capability = null;

        if (browser.equalsIgnoreCase("chrome")) {
            System.out.println("chrome");
            System.setProperty("webdriver.chrome.driver", "C://ChromeDriver//chromedriver.exe");
            capability = DesiredCapabilities.chrome();
            capability.setBrowserName("chrome");
            capability.setPlatform(org.openqa.selenium.Platform.ANY);

            //driver = new RemoteWebDriver(capability);
            driver = new ChromeDriver(capability);
        }


        if (browser.equalsIgnoreCase("Firefox")) {
            System.out.println("Firefox");
            capability = DesiredCapabilities.firefox();
            capability.setBrowserName("firefox");
            capability.setPlatform(org.openqa.selenium.Platform.WINDOWS);
            driver = new FirefoxDriver(capability);
            System.out.println(driver);
        }
        System.setProperty("webdriver.chrome.driver", "C://ChromeDriver//chromedriver.exe");
        // driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability);


    }
    //test
    @AfterTest
    public void afterclass() {

        driver.quit();

    }

    @Test(dataProviderClass = Staticprovider.class,dataProvider = "UsaLogin1")
    public void Syllabustest(String EmailInsUsa,String Password,String Profname) throws Exception {

        driver.manage().deleteAllCookies();
        UsaLoginPageObjects LoginPagePageobj= PageFactory.initElements(driver, UsaLoginPageObjects.class);
        LoginPagePageobj.openUsaPage();
        LoginPagePageobj.login(EmailInsUsa, Password);
        InsHomePageObjects insHomePageObjects = PageFactory.initElements(driver, InsHomePageObjects.class);
        List<WebElement> list =insHomePageObjects.giveMeAList();
        insHomePageObjects.SelectSection(list.get(1));
        SyllabusPageObjects syllabusPageObjects=PageFactory.initElements(driver,SyllabusPageObjects.class);
        syllabusPageObjects.GoToSyllabusPage();
        syllabusPageObjects.AddSyllabus();
        syllabusPageObjects.AddResponseSheet();
        syllabusPageObjects.addQuestion();

    }
}
