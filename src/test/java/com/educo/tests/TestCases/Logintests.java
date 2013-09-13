package com.educo.tests.TestCases;


import com.educo.tests.Common.Testbase;
import com.educo.tests.Helpers.Staticprovider;
import com.educo.tests.PageOBjects.LoginPage.IndialoginPageObjects;
import com.educo.tests.PageOBjects.LoginPage.UsaLoginPageObjects;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.Test;


public class Logintests extends Testbase {



    @Test(dataProviderClass = Staticprovider.class, dataProvider = "UsaLogin")
    public void Login_As_Instructor_USA(String EmailInsUsa, String Password, String Profname) throws Exception {


        if(threadDriver.get()!=null)
        {
            findRemoteip(threadDriver.get());
        }

        UsaLoginPageObjects usapage = PageFactory.initElements(getDriver(), UsaLoginPageObjects.class);
        usapage.loginAndVerifyUSA(EmailInsUsa, Password, Profname);
        usapage.logout();


    }

    @Test(dataProviderClass = Staticprovider.class, dataProvider = "IndiaLogin")
    public void Login_As_Instructor_India(String EmailInsIndia, String Password, String Profname) throws Exception {
        if(threadDriver!=null)
        {
            findRemoteip(threadDriver.get());
        }

        IndialoginPageObjects LoginPagePageobj1 = PageFactory.initElements(getDriver(), IndialoginPageObjects.class);
        LoginPagePageobj1.loginAndVerifyIndia(EmailInsIndia, Password, Profname);
        LoginPagePageobj1.logout();

    }

    @Test(dataProviderClass = Staticprovider.class, dataProvider = "InvalidLogin")
    public void InvalidLoginPromptTest(String uName, String Password) throws Exception {

        if(threadDriver!=null)
        {
           findRemoteip(threadDriver.get());
            threadDriver.get().setFileDetector(new LocalFileDetector());
        }


        UsaLoginPageObjects usapage1 = PageFactory.initElements(getDriver(), UsaLoginPageObjects.class);
        usapage1.invalidlogin("ed@test.com", "Password");



    }


}





