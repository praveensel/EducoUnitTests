package com.educo.tests.TestCases;


import com.educo.tests.Common.Testbase;
import com.educo.tests.Helpers.Staticprovider;
import com.educo.tests.PageOBjects.LoginPage.IndialoginPageObjects;
import com.educo.tests.PageOBjects.LoginPage.UsaLoginPageObjects;
import org.json.JSONException;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.Test;


    import com.educo.tests.Helpers.Staticprovider;
    import com.educo.tests.PageOBjects.InsHomePage.InsHomePageObjects;
    import com.educo.tests.PageOBjects.LoginPage.UsaLoginPageObjects;
    import org.openqa.selenium.WebDriver;
    import org.openqa.selenium.WebElement;
    import org.openqa.selenium.firefox.FirefoxDriver;
    import org.openqa.selenium.remote.DesiredCapabilities;
    import org.openqa.selenium.support.PageFactory;
    import org.testng.annotations.*;

import java.io.IOException;
import java.net.MalformedURLException;
    import java.util.List;


    public class InsHomePagetests extends Testbase {



    @Test(dataProviderClass = Staticprovider.class,dataProvider = "UsaLogin")
    public void Sectiontest(String EmailInsUsa,String Password,String Profname ) throws IOException, JSONException {
        if(threadDriver!=null)
        {
            findRemoteip(threadDriver.get());
        }

        InsHomePageObjects insHomePageObjectsI = PageFactory.initElements(getDriver(),  InsHomePageObjects.class);

    UsaLoginPageObjects LoginPagePageobjI = PageFactory.initElements(getDriver(), UsaLoginPageObjects.class);

    LoginPagePageobjI.openUsaPage();
    LoginPagePageobjI.login(EmailInsUsa,Password);
    List<WebElement> list =insHomePageObjectsI.giveMeAList();
    insHomePageObjectsI.SelectSection(list.get(0));

    LoginPagePageobjI.logout();
    }

    }

