package automationPractice.framework.GenericUtilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {
	public String getDataFromProprtiesFile(String key) throws IOException {
		FileInputStream fis = new FileInputStream("./commondata/vtcommondata.properties ");
		Properties pobj= new Properties();
		pobj.load(fis);
		pobj.getProperty(key);
		
		
		return null;
		
	}
}
