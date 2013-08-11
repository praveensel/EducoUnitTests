package com.educo.tests.PageOBjects.InsHomePage;


import com.educo.tests.Helpers.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InsHomePageObjects {


    public static WebDriver driver;
    protected int timeOut = 30;
    public static WebDriverWait wait;
    public  String LOG_FILE = "src\\Test\\REPORT.log";
    //-------------------- ELEMENTS -----------------------

    @FindBy(how = How.ID_OR_NAME,using = "imgGo_10759")
    public static WebElement SecGobutton;


    public InsHomePageObjects(WebDriver adriver) {

        driver=adriver;
        wait = new WebDriverWait(driver, timeOut);
        PageFactory.initElements(driver, this);
        driver.manage().window().maximize();
    }

    public void SelectSection()
    {
        waitforFrametoLoad("main");
        waitforElementtoLoad(SecGobutton);
        SecGobutton.click();
    }
    public void waitforElementtoLoad(WebElement element)
    {
        wait.until(ExpectedConditions.visibilityOf(element));

    }
    //-------------------- SYNC ---------------------------
    public void waitforFrametoLoad(String Framename)
    {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(Framename));
        Logger.Log(LOG_FILE, "Switching to Frame" + Framename, driver);

    }

}
