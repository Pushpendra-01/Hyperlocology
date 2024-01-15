package Softude.Hyperlocology.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Softude.Hyperlocology.TestComponents.BaseTest;
import Softude.Hyperlocology.pageobjects.CampaignSetup;
import Softude.Hyperlocology.pageobjects.ParentCompanies;

public class CompaignSetupTest extends BaseTest{

	@Test
	public void validateTheBrandName() throws InterruptedException {
		ParentCompanies parentCompanies=loginPage.login("pooja.saratkar@softude.com","Pooja##12345");
		CampaignSetup campaignSetup=parentCompanies.goToCampaignSetupPage();
		String expectedBrand=campaignSetup.getBrandName("Us connect");
		Assert.assertEquals(expectedBrand,"woops");
	
	}
	@Test
	public void validateTheCampaignName() throws InterruptedException {
		ParentCompanies parentCompanies=loginPage.login("pooja.saratkar@softude.com","Pooja##12345");
		CampaignSetup campaignSetup=parentCompanies.goToCampaignSetupPage();
		String campType=campaignSetup.validateTheCampaignType("Bogo");
		Assert.assertEquals("Normal",campType);
	}
}
