package Softude.Hyperlocology.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Softude.Hyperlocology.TestComponents.BaseTest;

public class ParentCompaniesTest extends BaseTest {

	@Test
	public void addParentCompany() {
		Softude.Hyperlocology.pageobjects.ParentCompanies parentCompanies=loginPage.login("pooja.saratkar@softude.com","Pooja##12345");
	    parentCompanies.addParentCompany("Automation_Company","softude","pvt.ltd.","pushpedra@yopmail.com","8974562310");
	    parentCompanies.sendEmailNotification();
	    parentCompanies.attachCompanyLogo("C:\\Users\\Sipl\\Downloads\\companylogo.jpg");
	    parentCompanies.saveParentCompany();
	}
	@Test
	public void wrongEmailErrorValidation() {
		Softude.Hyperlocology.pageobjects.ParentCompanies parentCompanies=loginPage.login("pooja.saratkar@softude.com","Pooja##12345");
	    parentCompanies.addParentCompany("Automation_Company","softude","pvt.ltd.","pushpedra@123","8974562310");
	    parentCompanies.sendEmailNotification();
	    parentCompanies.attachCompanyLogo("C:\\Users\\Sipl\\Downloads\\companylogo.jpg");
	    parentCompanies.saveParentCompany();
	    Assert.assertEquals("This value should be a valid email.", parentCompanies.getErrorMessage());
	}
}


