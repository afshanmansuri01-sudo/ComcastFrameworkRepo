package com.comcast.crm.contacttestWithBaseClass;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;

import org.testng.annotations.Test;

import com.comcast.crm.Baseclass.BaseClassTest;

import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;

import com.comcast.crm.objectrepositoryutility.OrganizationInfoPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPgae;

public class CreateOrganizationWithBaseClass extends BaseClassTest

{

	@Test
	public void createOrg() throws EncryptedDocumentException, IOException {

		// read testscript data frm excel file
		String orgname = elib.getDataFromExcel("Sheet1", 1, 2) + jlib.getRandomNumber();

		// step 2: navigate to the organization module

		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		// step3 click on "create organization" button
		// as create organization + sign is present on organization module so create 1
		// pom page as organiation page

		OrganizationsPgae cnp = new OrganizationsPgae(driver);
		cnp.getCreateNewOrgBtn().click();

		// step 4 enter all the details & create new Organization

		CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
		cnop.createOrg(orgname);

		// verify Header msg Expected result
		// for this step we need to go to organization info page as pom
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String actOrgName = oip.getHeaderMsg().getText();

		if (actOrgName.contains(orgname)) {
			System.out.println(orgname + "name is verified == pass");
		} else {
			System.out.println(orgname + "name is not verified == fail");
		}
		

	}
	
	@Test
	public void CreateOrgnizationWithContact() throws EncryptedDocumentException, IOException {

		// read testscript data frm excel file
		String orgname = elib.getDataFromExcel("Sheet1", 1, 2) + jlib.getRandomNumber();

		// step 2: navigate to the organization module

		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		// step3 click on "create organization" button
		// as create organization + sign is present on organization module so create 1
		// pom page as organiation page

		OrganizationsPgae cnp = new OrganizationsPgae(driver);
		cnp.getCreateNewOrgBtn().click();

		// step 4 enter all the details & create new Organization with industry as education

		CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
		cnop.createOrg(orgname,"Education");

		
		
		
		
		
		// verify Header msg Expected result
		// for this step we need to go to organization info page as pom
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String actOrgName = oip.getHeaderMsg().getText();
		 if (actOrgName.contains(orgname)) {
		        System.out.println(orgname + " created with Education industry == PASS");
		    } else {
		        System.out.println(orgname + " not created correctly == FAIL");
		    }
		
		
	}
}
