package Softude.Hyperlocology.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Softude.Hyperlocology.TestComponents.BaseTest;
import Softude.Hyperlocology.pageobjects.GroupsPage;
import Softude.Hyperlocology.pageobjects.ParentCompanies;

public class GroupsPageTest extends BaseTest {

	@Test
	public void addNewGroup() {
		ParentCompanies parentCompanies=loginPage.login("pooja.saratkar@softude.com","Pooja##12345");
		GroupsPage groupsPage=parentCompanies.goToGroupsPage();
		groupsPage.addNewGroup("Testing Group","Big Brand", "Mississippi");
	}
	@Test
	public void validateTheBrandName() throws InterruptedException {
		ParentCompanies parentCompanies=loginPage.login("pooja.saratkar@softude.com","Pooja##12345");
		GroupsPage groupsPage=parentCompanies.goToGroupsPage();
		String actualBrand=groupsPage.validateTheBrandName("Tops");
		Assert.assertEquals(actualBrand,"Hospitality");
		
	}
	@Test
	public void validateTheGroupStatus() throws InterruptedException {
		ParentCompanies parentCompanies=loginPage.login("pooja.saratkar@softude.com","Pooja##12345");
		GroupsPage groupsPage=parentCompanies.goToGroupsPage();
		String foundStatus=groupsPage.validateTheStatus("Tops");
		Assert.assertEquals(foundStatus,"Active");
	}
}

