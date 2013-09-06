package com.educo.tests.TestCases;

import com.educo.tests.Common.Testbase;
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
public class SyllabusPageTests extends Testbase{






    @Test(dataProviderClass = Staticprovider.class,dataProvider = "UsaLogin1")
    public void Syllabustest(String EmailInsUsa,String Password,String Profname) throws Exception {


        UsaLoginPageObjects LoginPagePageobj= PageFactory.initElements(getDriver(), UsaLoginPageObjects.class);
        LoginPagePageobj.openUsaPage();
        LoginPagePageobj.login(EmailInsUsa, Password);
        InsHomePageObjects insHomePageObjects = PageFactory.initElements(getDriver(), InsHomePageObjects.class);
        List<WebElement> list =insHomePageObjects.giveMeAList();
        insHomePageObjects.SelectSection(list.get(1));
        SyllabusPageObjects syllabusPageObjects=PageFactory.initElements(getDriver(),SyllabusPageObjects.class);
        syllabusPageObjects.GoToSyllabusPage();
        syllabusPageObjects.AddSyllabus();
        syllabusPageObjects.AddResponseSheet();
        syllabusPageObjects.addQuestion();

    }
}
