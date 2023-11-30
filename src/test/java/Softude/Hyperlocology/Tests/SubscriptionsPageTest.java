package Softude.Hyperlocology.Tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Softude.Hyperlocology.TestComponents.BaseTest;
import Softude.Hyperlocology.pageobjects.Brands;
import Softude.Hyperlocology.pageobjects.ParentCompanies;
import Softude.Hyperlocology.pageobjects.SubscriptionsPage;

public class SubscriptionsPageTest extends BaseTest{

	// Validating if the subscription page is present or not
	@Test
	public void ValidateTheStatusOfBrand() {
		ParentCompanies parentCompanies=loginPage.login("pooja.saratkar@softude.com","Pooja##12345");
		Brands brandsPage=parentCompanies.goToBrandsPage();
		SubscriptionsPage subsPage=brandsPage.goToSubscriptionsPage();
		String status=subsPage.ValidateTheStatusOfBrand("Morgan");
//		Assert.assertEquals(status,"Active");
		SoftAssert softassert=new SoftAssert();
		softassert.assertEquals(status,"Active");
	}
	@Test(dataProvider="getData")
	public void addNewSubscriptionPage(HashMap<String,String>input) {
		ParentCompanies parentCompanies=loginPage.login("pooja.saratkar@softude.com","Pooja##12345");
		Brands brandsPage=parentCompanies.goToBrandsPage();
		SubscriptionsPage subsPage=brandsPage.goToSubscriptionsPage();
		subsPage.addNewSubscriptionPage(input.get("BrandName"), input.get("PageTitle"),input.get("PlanTitle"), input.get("LocationListTitle"), input.get("DescriptionText"), input.get("Note"),input.get("ContactEmail"));
		
	}
	@DataProvider
	public Object[][] getData() throws IOException {
		List<HashMap<String, String>>data=getJsonDataToMap(System.getProperty("user.dir")+"\\src\\test\\java\\Softude\\Hyperlocology\\Data\\NewSubscriptionPage.json");
		return new Object[][] {{data.get(0)},{data.get(1)}};
	}
}
