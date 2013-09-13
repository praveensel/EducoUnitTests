package com.educo.tests.Common;

import com.educo.tests.Helpers.Logger;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
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
        Logger.Log(LOG_FILE, "Switchtodefaultcontetn", "Switching to default content", driver, true);
    }
    public void waitforElementtoLoad(WebElement element)
    {
        wait.until(ExpectedConditions.visibilityOf(element));
        Logger.Log(LOG_FILE,"waitforElementtoLoad","Waiting for " +element.getAttribute("id")+ " element to load",driver,true);

    }
    public void WaitforElementToLoadAndClick(WebElement element)
    {
        wait.until(ExpectedConditions.visibilityOf(element));
        Logger.Log(LOG_FILE,"waitandClick","Clicking element " +element.getAttribute("id"),driver,true);
        element.click();


    }
    //-------------------- SYNC ---------------------------
    public  void waitforFrametoLoad(String Framename)
    {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(Framename));
        Logger.Log(LOG_FILE,"waitforFrametoLoad", "Switching to Frame " + Framename, driver,true);

    }

    public void Mousehover(WebElement element)
    {
        Actions actions = new Actions(this.driver);
        WebElement menuHoverLink = element;
        actions.moveToElement(menuHoverLink);
        actions.click();
        actions.perform();

    }

    public void clickatPosistion()
    {
        Actions builder = new Actions(this.driver);
       Action Movetoxy=builder.moveByOffset(161, 410)

               .build();

      Movetoxy.perform();

        ;
    }

    public void getELocation(WebElement element)
    {
       Point loc= element.getLocation();
      Dimension Size=  element.getSize();
        System.out.println(loc);
        System.out.println(Size);

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
    //----------------Click a button or a Link--------------------------
    public void ClickButtonOrLink(WebElement element)
    {
        waitforElementtoLoad(element);
        element.click();
    }


    //----------------Send text to a textbox--------------------------
    public void sendtext(WebElement element,String text)
    {
        waitforElementtoLoad(element);
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
    public static String[][] readExcelSheet(String destFile) throws IOException, BiffException {
        File excelSheet = null;
        Workbook workbook = null;

        String[][] email = null;


        Workbook wb = Workbook.getWorkbook(new File(destFile));
        System.out.println(wb.getNumberOfSheets());
        Sheet sheet = wb.getSheet("UserLogins");
        int sRow,sCol, eRow, eCol,ci,cj;
        int columns = sheet.getColumns();
        int rows = sheet.getRows();
        String[][] tabArray=null;
        sRow=1;
        sCol=0;
        // Cell tableEnd= sht.findCell(tbName, sCol+1,sRow+1, 100, 64000, false);
        eRow=19;
        eCol=3;
        System.out.println("startRow="+sRow+", endRow="+eRow+", " + "startCol="+sCol+", endCol="+eCol);
        tabArray=new String[eRow-sRow-1][eCol-sCol-1];
        ci=0;
        for (int i=sRow+1;i<eRow;i++,ci++){
            cj=0;
            for (int j=sCol+1;j<eCol;j++,cj++){
                tabArray[ci][cj]=sheet.getCell(j,i).getContents();
            }
        }
        return tabArray;}
    //----------------Open a WebPage--------------------------
    public void OpenWebPage(String URL)
    {
        driver.get(URL);
    }
}
