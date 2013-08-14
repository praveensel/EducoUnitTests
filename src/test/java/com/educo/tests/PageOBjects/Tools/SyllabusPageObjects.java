package com.educo.tests.PageOBjects.Tools;

import com.educo.tests.Common.CommonMethods;
import com.educo.tests.Helpers.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

/**
 * Created with IntelliJ IDEA.
 * User: admin
 * Date: 8/7/13
 * Time: 3:55 PM
 * To change this template use File | Settings | File Templates.
 */
public class SyllabusPageObjects extends CommonMethods{

    public  WebDriver driver;
    protected int timeOut = 30;
    public static WebDriverWait wait;
    public  String LOG_FILE = "src\\Test\\REPORT.log";

    @FindBy(how = How.ID_OR_NAME, using = "lblSyllabusHdr")
    @CacheLookup
    public WebElement  Syallbusheader;
    @FindBy(how = How.XPATH, using = "//a[contains(.,'Syllabus')]")
    @CacheLookup
    public WebElement  Syllabustab;

    @FindBy(how = How.ID_OR_NAME, using = "btnAddSyllabus")
    @CacheLookup
    public WebElement  btnAddSyllabus;

    @FindBy(how = How.ID_OR_NAME ,using = "btnImport")
    @CacheLookup
    public WebElement btnImport;

    @FindBy(how = How.ID_OR_NAME ,using = " btnDel")
    @CacheLookup
    public WebElement  btnDel;
    
    @FindBy(how = How.ID_OR_NAME ,using = "txtSyllabusName")
    @CacheLookup
    public WebElement SyllabusTitletxtbox;
    
    @FindBy(how = How.ID_OR_NAME ,using = "txtAuthorName")
    @CacheLookup
    public WebElement Authornaemtxtbox;

    @FindBy(how = How.ID_OR_NAME ,using = "txtSyllabusDesc")
    @CacheLookup
    public WebElement SyllDesctxtbox;

    @FindBy(how = How.ID_OR_NAME ,using = "fileClientArticle")
    @CacheLookup
    public WebElement Uploadbox;

    @FindBy(how = How.ID_OR_NAME ,using = "btnFileAdd")
    @CacheLookup
    public WebElement Uploadbutton;
    
    @FindBy(how = How.ID_OR_NAME ,using = "cboResponseSheet")
    @CacheLookup
    public WebElement ResposeSheet;
    
    @FindBy(how = How.ID_OR_NAME ,using = "chkResponsesheet")
    @CacheLookup
    public WebElement chkResponsesheet;
    
    @FindBy(how = How.ID_OR_NAME ,using = "btnOk")
    @CacheLookup
    public WebElement addsyllbusbtnOK;
    
    @FindBy(how = How.ID_OR_NAME ,using = "")
    @CacheLookup
    public WebElement btnCancel;

    @FindBy(how = How.ID_OR_NAME ,using = "txtSurveyName")
    @CacheLookup
    public WebElement SurveyName;
    @FindBy(how = How.ID_OR_NAME ,using = "btnCreate")
    @CacheLookup
    public WebElement btnCreateSurvey;
    @FindBy(how = How.ID_OR_NAME ,using = "frmRightbtnAddQn")
    @CacheLookup
    public WebElement frmRightbtnAddQn;
    @FindBy(how = How.ID_OR_NAME ,using = "btnEditQn")
    @CacheLookup
    public WebElement btnEditQn;

    @FindBy(how = How.ID_OR_NAME ,using = "btnDelQn")
    @CacheLookup
    public WebElement btnDelQn;

    @FindBy(how = How.ID_OR_NAME ,using = "btnTestPprTitle")
    @CacheLookup
    public WebElement btnTestPprTitle;

    @FindBy(how = How.ID_OR_NAME ,using = "btnTestPreview")
    @CacheLookup
    public WebElement btnTestPreview;

    @FindBy(how = How.ID_OR_NAME ,using = "btnOk")
    @CacheLookup
    public WebElement btnOkRS;

    @FindBy(how = How.ID_OR_NAME ,using = "cboQuesType")
    @CacheLookup
    public WebElement cboQuesType;

    @FindBy(how = How.ID_OR_NAME ,using = "ECFMenu1-menuItem002")
    @CacheLookup
    public WebElement ToolsMenu;

    @FindBy(how = How.ID_OR_NAME ,using = "ECFMenu1-menuItem002-subMenu-menuItem000")
    @CacheLookup
    public WebElement SyllabusSubMenu;
    
    @FindBy(how = How.ID_OR_NAME ,using = "Label1")
    @CacheLookup
    public WebElement AddEditSy;

    @FindBy(how = How.XPATH ,using = "//*[@id=\"lblAssTitle\"]")
    @CacheLookup
    public WebElement ResponseSheetTitle;

    @FindBy(how = How.ID_OR_NAME ,using = "btnAddQn")
    @CacheLookup
    public WebElement AddQuestion;

    @FindBy(how = How.ID_OR_NAME ,using = "lblQuestcapt")
    @CacheLookup
    public WebElement lblQuestcapt;

    @FindBy(how = How.XPATH ,using = "//html/body")
    @CacheLookup
    public WebElement MultpleChcQstnTxtBox;

    @FindBy(how = How.ID_OR_NAME ,using = "options")
    @CacheLookup
    public WebElement QstnOptionstab;

    @FindBy(how = How.ID_OR_NAME ,using = "txtNoOptions")
    @CacheLookup
    public WebElement txtNoOptions;
    
    @FindBy(how = How.ID_OR_NAME ,using = "dgdAnsopt_ctl02_txtOptText")
    @CacheLookup
    public WebElement answerbox2;

    @FindBy(how = How.ID_OR_NAME ,using = "dgdAnsopt_ctl03_txtOptText")
    @CacheLookup
    public WebElement answerbox3;

    @FindBy(how = How.ID_OR_NAME ,using = "dgdAnsopt_ctl04_txtOptText")
    @CacheLookup
    public WebElement answerbox4;
    @FindBy(how = How.ID_OR_NAME ,using = "dgdAnsopt_ctl05_txtOptText")
    @CacheLookup
    public WebElement answerbox5;

    @FindBy(how = How.ID_OR_NAME ,using = "dgdAnsopt_ctl06_txtOptText")
    @CacheLookup
    public WebElement answerbox6;

    @FindBy(how = How.ID_OR_NAME ,using = "btnSave")
    @CacheLookup
    public WebElement btnSaveQstn;

    @FindBy(how = How.ID_OR_NAME ,using = "A2")
    @CacheLookup
    public WebElement ResponseSheettab;

    @FindBy(how = How.XPATH ,using = "//input[@value='Save Response Sheet']")
    @CacheLookup
    public WebElement SaveResponseSheet;



    public SyllabusPageObjects(WebDriver driver) {
        super(driver);
        this.driver = driver;
        wait = new WebDriverWait(this.driver,timeOut);
        driver.manage().window().maximize();
    }
    /**
     Add Syllabus form Tools\Syllabus Page
     */
     public void AddSyllabus()  throws Exception
     {


         try {
             waitforFrametoLoad("main");
             WaitforElementToLoadAndClick(btnAddSyllabus);
             try {
                 Assert.assertEquals(AddEditSy.getText(), "Add/Edit Syllbus");
             } catch (AssertionError e) {

                 Logger.Log(LOG_FILE,"Exception in method ",e.getMessage(),driver,false);
             }
             SyllabusTitletxtbox.sendKeys("test1");
             Authornaemtxtbox.sendKeys("test");
             SyllDesctxtbox.sendKeys("desc");
             Uploadbox.sendKeys("C:\\tmp\\file.txt");
             Uploadbutton.click();
             addsyllbusbtnOK.click();
         } catch (Exception e) {
             e.getClass();
             e.getLocalizedMessage();
             Logger.Log(LOG_FILE,"Exception in method "+e.getMessage()+e.getStackTrace().getClass(),e.getLocalizedMessage(),driver,false);
         }

     }

    public  void GoToSyllabusPage()
    {
        driver.switchTo().defaultContent();
        Mousehover(ToolsMenu);
        Mousehover(SyllabusSubMenu);
    }
    public  void AddResponseSheet()
    {
        driver.switchTo().defaultContent();
        waitforFrametoLoad("main");
        waitforElementtoLoad(ResponseSheettab);
        ResponseSheettab.click();
        String Survenme="TestResponseSheet";
        sendtext(SurveyName,Survenme);
        btnCreateSurvey.click();
        FramesetSwitch("frmLeft");
        String Responsesheettitlestr=ResponseSheetTitle.getText();
        VerifyTextPresent(Responsesheettitlestr,Survenme);



    }

    public void addQuestion()
    {
        driver.switchTo().defaultContent();
        waitforFrametoLoad("main");
        FramesetSwitch("frmRight");
        AddQuestion.click();
        waitforFrametoLoad("main");
        boolean result=lblQuestcapt.getText().contains("Question Description");
        waitforFrametoLoad("RadEditor2_contentIframe");
        waitforElementtoLoad(MultpleChcQstnTxtBox);
        sendtext(MultpleChcQstnTxtBox, "Q1rrrrrr");
        Switchtodefaultcontetn();
        waitforFrametoLoad("main");
        QstnOptionstab.click();
        boolean result1=txtNoOptions.getText().contains("5");
        sendtext(answerbox2,"ans1");
        sendtext(answerbox3,"ans2");
        sendtext(answerbox4,"ans3");
        sendtext(answerbox5,"ans4");
        sendtext(answerbox6,"ans4");
        btnSaveQstn.click();
        Switchtodefaultcontetn();
        waitforFrametoLoad("main");
        FramesetSwitch("frmRight");
        SaveResponseSheet.click();

    }



}