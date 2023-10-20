package Softude.Hyperlocology.Tests;

import org.testng.annotations.Test;

import Softude.Hyperlocology.TestComponents.BaseTest;
import Softude.Hyperlocology.pageobjects.Brands;
import Softude.Hyperlocology.pageobjects.LandingPage;
import Softude.Hyperlocology.pageobjects.ParentCompanies;

public class BrandsTest extends BaseTest{
	@Test
	public void addNewBrand() throws InterruptedException {
		ParentCompanies parentCompanies=loginPage.login("pooja.saratkar@softude.com","Pooja##12345");
		Brands brands=parentCompanies.goToBrandsPage();
		brands.fillBrandsDetails("Automated Brand","Softue","Systematrix","softude@yopmail.com","8745963210");
		brands.selectStartDate("December","2023","11");
		brands.selectSubscriptionMonth("20");
		brands.fillSubscriptionDeatils("Hello this subscription deatils is filled by the automation script");
		brands.selectSpecificRegion("Ease");
		brands.selectParentComapny("Hello");
		brands.disablePaymentThroughPortal();
		brands.sendEmailNotification();
		brands.ChangeStatus();
		brands.uploadBrandLogo("C:\\Users\\Sipl\\Downloads\\companylogo.jpg");
		brands.selectDashboardLastUpdate("January","2024","12");
	}
	
	
}
