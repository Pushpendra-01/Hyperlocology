package Softude.Hyperlocology.Tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Softude.Hyperlocology.TestComponents.BaseTest;
import Softude.Hyperlocology.pageobjects.AttachCollateral;
import Softude.Hyperlocology.pageobjects.Brands;
import Softude.Hyperlocology.pageobjects.EditBrandPage;
import Softude.Hyperlocology.pageobjects.LocationPage;
import Softude.Hyperlocology.pageobjects.ParentCompanies;

public class LocationPageTest extends BaseTest {

	@Test
	public void addLocation() throws InterruptedException {
		ParentCompanies parentCompanies=loginPage.login("pooja.saratkar@softude.com","Pooja##12345");
		EditBrandPage editBrand=parentCompanies.goToBrandsPages();
		editBrand.editBasicInformation("Automated Brand");
		AttachCollateral attachCollateral=editBrand.goToAttachCollateralPage();
		LocationPage locationPage=attachCollateral.goToLocationPage();
		locationPage.addLocation("C:\\Users\\Sipl\\Downloads\\Location Upload Sheet_Automated Brand.xlsx");
	}

	}
