package Softude.Hyperlocology.Tests;

import org.testng.annotations.Test;

import Softude.Hyperlocology.TestComponents.BaseTest;
import Softude.Hyperlocology.pageobjects.Brands;
import Softude.Hyperlocology.pageobjects.LandingPage;
import Softude.Hyperlocology.pageobjects.ParentCompanies;

public class BrandsTest extends BaseTest{
	@Test
	public void addNewBrand() {
		ParentCompanies parentCompanies=loginPage.login("superadmin@hyperlocology.com","Hyper@2023");
		Brands brands=parentCompanies.goToBrandsPage();
		brands.fillBrandsDetails("Automated Brand","Softue","Systematrix","softude@yopmail.com","8745963210");
		
	}
	
	
}
