package com.educo.tests.PageOBjects.LoginPage;


import com.educo.tests.Common.CommonMethods;
import com.educo.tests.Helpers.Credentials;
import com.educo.tests.Helpers.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class IndialoginPageObjects extends CommonMethods {


    //-------------------- ELEMENTS -----------------------
    @FindBy(how = How.NAME, using = "ctl00$escontent$txtUserName")
    @CacheLookup
    public WebElement userInput;
    @FindBy(how = How.NAME, using = "ctl00$escontent$txtPassword")@CacheLookup
    public WebElement passwordInput;
    @FindBy(how = How.ID_OR_NAME, using = "LnkForgotPassword") @CacheLookup
    public WebElement resetPasswordLink;
    @FindBy(how = How.NAME, using = "ctl00$escontent$btnGo")  @CacheLookup
    public WebElement loginButton;
    @FindBy(how = How.ID_OR_NAME, using = "ECFMenu1-menuItem012") @CacheLookup
    public WebElement logoutlink;
    @FindBy(how = How.ID, using = "ECFBanner1_lblUName")  @CacheLookup
    public WebElement Bannername;
    @FindBy(how=How.ID_OR_NAME,using="btnContinue")  @CacheLookup
    public  WebElement btnContinue;
    public WebDriver driver;
    public WebDriverWait wait;
    public String LOG_FILE = "src\\Test\\REPORT.log";
    protected int timeOut = 30;
    //-------------------- ELEMENTS -----------------------

    //-------------------- CONSTRUCTOR --------------------
    public IndialoginPageObjects(WebDriver adriver) {
        super(adriver);

        driver = adriver;
        wait = new WebDriverWait(driver, timeOut);
        driver.manage().window().maximize();

    }
    //-------------------- CONSTRUCTOR --------------------

    //-------------------- USER ACTIONS -------------------
    public void typeInUserName(String username) {

       sendtext(userInput,username);
       Logger.Log(LOG_FILE, "typeInUserName", "Inputting << " + username + " >> in the username field... "+userInput.getAttribute("name"), driver, true);

    }

    public void typeInPassword(String password) {

      sendtext(passwordInput,password);
      Logger.Log(LOG_FILE, "typeInPassword", "Inputting << " + password + " >> in the password field... "+passwordInput.getAttribute("name"), driver, true);
    }

    public void clickLoginButton() {

        Logger.Log(LOG_FILE, "clickLoginButton", "Clicking "+loginButton.getAttribute("name")+" button... ", driver, true);
        WaitforElementToLoadAndClick(loginButton);


    }


    //Login method for logging into both usa and india portal
    public void login(String name, String pass) {

        typeInUserName(name);
        typeInPassword(pass);
        clickLoginButton();
        System.out.println(driver.getTitle());

        if(driver.getTitle().equalsIgnoreCase("Educosoft Requirements"))
        { passReqpage();}

    }

    public void passReqpage()
    {

        WaitforElementToLoadAndClick(btnContinue);
    }


    public void logout() {
        String CurrentUrl = driver.getCurrentUrl();
        if (CurrentUrl.equals("https://www.educosoft.com/Common/ECFIndex.aspx"))
        {
        Switchtodefaultcontetn();
        WaitforElementToLoadAndClick(logoutlink);
            Logger.Log(LOG_FILE,"logout","Clicked on Logout element",driver,true);
            Logger.Log(LOG_FILE,"logout","Verify URL and Log out",driver,true);  }
    }


    // Logs in and verify the Instructor name matches with email for USA portal

    // Logs in and verify the Instructor name matches with email for India portal
    public void loginAndVerifyIndia(String EmailUsaIns, String pass, String Name) {

        openIndiaPage();
        login(EmailUsaIns, pass);
        verifyUserLoggedIn(Name);
    }

    private void openIndiaPage() {

        OpenWebPage(Credentials.India_URL);
        Logger.Log(LOG_FILE,"openIndiaPage","Opening URL "+Credentials.India_URL,driver,true);
    }

    public void verifyUserLoggedIn(String name) {

        waitforElementtoLoad(Bannername);
        String Proffessorname = Bannername.getText();
        if (Proffessorname.equals(name)) {
            Logger.Log(LOG_FILE,"verifyUserLoggedIn","Checks Logged in User name Matches "+"Actual name\n"+ name +"\nExpected name"+ Proffessorname,driver,true);
            System.out.println("Name matches" + name + Proffessorname);
        }

    }



    //-------------------- SYNC ---------------------------


    }
    //-------------------- USER ACTIONS -------------------

    //-------------------- SYNC ---------------------------





