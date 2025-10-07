package automationPractice.framework.GenericUtilities;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class javaUtility {
	
	
	public int getRandomData() {
		Random randm =new  Random();
	int randmInt = randm.nextInt(5000);
		return randmInt;}
		

public String getCurrentDateYYYYMMDD() {
	Date dobj = new Date();
	SimpleDateFormat sim = new SimpleDateFormat("YYYY-MM-dd");
	String actdate = sim.format(dobj);
	return actdate;
	
	
	
	/*
	 * public String getCurrentDateYYYYMMDD() {
	 * Date dobj= new Date();
	 * SimpleDateFormate sim = new SimpleDateFormate();
	 *  string actdate =sim.format(yyyy-MM-dd);
	 *  return actDate; 
	 * }
	 */}



public String getEndDateYYYYMMDD() {
	
	Date dobj = new Date();
	SimpleDateFormat sim= new SimpleDateFormat();
	sim.format(dobj);
	
	return null;
	
	
	
}



















}