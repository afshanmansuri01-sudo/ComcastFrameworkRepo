package com.comcast.crm.generic.webdriverutility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	public int getRandomNumber() {
		Random random = new Random();
		int ranDomNumber = random.nextInt(5000);
		return ranDomNumber;
	}
public String getSystemDateYYYYDDMM() {
	Date dateobj= new Date();

	SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
			 String date =sdf.format(dateobj);
	
	
	
	return null;
}


public String getRequiredDateYYYYDDMM(int days)// here if u pass -ve data it will give previous date
//n if u pass+ve data then it will give u an after date
{
	SimpleDateFormat sim= new SimpleDateFormat("yyyy-MM-dd");
	
	Calendar cal = sim.getCalendar();
	cal.add(Calendar.DAY_OF_MONTH, days);
	String reqDate = sim.format(cal.getTime());
	return reqDate;
	
	
	
}
} 
