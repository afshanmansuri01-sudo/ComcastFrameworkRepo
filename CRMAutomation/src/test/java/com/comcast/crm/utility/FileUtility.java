package com.comcast.crm.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {
	public String getPropertyFromProperties() throws IOException {
	FileInputStream fis = new FileInputStream("./configappData.Vcommondata.properties");
     Properties p= new Properties();
      p.load(fis);
      
      
     String  DATA = p.getProperty("key");
     
	  return  DATA;
      
	}
	
	
	
	
}

