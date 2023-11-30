package Softude.Hyperlocology.Tests;

import org.testng.annotations.Test;

import Softude.Hyperlocology.TestComponents.BaseTest;
import Softude.Hyperlocology.pageobjects.AttachCollateral;
import Softude.Hyperlocology.pageobjects.Brands;
import Softude.Hyperlocology.pageobjects.EditBrandPage;
import Softude.Hyperlocology.pageobjects.LocationPage;
import Softude.Hyperlocology.pageobjects.PageSetup;
import Softude.Hyperlocology.pageobjects.ParentCompanies;
import Softude.Hyperlocology.pageobjects.ReportConfig;
import Softude.Hyperlocology.pageobjects.SubscriptionPage;

public class ReportConfigPageTest extends BaseTest{
	
	@Test
	public void compaignReportPicktemplateFromLib () throws InterruptedException {
		ParentCompanies parentCompanies=loginPage.login("pooja.saratkar@softude.com","Pooja##12345");
		Brands brand=parentCompanies.goToBrandsPage();
		EditBrandPage editBrand=brand.goToEditBrandsPages();
		editBrand.editBasicInformation("Automated Brand");
		ReportConfig reportConfig=editBrand.goToReportConfigPage();
		reportConfig.pickTemplateFromLibrary("Campaign Reports");
	}
	@Test
	public void compaignReportCreateTemplate() throws InterruptedException {
		ParentCompanies parentCompanies=loginPage.login("pooja.saratkar@softude.com","Pooja##12345");
		Brands brand=parentCompanies.goToBrandsPage();
		EditBrandPage editBrand=brand.goToEditBrandsPages();
		editBrand.editBasicInformation("Automated Brand");
		ReportConfig reportConfig=editBrand.goToReportConfigPage();
		reportConfig.goToBrandDashboard("Brand Dashboard");
		
	}
	

}
