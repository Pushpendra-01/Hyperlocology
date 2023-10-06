package Softude.Hyperlocology.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Softude.Hyperlocology.abstractComponents.AbstractComponents;
import Softude.Hyperlocology.utils.LoginPageLocators;

public class LandingPage extends AbstractComponents{

	WebDriver driver;
	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	   @FindBy(name="username")
	    WebElement userName;
	    @FindBy(id="password")
	    WebElement userPassword;
	    @FindBy(tagName="button")
	    WebElement loginButton;
	    @FindBy(css=".toast-message")
	    WebElement errormsg;

	public void login(String userEmail, String password) {
		waitingForElementToBeVisible(userName);
    	userName.sendKeys(userEmail);
    	userPassword.sendKeys(password);
    	loginButton.click();
    	
    }
	public String loginErrorMessage() {
		return errormsg.getText();
	}
    public void goTO() {
    	driver.get("https://dev-admin.hyperlocology.com/");
    }



}
