package Softude.Hyperlocology.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Softude.Hyperlocology.TestComponents.BaseTest;
import Softude.Hyperlocology.pageobjects.LandingPage;

pu blic class LoginPage extends BaseTest {

	@Test
	public void loginWithValidCredentials() {
		loginPage.login("superadmin@hyperlocology.com", "Hyper@2023");
		
	}
	@Test
	public void loginwithIncorrectEmail() {
		loginPage.login("superadmin@gmail.com", "Hyper@2023");
//		System.out.println(loginPage.loginErrorMessage());
		Assert.assertEquals(loginPage.loginErrorMessage(),"Wrong email or password, please try again.");
	}
}
