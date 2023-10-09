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
	    @FindBy(css="a[href='/forgot-password']")
	    WebElement forgotPassword;
	    @FindBy(name="email")
	    WebElement email;
	    @FindBy(css=".dropdown-item.pl-2:nth-of-type(2)")
	    WebElement logoutBtn;
	    @FindBy(css="img[alt='profile-user']")
	    WebElement userProfile;
	    @FindBy(css=".swal2-actions button:last-child")
	    WebElement yesBtn;
        @FindBy(tagName="p")
        WebElement title;
        
        
	public ParentCompanies login(String userEmail, String password) {
		waitingForElementToBeVisible(userName);
    	userName.sendKeys(userEmail);
    	userPassword.sendKeys(password);
    	loginButton.click();
    	ParentCompanies parentCompnaies=new ParentCompanies(driver);
    	return parentCompnaies;
    }
	public String loginErrorMessage() {
		return errormsg.getText();
	}
    public void goTO() {
    	driver.get("https://dev-admin.hyperlocology.com/");
    }
    public void forgotPassword(String registerdEmail) {
    	forgotPassword.click();
    	email.sendKeys(registerdEmail);
    	loginButton.click();
    }
    public void logout() {
    	waitingForElementToBeVisible(userProfile);
    	userProfile.click();
    	logoutBtn.click();
    	waitingForElementToBeVisible(yesBtn);
    	yesBtn.click();
    }
    public String LoginPageTitle() {
    	return title.getText();
    }



}
