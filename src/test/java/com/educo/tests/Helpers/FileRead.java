package com.educo.tests.Helpers;
import java.io.FileWriter;
import java.io.IOException;

public class FileRead{


        public static void mylog(String mYlogfile, String Message1)
    {

        try {

            FileWriter myWriter = new FileWriter(mYlogfile);
             myWriter.write(Message1);
                myWriter.flush();


        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    }
