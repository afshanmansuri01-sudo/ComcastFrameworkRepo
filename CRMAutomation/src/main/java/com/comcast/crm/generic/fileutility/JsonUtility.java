package com.comcast.crm.generic.fileutility;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonUtility {

	public String grtDataFromJsonFile(String Key) throws IOException, ParseException {
		FileReader filer = new FileReader("./configsppData/appcommonData.json");
		//step1: Parse Json physical file into java object using json parse class
		
		
				JSONParser parser = new JSONParser();
				Object obj= parser.parse(filer);
				
				
				//step 2 :converting java object into jason object using downcasting
				
				JSONObject map = (JSONObject)obj;
				
				String data = (String) map.get(Key);
				
				return data;
		
		
		
	}
}
