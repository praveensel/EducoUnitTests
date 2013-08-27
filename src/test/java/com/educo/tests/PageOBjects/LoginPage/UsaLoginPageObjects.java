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


    public class UsaLoginPageObjects extends CommonMethods {



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
     super(adriver);
     driver=adriver;
     wait = new WebDriverWait(driver, timeOut);
     driver.manage().window().maximize();
    }
    //-------------------- CONSTRUCTOR --------------------


    //-------------------- USER ACTIONS -------------------
    public void typeInUserName(String username){


     sendtext(userInput,username);
     Logger.Log(LOG_FILE, "typeInUserName", "Inputting << " + username + " >> in the username field... "+userInput.getAttribute("name"), driver, true);

    }
    public void typeInPassword(String password){

        sendtext(passwordInput,password);
        Logger.Log(LOG_FILE, "typeInPassword", "Inputting << " + password + " >> in the password field... "+passwordInput.getAttribute("name"), driver, true);
    }
    public void clickLoginButton(){

        WaitforElementToLoadAndClick(loginButton);
        Logger.Log(LOG_FILE, "clickLoginButton", "Clicking "+loginButton.getAttribute("name")+" button... ", driver, true);
    }

    public  void openUsaPage()
    {
        OpenWebPage(Credentials.USA_URL);
        Logger.Log(LOG_FILE,"openIndiaPage","Opening URL "+Credentials.USA_URL,driver,true);

    }



    //Login method for logging into both usa and india portal
    public  void login(String name, String pass){

    typeInUserName(name);
    typeInPassword(pass);
    clickLoginButton();

    }





    public  void logout()
    {
        String CurrentUrl = driver.getCurrentUrl();
        if (CurrentUrl.equals("https://www.educosoft.com/Common/ECFIndex.aspx"))
        {
            Switchtodefaultcontetn();
            WaitforElementToLoadAndClick(logoutlink);
            Logger.Log(LOG_FILE,"logout","Verify URL and Log out",driver,true);  }
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
         Switchtodefaultcontetn();
         waitforElementtoLoad(Bannername);
         String Proffessorname=Bannername.getText();
         if (Proffessorname.equals(name))
        {
          //  Logger.Log(LOG_FILE,"Name matches",driver);
            System.out.println("Name matches"+name+Proffessorname);

        }

    }

    //-------------------- SYNC ---------------------------

    //-------------------- USER ACTIONS -------------------

    //-------------------- SYNC ---------------------------


    public  void invalidlogin(String name, String pass)
    {
       openUsaPage();
       login(name,pass);
       waitforElementtoLoad(ErrorLabel);
       String ExpectedErrromesage="Invalid user credentials...!!! Please check your Username and Password.";
       String ActualErrormessage=ErrorLabel.getText();
        getELocation(ErrorLabel);
       if(ActualErrormessage.equals(ExpectedErrromesage))
       {
          Logger.Log(LOG_FILE,"invalidlogin","Error message matches",driver,true);
           Logger.Log(LOG_FILE,"invalidlogin","Expected"+ExpectedErrromesage+"Actual"+ActualErrormessage,driver,true);
       }
    }
    }




