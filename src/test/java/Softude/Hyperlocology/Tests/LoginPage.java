package Softude.Hyperlocology.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Softude.Hyperlocology.TestComponents.BaseTest;
import Softude.Hyperlocology.TestComponents.Retry;
import Softude.Hyperlocology.pageobjects.LandingPage;

public class LoginPage extends BaseTest {

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
	@Test(retryAnalyzer=Retry.class)
	public void loginWithIncorrectPassword() {
		loginPage.login("superadmin@hyperlocology.com","Ps@1234");
		Assert.assertEquals(loginPage.loginErrorMessage(),"wrong passwrod please enter correct password");
	}
	
}
