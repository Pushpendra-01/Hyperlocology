package Softude.Hyperlocology.Tests;

import org.testng.annotations.Test;

import Softude.Hyperlocology.TestComponents.BaseTest;
import Softude.Hyperlocology.pageobjects.LocationsPage;
import Softude.Hyperlocology.pageobjects.ParentCompanies;

public class LocationsPageTest extends BaseTest {
	@Test
	public void getBrandIdOfLocation()  {
		ParentCompanies parentCompanies=loginPage.login("pooja.saratkar@softude.com","Pooja##12345");
		LocationsPage locationsPage=parentCompanies.goToLocationsPage();
		locationsPage.getBrandId("Phoenix1");
	}
	@Test
	public void getCityNameOfLocation(){
		ParentCompanies parentCompanies=loginPage.login("pooja.saratkar@softude.com","Pooja##12345");
		LocationsPage locationsPage=parentCompanies.goToLocationsPage();
		locationsPage.getCityName("Phoenix2");
	}
	

}
