package Softude.Hyperlocology.Tests;

import org.testng.annotations.Test;

import Softude.Hyperlocology.TestComponents.BaseTest;
import Softude.Hyperlocology.pageobjects.Brands;
import Softude.Hyperlocology.pageobjects.EditBrandPage;
import Softude.Hyperlocology.pageobjects.MasterLoginPage;
import Softude.Hyperlocology.pageobjects.ParentCompanies;

public class MasterLoginPageTest extends BaseTest {

	@Test
	public void addMasterLoginPassword() throws InterruptedException  {
		ParentCompanies parentCompanies=loginPage.login("pooja.saratkar@softude.com","Pooja##12345");
		Brands brand=parentCompanies.goToBrandsPage();
		EditBrandPage editBrand=brand.goToEditBrandsPages();
		editBrand.editBasicInformation("Automated Brand");
		MasterLoginPage masterLogin=editBrand.goToMasterLoginPage();
		masterLogin.addMasterPassword("Ps@8745963");
	}
}
