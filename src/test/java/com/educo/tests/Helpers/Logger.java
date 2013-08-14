package com.educo.tests.Helpers;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;


public  class Logger {



    private  static long imageCounter;
    private  static String reportPath = "." + File.separator + "logs"
            + File.separator;
    private  static String screenDirPath = reportPath + "screenshots"
            + File.separator;
    private  static String screenPath = screenDirPath + "screenshot";
    private   String logFileName = "log.html";
    private   String logPath = reportPath + logFileName;
    private static int countReport=0;

    public static   void Log(String LOG_FILE,String command, String description,WebDriver driver,boolean success) {
        try{
           // Reporter.setEscapeHtml(false);
            countReport=countReport+1;
            if(countReport==1)
            {
                ITestResult currentTestResult = Reporter.getCurrentTestResult();
               // Reporter.log("</table>" +"<link href='D:\\GitHub Checkout\\EducoUnitTests\\test-output\\html\\reportng.css' >");
              /*  Reporter.log("\"<tr>\\n\" +\n" +
                        "                        \"<th>Method</th>\\n\" +\n" +
                        "                        \"<th>Description</th>\\n\" +\n" +
                        "                        \"<th>Screenshot</th>\\n\" +\n" +
                        "                        \"</tr>\\n\")"); */
         /*      Reporter.log("</table>" +
                        "<style>\n" +
                        "table, td, th\n" +
                        "{\n" +
                        "border:1px solid blue;\n" +
                        "}\n" +
                        "th\n" +
                        "{\n" +
                        "background-color:#2C74D3;\n" +
                        "color:white;\n" +
                        "}\n" +
                        ".success{background-color: #44aa44;}"+
                        ".error{background-color: red;}"+
                      ".alternateItem\n" +
                      "{\n" +
                      "    background-color: #eef6f8;\n" +
                      "    border-left-style: none;\n" +
                      "    border-top-style: none;\n" +
                      "    border-right-style: none;\n" +
                      "    border-bottom: #DCDCDC 1px solid;\n" +
                      "    font-family: 'Verdana';\n" +
                      "    font-size: 11px;\n" +
                      "    font-weight: Normal;\n" +
                      "    color: #000066;\n" +
                      "    height: 25px;\n" +
                      "}" +
                        "</style>\n" +
                        "</head>\n" +
                        "\n" +
                        "<body>\n" +
                        "<table>\n" +
                        "<tr>\n" +
                        "<th>Method</th>\n" +
                        "<th>Description</th>\n" +
                        "<th>Screenshot</th>\n" +
                        "</tr>\n");   */

            }
            FileWriter fstream;
            fstream = new FileWriter(LOG_FILE,true);
            BufferedWriter out_file = new BufferedWriter(fstream);
            Date timeStamp = new Date();
            //Reporter.log("<br><h3 style='color:red;font-size:14px;background-color:yellow;'>["+timeStamp+"] " + command + "</h3>");
            String className = success ? "alternateItem" : "error";
            StringBuilder builder = new StringBuilder();

            Reporter.log(
                    "<tr class=\"" +className +"\">" +
                    "<td>" + command  + "</td>" +
                    "<td>" + description + "</td>" +
                    "<td> <br/>" +
                    "<a href='D:\\GitHub Checkout\\EducoUnitTests\\logs\\screenshots\\screenshot"
                    + imageCounter + ".png'> Screenshot </a><br/> </td></tr>" );
            imageCounter += 1;
            screenShooter(LOG_FILE,driver,screenPath + imageCounter);
            out_file.write("["+timeStamp+"] " + command);
            System.out.println("["+timeStamp+"] " + command);
            out_file.newLine();
            out_file.flush();
            out_file.close();
        }catch(IOException e){
            e.printStackTrace();
        }

    }

    //***********************************************************************************************************************
    public static void screenShooter(String LOG_FILE,  WebDriver driver,String Outputfilepath) {

        File dest;

        try {
            //((TakesScreenshot)driver).getScreenshotAs(target)
           // driver           = new Augmenter().augment( driver );
            System.setProperty("org.uncommons.reportng.escape-output", "false");
            if (!Outputfilepath.endsWith(".png")) {
                Outputfilepath = Outputfilepath + ".png";
            }
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            dest = new File(Outputfilepath);
            FileUtils.copyFile(scrFile,dest);
            String absolute = dest.getAbsolutePath();
            int beginIndex = absolute.indexOf(".");
            String relative = absolute.substring(beginIndex).replace(".\\","");
            String screenShot = relative.replace('\\','/');
            //Reporter.log("<a href=\"" + screenShot + "\"><p align=\"left\">Screenshot at " + new Date()+ "</p>");
            //Reporter.log("<p style='border:1px solid red;'><img width=\"800\" src=\"" + dest.getAbsoluteFile()  + "\" alt=\"screenshot at " + new Date()+ "\"/></p></a><br />");
           // Reporter.log("<img src=\"" + dest.getAbsoluteFile() + "\" style=\"display: block; opacity: 1; min-width: 0px; min-height: 0px; max-width: none; max-height: none; width: 530px; height: 530px;  \" width=\"530\" height=\"530\">");



        } catch (IOException e) {
            e.getMessage();
           Logger.Log(LOG_FILE,e.getMessage(), "Couldn't take the screenshot ",driver,false);

        }
    }


}
