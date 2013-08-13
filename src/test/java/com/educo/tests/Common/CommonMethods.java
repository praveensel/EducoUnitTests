package com.educo.tests.Common;

import com.educo.tests.Helpers.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: admin
 * Date: 8/13/13
 * Time: 10:52 AM
 * To change this template use File | Settings | File Templates.
 */
public class CommonMethods {
    public WebDriver driver;
    protected int timeOut = 30;
    public  WebDriverWait wait;
    public  String LOG_FILE = "src\\Test\\REPORT.log";


    public CommonMethods(WebDriver driver)
    {
         this.driver=driver;
        wait = new WebDriverWait(this.driver,timeOut);
    }

    public void Switchtodefaultcontetn() {
        driver.switchTo().defaultContent();
    }
    public void waitforElementtoLoad(WebElement element)
    {
        wait.until(ExpectedConditions.visibilityOf(element));

    }
    public void WaitforElementToLoadAndClick(WebElement element)
    {
        wait.until(ExpectedConditions.visibilityOf(element));
        element.click();
        Logger.Log(LOG_FILE, "WaitforElementToLoadAndClick", "Clicked on element " + element, driver, true);
    }
    //-------------------- SYNC ---------------------------
    public  void waitforFrametoLoad(String Framename)
    {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(Framename));
        Logger.Log(LOG_FILE,"waitforFrametoLoad", "Switching to Frame " + Framename, driver,true);

    }

    public void Mousehover(WebElement element, WebDriver driver)
    {
        Actions actions = new Actions(this.driver);
        WebElement menuHoverLink = element;
        actions.moveToElement(menuHoverLink);
        actions.click();
        actions.perform();

    }

    public void switchframeByElement(WebElement element)
    {
        driver.switchTo().frame(element) ;
    }

    public void ScriptExecutor(WebElement element)
    {
        String script = "document.getElementById(fileClientArticle).value='" + "C:\\\\tmp\\\\file.txt" + "';";

        ((JavascriptExecutor)driver).executeScript(script);
    }

    public void VerifyTextPresent(String exp,String act)
    {
        if (!exp.contains(act)) {
            System.out.println("verifyTextPresent failed");
            System.out.println("Expected is" + exp  +"Actual is"+act);

        }


    }



    public void sendtext(WebElement element,String text)
    {
        element.clear();
        element.sendKeys(text);
    }

    public void FramesetSwitch(String Framename1)
    {
        List<WebElement> frameset = driver.findElements(By.tagName("frame"));
        if(frameset.size()>0)
            for (WebElement framename : frameset)

            {
                String f = framename.getAttribute("id");
                System.out.println("frameid: " + f);
                //driver.switchTo().frame(f);
                if (f.equals(Framename1)) {
                    WebElement t=driver.findElement(By.id(f));
                    driver.switchTo().frame(t) ;
                    System.out.println("Switching to frame " + f);
                    break;
                }


            }

    }
}