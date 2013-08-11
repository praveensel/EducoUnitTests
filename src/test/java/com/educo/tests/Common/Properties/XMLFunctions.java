package com.educo.tests.Common.Properties;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.XMLConfiguration;

import java.io.File;

public class XMLFunctions {


    public static String getXMLConfiguration(File file, String key)

    {
        XMLConfiguration xl = null;
        try {
            xl = new XMLConfiguration(file);
        } catch (ConfigurationException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return xl.getString(key);
    }
}
