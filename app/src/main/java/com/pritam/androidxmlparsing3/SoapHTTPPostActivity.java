package com.pritam.androidxmlparsing3;

import android.app.Activity;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import android.app.Activity;
import android.os.Bundle;

/*

https://www.tutorialspoint.com/android/android_xml_parsers.htm

https://dzone.com/articles/android-development-tutorial

http://shanekirk.com/2011/11/speaking-soap-with-android/

http://androiddevblog.blogspot.com/2010/04/serializing-and-parceling-ksoap2.html

http://www.devexchanges.info/2015/05/parsing-list-of-soap-objects-from-web.html



---------------

https://www.thecrazyprogrammer.com/2016/11/android-soap-client-example-using-ksoap2.html

https://andygeeks.blogspot.com/2014/02/how-to-get-data-from-soap-webservice.html

https://www.codeproject.com/Questions/1063947/how-do-I-get-each-value-from-array-from-webservice

------------------

http://codeoncloud.blogspot.com/2012/12/create-java-web-service-in-eclipse_3982.html

http://codeoncloud.blogspot.com/2013/06/android-java-soap-web-service-access.html

--------------

https://github.com/pritamkhose/NotesKeeper/blob/master/app/src/main/res/layout/activity_home.xml

https://github.com/pritamkhose/NotesKeeper/blob/master/app/src/main/java/com/pritam/noteskeeper/notes/CustomListAdapter.java

 */
public class SoapHTTPPostActivity extends Activity {

    private String URL = "http://www.w3schools.com/webservices/tempconvert.asmx";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        String xml = null;
        try {
            xml = convertStreamToString(getAssets().open("request.xml"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        String request = String.format(xml, "12");
        HTTPOST httpost = new HTTPOST();
        httpost.getResponseByXML(URL, request);
        httpost.getResponseByFile(URL);
    }

    public static String convertStreamToString(InputStream is) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
        String line = null;
        while ((line = reader.readLine()) != null) {
            sb.append(line+"\n");
        }
        is.close();
        return sb.toString();
    }
}
