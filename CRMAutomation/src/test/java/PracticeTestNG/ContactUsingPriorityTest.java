package PracticeTestNG;

import org.testng.annotations.Test;

public class ContactUsingPriorityTest {
	@Test(priority=1)
	public void createContactTest() {
		System.out.println("execute create contact with --. HDFC");
	}
	@Test(priority=2)
	public void modifyContactTest() {
		System.out.println("execute create contact with --. HDFC to SBI");
	}
	@Test(priority=2)
	public void deletContactTest() {
		System.out.println("delet create contact with --. HDFC ");
	}
}
