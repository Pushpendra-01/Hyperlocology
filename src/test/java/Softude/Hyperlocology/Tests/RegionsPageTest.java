package Softude.Hyperlocology.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Softude.Hyperlocology.TestComponents.BaseTest;
import Softude.Hyperlocology.pageobjects.ParentCompanies;
import Softude.Hyperlocology.pageobjects.RegionsPage;

public class RegionsPageTest extends BaseTest {
	@Test
	public void addNewRegion() {
		ParentCompanies parentCompanies=loginPage.login("pooja.saratkar@softude.com","Pooja##12345");
		RegionsPage regionsPage=parentCompanies.goToRegionsPage();
		regionsPage.addNewRegion("Testing Region");
		
	}
	@Test
	public void validationOfStatus() {
		ParentCompanies parentCompanies=loginPage.login("pooja.saratkar@softude.com","Pooja##12345");
		RegionsPage regionsPage=parentCompanies.goToRegionsPage();
		Assert.assertEquals("Active",regionsPage.validationOfRegionStatusIsActive("JohnsonCity"));
	}
	@Test
	public void changeTheStatusOfTheRegion() {
		ParentCompanies parentCompanies=loginPage.login("pooja.saratkar@softude.com","Pooja##12345");
		RegionsPage regionsPage=parentCompanies.goToRegionsPage();
		regionsPage.changeTheStatusOfRegion("JohnsonCity");
	}

}
