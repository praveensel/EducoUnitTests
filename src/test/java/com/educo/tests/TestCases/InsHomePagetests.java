    package com.educo.tests.TestCases;


    import com.educo.tests.Helpers.Staticprovider;
    import com.educo.tests.PageOBjects.InsHomePage.InsHomePageObjects;
    import com.educo.tests.PageOBjects.LoginPage.UsaLoginPageObjects;
    import org.openqa.selenium.WebDriver;
    import org.openqa.selenium.WebElement;
    import org.openqa.selenium.firefox.FirefoxDriver;
    import org.openqa.selenium.remote.DesiredCapabilities;
    import org.openqa.selenium.support.PageFactory;
    import org.testng.annotations.*;

    import java.net.MalformedURLException;
    import java.util.List;


    public class InsHomePagetests {

    public WebDriver driver;
    @Parameters({"browser"})

    @BeforeClass
    public void setup(@Optional("firefox")String browser) throws MalformedURLException, InterruptedException {
    com.educo.tests.Common.Properties.Properties.setProperties();
        System.setProperty("org.uncommons.reportng.stylesheet","C://Custommcss//report.css");
    DesiredCapabilities capability=null;

    if(browser.equalsIgnoreCase("chrome")){
    System.out.println("chrome");
        System.setProperty("webdriver.chrome.driver", "C://ChromeDriver//chromedriver.exe");
    capability= DesiredCapabilities.chrome();
    capability.setBrowserName("chrome");
    capability.setPlatform(org.openqa.selenium.Platform.ANY);
    //capability.setVersion("");
    }

    if(browser.equalsIgnoreCase("Firefox")){
    System.out.println("Firefox");
    capability= DesiredCapabilities.firefox();
    capability.setBrowserName("firefox");
    capability.setPlatform(org.openqa.selenium.Platform.WINDOWS);
    driver=new FirefoxDriver();
    }
        System.setProperty("webdriver.chrome.driver", "C://ChromeDriver//chromedriver.exe");
    //driver = new RemoteWebDriver(new URL("http://192.168.100.85:5555/wd/hub"), capability);


    }

    @Test(dataProviderClass = Staticprovider.class,dataProvider = "UsaLogin")
    public void Sectiontest(String EmailInsUsa,String Password,String Profname )
    {

    InsHomePageObjects insHomePageObjectsI = PageFactory.initElements(driver,  InsHomePageObjects.class);

    UsaLoginPageObjects LoginPagePageobjI = PageFactory.initElements(driver, UsaLoginPageObjects.class);

    LoginPagePageobjI.openUsaPage();
    LoginPagePageobjI.login(EmailInsUsa,Password);
    List<WebElement> list =insHomePageObjectsI.giveMeAList();
    insHomePageObjectsI.SelectSection(list.get(0));

    LoginPagePageobjI.logout();
    }


    @AfterMethod
    public void close()
    {

    }


    }
