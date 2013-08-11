package com.educo.tests.Helpers;

import com.educo.tests.Common.Properties.Properties;
import org.testng.annotations.DataProvider;

/**
 * TestNG Parameterized Test - Advance
 * @author mkyong
 *
 */
public  class Staticprovider {

    //This function will provide the parameter data
    @DataProvider(name = "IndiaLogin")
    public static Object[][] IndiaLoginProvider() {

        return new Object[][]{
                {Properties.usernameIndiains,Properties.passwordInd,Properties.profnameIND }

        };

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

}
