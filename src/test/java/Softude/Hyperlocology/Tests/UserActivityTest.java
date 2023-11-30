package Softude.Hyperlocology.Tests;

import org.testng.annotations.Test;

import Softude.Hyperlocology.TestComponents.BaseTest;
import Softude.Hyperlocology.pageobjects.ParentCompanies;
import Softude.Hyperlocology.pageobjects.UserActivityPage;

public class UserActivityTest extends BaseTest{
	@Test
	public void getBrandsUsers() {
		ParentCompanies parentCompanies=loginPage.login("pooja.saratkar@softude.com","Pooja##12345");
        UserActivityPage userActivity=parentCompanies.goToUserActivityPage();
        userActivity.getTheUserNames("Astor-martin");
	}
	@Test
	public void getBrandsUsersEmail() {
		ParentCompanies parentCompanies=loginPage.login("pooja.saratkar@softude.com","Pooja##12345");
        UserActivityPage userActivity=parentCompanies.goToUserActivityPage();
        userActivity.getTheUserEmail("Astor-martin");
	}
	

}
