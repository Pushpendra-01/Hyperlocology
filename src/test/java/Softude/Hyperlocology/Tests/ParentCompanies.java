package Softude.Hyperlocology.Tests;

import org.testng.annotations.Test;

import Softude.Hyperlocology.TestComponents.BaseTest;

public class ParentCompanies extends BaseTest {

	@Test
	public void addParentCompany() {
		Softude.Hyperlocology.pageobjects.ParentCompanies parentCompanies=loginPage.login("superadmin@hyperlocology.com","Hyper@2023");
	    parentCompanies.addParentCompany();
	}
}
