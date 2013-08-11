    package com.educo.tests.PageOBjects.LoginPage;


    import com.educo.tests.Helpers.Credentials;
    import com.educo.tests.Helpers.Logger;
    import org.openqa.selenium.WebDriver;
    import org.openqa.selenium.WebElement;
    import org.openqa.selenium.support.CacheLookup;
    import org.openqa.selenium.support.FindBy;
    import org.openqa.selenium.support.How;
    import org.openqa.selenium.support.ui.ExpectedConditions;
    import org.openqa.selenium.support.ui.WebDriverWait;


    public class UsaLoginPageObjects  {



    //-------------------- ELEMENTS -----------------------
    @FindBy(how = How.NAME, using = "ctl00$escontent$txtUserName")
    @CacheLookup
    public  WebElement userInput;

    @FindBy(how = How.NAME, using = "ctl00$escontent$txtPassword") @CacheLookup
    public    WebElement passwordInput;

    @FindBy(how = How.ID_OR_NAME, using = "LnkForgotPassword") @CacheLookup
    public    WebElement resetPasswordLink;

    @FindBy(how = How.NAME, using = "ctl00$escontent$btnGo")@CacheLookup
    public    WebElement loginButton;

    @FindBy(how = How.ID_OR_NAME, using = "ECFMenu1-menuItem012")@CacheLookup
    public    WebElement logoutlink;

    @FindBy(how = How.ID, using = "ECFBanner1_lblUName")@CacheLookup
    public    WebElement Bannername;

    @FindBy(how=How.CLASS_NAME , using = "errormsg") @CacheLookup
    public   WebElement ErrorLabel;

    public  WebDriver driver;
    protected int timeOut = 30;
    public   WebDriverWait wait;
    public  String LOG_FILE = "src\\Test\\REPORT.log";
    //-------------------- ELEMENTS -----------------------

    //-------------------- CONSTRUCTOR --------------------
    public  UsaLoginPageObjects(WebDriver adriver) {
     driver=adriver;
     wait = new WebDriverWait(driver, timeOut);
    // PageFactory.initElements(driver, this);
    driver.manage().window().maximize();
    }
    //-------------------- CONSTRUCTOR --------------------


    //-------------------- USER ACTIONS -------------------
    public void typeInUserName(String username){


    waitforElementtoLoad(userInput);
    userInput.clear();
    userInput.sendKeys(username);
    Logger.Log(LOG_FILE, "Inputting << " + username + " >> in the username field... ", driver);
    // return driver;
    }
    public void typeInPassword(String password){

    waitforElementtoLoad(passwordInput);
    passwordInput.clear();
    passwordInput.sendKeys(password);
    //   Logger.Log(LOG_FILE, "Inputting << "+password+" >> in the password field... ",driver);
    }
    public void clickLoginButton(){

    waitforElementtoLoad(loginButton);
    loginButton.click();
    Logger.Log(LOG_FILE, "Clicking << LOGIN >> button... ",driver);

    }

    public  void openUsaPage()
    {
    driver.get(Credentials.USA_URL);

    }



    //Login method for logging into both usa and india portal
    public  void login(String name, String pass){

    typeInUserName(name);
    typeInPassword(pass);
    clickLoginButton();

    }





    public  void logout()
    {
    String CurretnUrl = driver.getCurrentUrl();
    if(CurretnUrl.equals("https://www.educosoft.com/Common/ECFIndex.aspx"))
       driver.switchTo().defaultContent();
    waitforElementtoLoad(logoutlink);
    logoutlink.click();
    }


    // Logs in and verify the Instructor name matches with email for USA portal
    public  void loginAndVerifyUSA(String EmailUsaIns, String pass,String Name){

    openUsaPage();
    System.out.println("openusa");
    login(EmailUsaIns, pass);
    System.out.println("login");
    verifyUserLoggedIn(Name);
    }

    // Logs in and verify the Instructor name matches with email for India portal




    public  void verifyUserLoggedIn(String name)
    {
    driver.switchTo().defaultContent();
         waitforElementtoLoad(Bannername);
         String Proffessorname=Bannername.getText();
         if (Proffessorname.equals(name))
        {
          //  Logger.Log(LOG_FILE,"Name matches",driver);
            System.out.println("Name matches"+name+Proffessorname);

        }

    }
    public  void waitforElementtoLoad(WebElement element)
    {
    wait.until(ExpectedConditions.visibilityOf(element));

    }
    //-------------------- SYNC ---------------------------
    public  void waitforFrametoLoad(String Framename)
    {
    wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(Framename));
    Logger.Log(LOG_FILE, "Switching to Frome"+Framename,driver);

    }
    //-------------------- USER ACTIONS -------------------

    //-------------------- SYNC ---------------------------


    public  void invalidlogin(String name, String pass)
    {
       openUsaPage();
       login(name,pass);
       waitforElementtoLoad(ErrorLabel);
       String ExpectedErrromesage="Invalid user credentials...!!! Please check your Username and Password.";
       String ActualErrormsg=ErrorLabel.getText();
       if(ActualErrormsg.equals(ExpectedErrromesage))
       {
          Logger.Log(LOG_FILE,"Error message matches",driver);
           Logger.Log(LOG_FILE,"Expected"+ExpectedErrromesage+"Actual"+ActualErrormsg,driver);
       }
    }
    }




