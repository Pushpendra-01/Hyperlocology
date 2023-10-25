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
		brands.fillBrandsDetails("Automated Bran","Softue","Systematrix","softude@yopmail.in","8745963210");
		brands.selectStartDate("December","2023","11");
		brands.selectSubscriptionMonth("20");
		brands.fillSubscriptionDeatils("Hello this subscription deatils is filled by the automation script");
		brands.selectSpecificRegion("Ease");
		brands.selectParentComapny("Hello");
		brands.disablePaymentThroughPortal();
		brands.sendEmailNotification();
		brands.ChangeStatus();
		brands.activeAutoRenew();
		brands.uploadBrandLogo("C:\\Users\\asus\\Downloads\\Html toutorial\\Portfolio\\copmanyLogo.jpeg");
		brands.selectDashboardLastUpdate("March","2027","12");
		brands.saveAndGoToAttachCollateralPage();
		brands.attachCollateral("Automation_File","C:\\Users\\asus\\Downloads\\Html toutorial\\Portfolio\\copmanyLogo.jpg");
	}
	
	
}
