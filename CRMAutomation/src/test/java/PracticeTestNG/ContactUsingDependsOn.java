package PracticeTestNG;

import org.testng.annotations.Test;

public class ContactUsingDependsOn {
	/*
	 * @Test public void createOrder() {
	 * System.out.println("Order generated--order id is oderId123"); }
	 * 
	 * @Test(dependsOnMethods="createOrder") public void createBill() {
	 * System.out.println("bill genetared over oderId123"); }
	 * 
	 * @Test(dependsOnMethods ="createBill") public void logout() {
	 * System.out.println("bill genetared over oderId123 and log out"); }
	 * 
	 * 
	 */	 
	//intentially make wrong 1st method in order to fetch the functioning of dependsonmethod
	
	@Test
	public void createOrder() {
		System.out.println("Order generated--order id is oderId123");
		String str=null;
		System.out.println(str.equals("123"));
	}
	@Test(dependsOnMethods="createOrder")
	public void createBill() {
		System.out.println("bill genetared over oderId123");
	}
	 @Test(dependsOnMethods ="createBill")
		 public void logout() {
		 System.out.println("bill genetared over oderId123 and log out");
	 }
		 
	 

}
