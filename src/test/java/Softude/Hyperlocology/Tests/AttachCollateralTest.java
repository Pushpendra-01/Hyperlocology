package Softude.Hyperlocology.Tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Softude.Hyperlocology.TestComponents.BaseTest;
import Softude.Hyperlocology.pageobjects.AttachCollateral;
import Softude.Hyperlocology.pageobjects.Brands;
import Softude.Hyperlocology.pageobjects.EditBrandPage;
import Softude.Hyperlocology.pageobjects.ParentCompanies;

public class AttachCollateralTest extends BaseTest {

	
	@Test
	public void attachCollateral() throws InterruptedException{
		ParentCompanies parentCompanies=loginPage.login("pooja.saratkar@softude.com","Pooja##12345");
		Brands brand=parentCompanies.goToBrandsPage();
		EditBrandPage editBrand=brand.goToEditBrandsPages();
		editBrand.editBasicInformation("Automated Brand");
		AttachCollateral attachCollateral=editBrand.goToAttachCollateralPage();
		attachCollateral.attachCollateral("Testing File","C:\\Users\\Sipl\\Downloads\\companylogo.jpg");
	    SoftAssert softAssert = new SoftAssert();
//	softAssert.assertEquals("Record saved successfully.", EditBrandPage.successMessage());
	}
	

	}
