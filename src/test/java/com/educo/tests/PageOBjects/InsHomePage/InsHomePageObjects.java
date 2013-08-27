package com.educo.tests.PageOBjects.InsHomePage;


import com.educo.tests.Common.CommonMethods;
import com.educo.tests.Helpers.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InsHomePageObjects extends CommonMethods {


    public static WebDriver driver;
    protected int timeOut = 30;
    public static WebDriverWait wait;
    public  String LOG_FILE = "src\\Test\\REPORT.log";
    //-------------------- ELEMENTS -----------------------

    @FindBy(how = How.ID_OR_NAME,using = "imgGo_10759")
    public static WebElement imgGo_10759;
    @FindBy(how = How.ID_OR_NAME ,using = "imgGo_34044")
    @CacheLookup
    public WebElement imgGo_34044;


    public InsHomePageObjects(WebDriver adriver) {

        super(adriver);
        driver=adriver;
        wait = new WebDriverWait(driver, timeOut);
        driver.manage().window().maximize();
    }

    public void SelectSection(WebElement element)
    {
        waitforFrametoLoad("main");
        WaitforElementToLoadAndClick(element);
        Logger.Log(LOG_FILE,"SelectSection","Select Go button"+element.getAttribute("name"),driver,true);
    }

    //-------------------- SYNC ---------------------------

    public List<WebElement> giveMeAList()
    {
        ArrayList<WebElement> elements = new ArrayList<WebElement>();
        elements.add(imgGo_10759);
        elements.add(imgGo_34044);

        return elements;
    }

}
