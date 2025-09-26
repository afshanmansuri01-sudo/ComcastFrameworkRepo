package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreatingNewOrganizationPage {
	WebDriver driver;
	public CreatingNewOrganizationPage(WebDriver driver) {// this is step no 3 but creating a constructor foe initialization
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	
	
@FindBy(name = "accountname")
private WebElement orgNameEdt;

@FindBy(xpath="(//input[@title='Save [Alt+S]'])[1]")
private WebElement saveBtn;

@FindBy(name="industry")
private WebElement industryDB;


public WebElement getIndustryDB() {
	return industryDB;
}

public WebElement getOrgNameEdt() {
	return orgNameEdt;
}

public WebElement getSaveBtn() {
	return saveBtn;
}
	
	//as this page will perform 2 action so we need to create method here
public void createOrg(String orgName) {
	
	orgNameEdt.sendKeys(orgName);
	saveBtn.click();}


	//suppose another action we need to do  so create method accordingly
	public void createOrg(String orgName, String industry) {
	    orgNameEdt.sendKeys(orgName);
		Select s = new Select(industryDB);
		s.selectByVisibleText(industry);
		saveBtn.click();
	
}}

	
	
	

