package com.educo.tests.Helpers.testng;

import org.testng.ITestResult;
import org.uncommons.reportng.ReportNGUtils;

import java.util.List;

/**
 * Created by
 * User: paul
 * Date: 4/29/13
 * Time: 10:10 AM
 * This file is used to
 */
public class ScreenshotReportNGUtils extends ReportNGUtils{
    public static final String DRIVER_ATTR = "driver";


    /* (non-Javadoc)
     * @see org.uncommons.reportng.ReportNGUtils#getTestOutput(org.testng.ITestResult)
     * override to add screenshot from result attribute
     */
    public List<String> getTestOutput(ITestResult result) {
        List<String> output = super.getTestOutput(result);
        // add screenshot if there is one
        String screenshot = (String)result.getAttribute("screenshot");
        if (screenshot != null) {
            String url = (String)result.getAttribute("screenshotURL");
            if (url == null)
                url = "";
            // ReportNG output directory is private, so get screenshot from output root
            output.add("screenshot for "+result.getName()+" "+url+"<br><img src=\"../"+screenshot+"\">");
        }
        return output;
    }
}
