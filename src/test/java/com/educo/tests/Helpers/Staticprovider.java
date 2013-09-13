package com.educo.tests.Helpers;

import com.educo.tests.Common.CommonMethods;
import com.educo.tests.Common.Properties.Properties;
import com.educo.tests.TestCases.StudentLogin;
import jxl.read.biff.BiffException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;

import java.io.IOException;

/**
 * TestNG Parameterized Test - Advance
 * @author mkyong
 *
 */
public  class Staticprovider extends CommonMethods {

    public Staticprovider(WebDriver driver) {
        super(driver);
    }

    //This function will provide the parameter data
    @DataProvider(name = "IndiaLogin")
    public static Object[][] IndiaLoginProvider() {

        return new Object[][]{
                {Properties.usernameIndiains,Properties.passwordInd,Properties.profnameIND }
        };

    }
    @DataProvider(name="UsaLogin1")
    public static final Object[][] UsaLoginProvider1()
    {
        String[] Email = new String[]{Properties.userNameJohn};
        String[] Pwd= new String[]{Properties.passwordJohn};
        String[] proname= new String[]{Properties.profnamejohn} ;
        Object[][] values = new Object[][]{
                { Email[0],Pwd[0],proname[0]  }

        };
        return values  ;
    }

    @DataProvider(name="UsaLogin")
    public static final Object[][] UsaLoginProvider()
    {
        String[] Email = new String[]{Properties.userName};
        String[] Pwd= new String[]{Properties.password};
        String[] proname= new String[]{Properties.profname} ;
        Object[][] values = new Object[][]{
                { Email[0],Pwd[0],proname[0]  }

    };
        return values  ;
    }

    @DataProvider(name="InvalidLogin")
    public static final Object[][] invalidloginProvider()
    {
        return new Object[][]{

                {Properties.usernameIndiains,Properties.passwordInd}
    };



}
    /*@DataProvider(name= "StudentLogin")
    public  static  Object[][] Studentloginprovider() throws IOException, BiffException {
        Object[][] retObjArr= (readExcelSheet("C://Employee.xls"));
           return  retObjArr;


    } */

}
