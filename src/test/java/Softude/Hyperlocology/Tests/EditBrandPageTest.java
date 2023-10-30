package Softude.Hyperlocology.Tests;

import org.testng.annotations.Test;

import Softude.Hyperlocology.TestComponents.BaseTest;
import Softude.Hyperlocology.pageobjects.Brands;
import Softude.Hyperlocology.pageobjects.EditBrandPage;
import Softude.Hyperlocology.pageobjects.ParentCompanies;

public class EditBrandPageTest extends BaseTest {

	@Test
	public void attachCollateral() {
	ParentCompanies parentCompanies=loginPage.login("pooja.saratkar@softude.com","Pooja##12345");
	EditBrandPage editBrand=parentCompanies.goToBrandsPages();
	editBrand.editBasicInformation("Automated Brand");
	editBrand.editBrnadName("Automation Brand");
	editBrand.editEmail("pushpendra@yopmail.com");
	editBrand.editFirstName("Singhs");
	editBrand.editLastName("pvt.ltd.");
	

	}
}