package Softude.Hyperlocology.Tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Softude.Hyperlocology.TestComponents.BaseTest;
import Softude.Hyperlocology.pageobjects.Brands;
import Softude.Hyperlocology.pageobjects.EditBrandPage;
import Softude.Hyperlocology.pageobjects.ParentCompanies;

public class EditBrandPageTest extends BaseTest {

	@Test
	public void editBasicInformation() throws InterruptedException {
	ParentCompanies parentCompanies=loginPage.login("pooja.saratkar@softude.com","Pooja##12345");
	EditBrandPage editBrand=parentCompanies.goToBrandsPages();
    editBrand.editBasicInformation("Automated Brand");
	editBrand.editBrnadName("Automation Brand");
	editBrand.editEmail("pushpendra@yopmail.com");
	editBrand.editFirstName("Singhs");	
	editBrand.editLastName("pvt.ltd.");
//	editBrand.updateTheDetails();
	}
/*	@Test
	public void attachCollateral() throws InterruptedException{
		ParentCompanies parentCompanies=loginPage.login("pooja.saratkar@softude.com","Pooja##12345");
		EditBrandPage editBrand=parentCompanies.goToBrandsPages();
		editBrand.editBasicInformation("Automated Brand");
	editBrand.attachCollateral("Testing File","C:\\Users\\Sipl\\Downloads\\companylogo.jpg");
	SoftAssert softAssert = new SoftAssert();
//	softAssert.assertEquals("Record saved successfully.", EditBrandPage.successMessage());
	}
	@Test
	public void addLocation() throws InterruptedException {
		ParentCompanies parentCompanies=loginPage.login("pooja.saratkar@softude.com","Pooja##12345");
		EditBrandPage editBrand=parentCompanies.goToBrandsPages();
		editBrand.editBasicInformation("Automated Brand");
		editBrand.addLocation("C:\\Users\\Sipl\\Downloads\\Location Upload Sheet_Automated Brand.xlsx");
	}
	@Test
	public void addSubscription() throws InterruptedException {
		ParentCompanies parentCompanies=loginPage.login("pooja.saratkar@softude.com","Pooja##12345");
		EditBrandPage editBrand=parentCompanies.goToBrandsPages();
		editBrand.editBasicInformation("Automated Brand");
		editBrand.goToSubscriptionPage("C:\\Users\\Sipl\\Downloads\\Subscription Upload Sheet_Automated Brand.xlsx");
        
	}
	*/

	}
