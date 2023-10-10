package Softude.Hyperlocology.Tests;

import org.testng.annotations.Test;

import Softude.Hyperlocology.TestComponents.BaseTest;

public class ParentCompaniesTest extends BaseTest {

	@Test
	public void addParentCompany() {
		Softude.Hyperlocology.pageobjects.ParentCompanies parentCompanies=loginPage.login("superadmin@hyperlocology.com","Hyper@2023");
	    parentCompanies.addParentCompany("TestCompanyName","TestFirstName","TestLastName","testcompany@yopmail.com","4567891023");
	    parentCompanies.sendEmailNotification();
	    parentCompanies.attachCompanyLogo("C:\\Users\\Sipl\\Downloads");
	    parentCompanies.saveParentCompany();
	}

}
