package Softude.Hyperlocology.Tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Softude.Hyperlocology.TestComponents.BaseTest;
import Softude.Hyperlocology.pageobjects.AttachCollateral;
import Softude.Hyperlocology.pageobjects.EditBrandPage;
import Softude.Hyperlocology.pageobjects.LocationPage;
import Softude.Hyperlocology.pageobjects.PageSetup;
import Softude.Hyperlocology.pageobjects.ParentCompanies;
import Softude.Hyperlocology.pageobjects.SubscriptionPage;

public class PageSetupPageTest extends BaseTest{
	@Test(dataProvider="getData")
	public void setupPage(HashMap<String, String>input) throws InterruptedException {
		ParentCompanies parentCompanies=loginPage.login("pooja.saratkar@softude.com","Pooja##12345");
		EditBrandPage editBrand=parentCompanies.goToBrandsPages();
		editBrand.editBasicInformation("Automated Brand");
		AttachCollateral attachCollateral=editBrand.goToAttachCollateralPage();
		LocationPage locationPage=attachCollateral.goToLocationPage();
		SubscriptionPage subscriptionPage=locationPage.goToSubscriptionPage();
		PageSetup pageSetup=subscriptionPage.goToPageSetup();
		pageSetup.loadingPageDescription(input.get("Description"));
		pageSetup.howItWorks(input.get("TheSetup"),input.get("YourLocalExpertise"),input.get("CompaignStart"), input.get("Insights"), input.get("VedioName"), input.get("VedioUrl"));
	}
	@DataProvider
	public Object[][] getData() throws IOException {
		List<HashMap<String, String>> data=getJsonDataToMap(System.getProperty("user.dir")+"//src//test//java//Softude//Hyperlocology//Data//PageSetup.json");
		return new Object[][] {{data.get(0)},{data.get(1)}};
	}
		
	

}
