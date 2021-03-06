package com.educo.tests.Common.Properties;


import com.educo.tests.Common.Global;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import java.io.File;

public class Properties {

	public static String userName;
	public static String password;

	public static String usernameIndiains;
	public static String password2;

	public static String profnameIND;
	public static String passwordInd;

	public static String profname;
	public static String password4;

	public static String userNameJohn;
	public static String profnamejohn;
	public static String passwordJohn;

	public static String userNameWithUnderScore;
	public static String passwordWithUnderScore;

	public static String userNameWithBackwardSlash;
	public static String userNameWithBackwardSlashEncoded;
	public static String passwordWithBackwardSlash;

	public static String userNameLong;
	public static String passwordLong;

	public static String email;
	public static String emailPassword;
	public static String emailQaart1;
	public static String emailPasswordQaart1;
	public static String emailQaart2;
	public static String emailPasswordQaart2;
	public static String emailQaart3;
	public static String emailPasswordQaart3;
	public static String emailQaart4;
	public static String emailPasswordQaart4;

	public static String userNameStaff;
	public static String passwordStaff;

	public static String userNameStaff2;
	public static String passwordStaff2;

	public static String userNameMonobook;
	public static String passwordMonobook;

	public static String userNameFB;
	public static String passwordFB;
	public static String emailFB;

	public static String userNameBlocked;
	public static String passwordBlocked;

	public static String userNameForgottenPassword;
	public static String userNameForgottenPassword2;

	public static String geoEdgeUserName;
	public static String geoEdgeUserPass;

	public static String apiToken;

	private static void setVariables() {

        userName = XMLFunctions.getXMLConfiguration(Global.CONFIG_FILE, "USA.Instructor");
        password = XMLFunctions.getXMLConfiguration(Global.CONFIG_FILE,"USA.Password");
        profname = XMLFunctions.getXMLConfiguration(Global.CONFIG_FILE, "USA.BannerName");
        usernameIndiains = XMLFunctions.getXMLConfiguration(Global.CONFIG_FILE,"India.Instructor");
        profnameIND = XMLFunctions.getXMLConfiguration(Global.CONFIG_FILE, "India.BannerName");
		passwordInd = XMLFunctions.getXMLConfiguration(Global.CONFIG_FILE, "India.Password");

		password4 = XMLFunctions.getXMLConfiguration(Global.CONFIG_FILE, "ci.user.regular4.password");

		userNameJohn = XMLFunctions.getXMLConfiguration(Global.CONFIG_FILE, "USA.Instructor1");
        profnamejohn = XMLFunctions.getXMLConfiguration(Global.CONFIG_FILE, "USA.BannerName1");
		passwordJohn = XMLFunctions.getXMLConfiguration(Global.CONFIG_FILE, "USA.Password1");

		userNameWithUnderScore = XMLFunctions.getXMLConfiguration(Global.CONFIG_FILE, "ci.user.underscore.username");
		passwordWithUnderScore = XMLFunctions.getXMLConfiguration(Global.CONFIG_FILE, "ci.user.underscore.password");

		userNameWithBackwardSlash = XMLFunctions.getXMLConfiguration(Global.CONFIG_FILE, "ci.user.backwardslash.username");
		userNameWithBackwardSlashEncoded = XMLFunctions.getXMLConfiguration(Global.CONFIG_FILE, "ci.user.backwardslash.usernameenc");
		passwordWithBackwardSlash = XMLFunctions.getXMLConfiguration(Global.CONFIG_FILE, "ci.user.backwardslash.password");

		userNameLong = XMLFunctions.getXMLConfiguration(Global.CONFIG_FILE, "ci.user.long.username");
		passwordLong = XMLFunctions.getXMLConfiguration(Global.CONFIG_FILE, "ci.user.long.password");

		userNameStaff = XMLFunctions.getXMLConfiguration(Global.CONFIG_FILE, "ci.user.wikiastaff.username");
		passwordStaff = XMLFunctions.getXMLConfiguration(Global.CONFIG_FILE, "ci.user.wikiastaff.password");

		userNameStaff2 = XMLFunctions.getXMLConfiguration(Global.CONFIG_FILE, "ci.user.wikiastaff2.username");
		passwordStaff2 = XMLFunctions.getXMLConfiguration(Global.CONFIG_FILE, "ci.user.wikiastaff2.password");

		userNameMonobook = XMLFunctions.getXMLConfiguration(Global.CONFIG_FILE, "ci.user.wikiamonobook.username");
		passwordMonobook = XMLFunctions.getXMLConfiguration(Global.CONFIG_FILE, "ci.user.wikiamonobook.password");

		emailFB = XMLFunctions.getXMLConfiguration(Global.CONFIG_FILE, "ci.user.facebook.email");
		passwordFB = XMLFunctions.getXMLConfiguration(Global.CONFIG_FILE, "ci.user.facebook.password");
		userNameFB = XMLFunctions.getXMLConfiguration(Global.CONFIG_FILE, "ci.user.facebook.username");

		email = XMLFunctions.getXMLConfiguration(Global.CONFIG_FILE, "ci.email.generic.username");
		emailPassword = XMLFunctions.getXMLConfiguration(Global.CONFIG_FILE, "ci.email.generic.password");

		emailQaart1 = XMLFunctions.getXMLConfiguration(Global.CONFIG_FILE, "ci.email.qawikia1.username");
		emailPasswordQaart1 = XMLFunctions.getXMLConfiguration(Global.CONFIG_FILE, "ci.email.qawikia1.password");
		emailQaart2 = XMLFunctions.getXMLConfiguration(Global.CONFIG_FILE, "ci.email.qawikia2.username");
		emailPasswordQaart2 = XMLFunctions.getXMLConfiguration(Global.CONFIG_FILE, "ci.email.qawikia2.password");
		emailQaart3 = XMLFunctions.getXMLConfiguration(Global.CONFIG_FILE, "ci.email.qawikia3.username");
		emailPasswordQaart3 = XMLFunctions.getXMLConfiguration(Global.CONFIG_FILE, "ci.email.qawikia3.password");
		emailQaart4 = XMLFunctions.getXMLConfiguration(Global.CONFIG_FILE, "ci.email.qawikia4.username");
		emailPasswordQaart4 = XMLFunctions.getXMLConfiguration(Global.CONFIG_FILE, "ci.email.qawikia4.password");

		userNameBlocked = XMLFunctions.getXMLConfiguration(Global.CONFIG_FILE, "ci.user.tooManyLoginAttempts.username");
		passwordBlocked = XMLFunctions.getXMLConfiguration(Global.CONFIG_FILE, "ci.user.tooManyLoginAttempts.password");

		userNameForgottenPassword = XMLFunctions.getXMLConfiguration(Global.CONFIG_FILE, "ci.user.forgottenPassword.username1");
		userNameForgottenPassword2 = XMLFunctions.getXMLConfiguration(Global.CONFIG_FILE, "ci.user.forgottenPassword.usernameIndiains");

		geoEdgeUserName = XMLFunctions.getXMLConfiguration(Global.CONFIG_FILE, "ci.AdsConfig.GeoEdgeCredentials.userName");
		geoEdgeUserPass = XMLFunctions.getXMLConfiguration(Global.CONFIG_FILE, "ci.AdsConfig.GeoEdgeCredentials.password");

		apiToken = XMLFunctions.getXMLConfiguration(Global.CONFIG_FILE, "ci.api.token");
	}

	public static void setProperties() {

			PropertiesSetter.setPropertiesManually();
            setVariables();
	}

	private static void getPropertiesFromPom() {
		Global.BROWSER = System.getProperty("browser");
		Global.CONFIG_FILE = new File(System.getProperty("config"));
		Global.CAPTCHA_FILE = new File(System.getProperty("captcha"));
		Global.DOMAIN = System.getProperty("base-address");
		Global.LIVE_DOMAIN = System.getProperty("live-domain");
		Global.ENV = System.getProperty("env");
		Global.QS = System.getProperty("qs");
		Global.LOG_VERBOSE = (Global.BROWSER.equals("IE")) ? 1 : 2;

		try {
			if (Global.DOMAIN.contains("dev")) {
				Global.LOGIN_BY_COOKIE = false;
			} else {
				Global.LOGIN_BY_COOKIE = true;
			}
		} catch (NullPointerException ex) {

		}
		Global.LOG_ENABLED = true;
	}

	private static void getWikiVersion() {
		WebDriver versionDriver = new HtmlUnitDriver(true);
		versionDriver.get(Global.DOMAIN + "wiki/Special:Version");
		WebElement versionTable = versionDriver.findElement(By.xpath("//td[contains(text(), 'Code')]"));
		Global.WIKI_VERSION = versionTable.getText();
		versionDriver.close();
	}
}
