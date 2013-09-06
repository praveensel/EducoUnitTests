package com.educo.tests.Helpers;

import com.opera.core.systems.OperaDriver;
import org.openqa.selenium.Platform;
import org.openqa.selenium.UnsupportedCommandException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * A singleton style manager to maintain Drivers to prevent
 * test slowdown for creating a browser for each class with tests.
 *
 * Also counts time to start a browser and extrapolates from that how much
 * time you have saved using such hacky code.
 */
public class Driver extends Thread{
    private static WebDriver aDriver=null;
    private static long browserStartTime = 0L;
    private static long savedTimecount = 0L;
    public static final long DEFAULT_TIMEOUT_SECONDS = 10;
    private static boolean avoidRecursiveCall=false;
    public static String BROWSER_PROPERTY_NAME = "selenium2basics.webdriver";


    public enum BrowserName{FIREFOX, GOOGLECHROME, SAUCELABS, OPERA, IE, HTMLUNIT, SAFARI}

    public static BrowserName currentDriver;

    private static BrowserName useThisDriver = null;

    // default for browsermob localhost:8080
    // default for fiddler: localhost:8888
    public static String PROXY="localhost:8080";

    public static void set(BrowserName aBrowser){
        useThisDriver = aBrowser;

        // close any existing driver
        if(aDriver != null){
            aDriver.quit();
            aDriver = null;
        }
    }

    public static WebDriver get() {

        if(useThisDriver == null){
            String defaultBrowser="FIREFOX";
            if (System.getProperty("bro") != null)
                defaultBrowser=System.getProperty("bro");

           // String defaultBrowser = System.getProperty(BROWSER_PROPERTY_NAME, "FIREFOX");
            if (defaultBrowser.equals("FIREFOX")) {
                useThisDriver = BrowserName.FIREFOX;

            } else if (defaultBrowser.equals("CHROME")) {
                useThisDriver = BrowserName.GOOGLECHROME;

            } else if (defaultBrowser.equals("IE")) {
                useThisDriver = BrowserName.IE;

            } else if (defaultBrowser.equals("OPERA")) {
                useThisDriver = BrowserName.OPERA;

            } else if (defaultBrowser.equals("SAFARI")) {
                useThisDriver = BrowserName.SAFARI;

            } else if (defaultBrowser.equals("SAUCELABS")) {
                useThisDriver = BrowserName.SAUCELABS;

            } else if (defaultBrowser.equals("HTMLUNIT")) {
                useThisDriver = BrowserName.HTMLUNIT;

            } else {
                throw new RuntimeException("Unknown Browser in " + BROWSER_PROPERTY_NAME + ": " + defaultBrowser);
            }

        }


        if(aDriver==null){


            long startBrowserTime = System.currentTimeMillis();

            switch (useThisDriver) {
                case FIREFOX:
                    FirefoxProfile profile = new FirefoxProfile();
                    profile.setEnableNativeEvents(true);

                    aDriver = new FirefoxDriver();//profile);
                    currentDriver = BrowserName.FIREFOX;
                    break;

                case OPERA:

                    aDriver = new OperaDriver();
                    currentDriver = BrowserName.OPERA;
                    break;

                case HTMLUNIT:

                    aDriver = new HtmlUnitDriver();
                    currentDriver = BrowserName.HTMLUNIT;
                    break;

                case IE:
                    if(System.getProperty("os.name").toLowerCase().contains("win")){
                        setDriverPropertyIfNecessary("webdriver.ie.driver", "/../resources/drivers/iedriver/IEDriverServer_2.33.0_x86.exe", "C://Dev//Drivers//IEDriverServer_2.33.0_x86.exe");
                        DesiredCapabilities ieCapabilities = new DesiredCapabilities();
                        ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
                        ieCapabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

                        aDriver = new InternetExplorerDriver(ieCapabilities);
                        currentDriver = BrowserName.IE;
                    }
                    else{
                        System.out.println("Script is running on a non-windows platform that can't use IE.");// TBR when GRID2 will be implemented
                        profile = new FirefoxProfile();
                        profile.setEnableNativeEvents(true);

                        aDriver = new FirefoxDriver();
                        currentDriver = BrowserName.FIREFOX;
                    }
                    break;

                case SAFARI:

                    aDriver = new SafariDriver();//profile);
                    currentDriver = BrowserName.SAFARI;
                    break;

                case GOOGLECHROME:

                    System.setProperty("webdriver.chrome.driver","D://selnium//chromedriver.exe");

                    if (System.getProperty("os.name").equals("mac"))
                        setDriverPropertyIfNecessary("webdriver.chrome.driver","/../resources/chromedriver/chromedriver_mac","/Volumes/Data HD/GitZone/NAISauto/NAISauto/src/test/resources/chromedriver_mac");
                    else if(System.getProperty("os.name").toLowerCase().contains("win")){
                        setDriverPropertyIfNecessary("webdriver.chrome.driver","/../resources/chromedriver/chromedriver_win.exe","C:\\DEV\\Drivers\\chromedriver_win.exe");
                    }
                    else if(System.getProperty("os.name").equals("nix"))
                        setDriverPropertyIfNecessary("webdriver.chrome.driver","/../resources/chromedriver/chromedriver_nix","/Volumes/Data HD/GitZone/NAISauto/NAISauto/src/test/resources/chromedriver_nix");

                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("disable-plugins");
                    options.addArguments("disable-extensions");
                    options.addArguments("disable-logging");
                    aDriver = new ChromeDriver(options);

                    currentDriver = BrowserName.GOOGLECHROME;
                    break;

                case SAUCELABS:

                    DesiredCapabilities capabilities = DesiredCapabilities.firefox();
                    capabilities.setCapability("version", "5");
                    capabilities.setCapability("platform", Platform.XP);
                    try {
                        // add url to environment variables to avoid releasing with source
                        String sauceURL = System.getenv("SAUCELABS_URL");
                        aDriver = new RemoteWebDriver(
                                new URL(sauceURL),
                                capabilities);
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                    currentDriver = BrowserName.SAUCELABS;
                    break;
            }


            long browserStartedTime = System.currentTimeMillis();
            browserStartTime = browserStartedTime - startBrowserTime;

            // we want to shutdown the shared brower when the tests finish
            Runtime.getRuntime().addShutdownHook(
                    new Thread(){
                        public void run(){
                            Driver.quit();
                        }
                    }
            );

        }else{

            try{
                // is browser still alive
                if(aDriver.getWindowHandle()!=null){
                    // assume it is still alive
                }
            }catch(Exception e){
                if(avoidRecursiveCall){
                    // something has gone wrong as we have been here already
                    throw new RuntimeException();
                }

                quit();
                aDriver=null;
                avoidRecursiveCall = true;
                return get();
            }

            savedTimecount += browserStartTime;
            System.out.println("Saved another " + browserStartTime + "ms : total saved " + savedTimecount + "ms");
        }

        avoidRecursiveCall = false;
        return aDriver;
    }

    private static void setDriverPropertyIfNecessary(String propertyKey, String relativeToUserPath, String absolutePath) {
        // http://docs.oracle.com/javase/tutorial/essential/environment/sysprop.html

        if(!System.getProperties().containsKey(propertyKey)){

            String currentDir = System.getProperty("user.dir");
            String chromeDriverLocation = currentDir + relativeToUserPath;
            File driverExe = new File(chromeDriverLocation);
            if(driverExe.exists()){
                System.setProperty(propertyKey, chromeDriverLocation);
            }else{
                driverExe = new File(absolutePath);
                if(driverExe.exists()){
                    System.setProperty(propertyKey, absolutePath);
                }else{
                    // expect an error on the follow through when we try to use the driver
                }
            }
        }
    }

    public static WebDriver get(String aURL, boolean maximize){
        get();
        aDriver.get(aURL);
        if(maximize){
            try{
               // aDriver.manage().window().maximize();
               System.out.println("Maximize not supported since 2.33.0...");
            }catch(UnsupportedCommandException e){
                System.out.println("Remote Driver does not support maximise");
            }catch(UnsupportedOperationException e){
                System.out.println("Opera driver does not support maximize yet");
            }
        }
        return aDriver;
    }

    public static WebDriver get(String aURL){
        return get(aURL,true);
    }

    public static void quit(){
        if(aDriver!=null){
            System.out.println("total time saved by reusing browsers " + savedTimecount + "ms");
            try{
                aDriver.quit();
                aDriver=null;
            }catch(Exception e){
                // I don't care about errors at this point
            }

        }
    }
}
