package com.comcast.crm.generic.fileutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class FileUtility {
	
	public String getDataFrompropertiesFile(String Key) throws IOException  {
		
		FileInputStream fis = new FileInputStream("./configappData/Vcommondata.properties");
		Properties p = new Properties();
		p.load(fis);
		String data = p.getProperty(Key);
		return data;
		}

}
