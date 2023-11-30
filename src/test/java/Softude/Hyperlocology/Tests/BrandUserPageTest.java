package Softude.Hyperlocology.Tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Softude.Hyperlocology.TestComponents.BaseTest;
import Softude.Hyperlocology.pageobjects.BrandUserPage;
import Softude.Hyperlocology.pageobjects.Brands;
import Softude.Hyperlocology.pageobjects.EditBrandPage;
import Softude.Hyperlocology.pageobjects.ParentCompanies;

public class BrandUserPageTest extends BaseTest {

	@Test(dataProvider="getData")
	public void addBrandUsers(HashMap<String,String>input) throws InterruptedException {
		ParentCompanies parentCompanies=loginPage.login("pooja.saratkar@softude.com","Pooja##12345");
		Brands brand=parentCompanies.goToBrandsPage();
		EditBrandPage editBrand=brand.goToEditBrandsPages();
		editBrand.editBasicInformation("Automated Brand");
		BrandUserPage brandUser=editBrand.goToBrandUserPage();
        brandUser.addBrandUser(input.get("FirstName"),input.get("LastName"),input.get("Email"),input.get("MobileNo"));
	}
	@DataProvider
	public Object[][] getData() throws IOException {
		List<HashMap<String, String>> data=getJsonDataToMap(System.getProperty("user.dir")+"//src//test//java//Softude//Hyperlocology//Data//AddBrandUsers.json");
		return new Object [][]{{data.get(0)},{data.get(1)},{data.get(2)}};
	}
}
