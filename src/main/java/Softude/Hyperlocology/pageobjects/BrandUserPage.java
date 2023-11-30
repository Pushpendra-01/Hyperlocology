package Softude.Hyperlocology.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Softude.Hyperlocology.abstractComponents.AbstractComponents;

public class BrandUserPage extends AbstractComponents{

	WebDriver driver;
	public BrandUserPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	@FindBy(id="addBrandUserBtn")
	WebElement addBrandUser;
	@FindBy(name="first_name")
	WebElement firstName;
	@FindBy(name="last_name")
	WebElement lastName;
	@FindBy(name="email")
	WebElement email;
	@FindBy(name="mobile_no")
	WebElement mobileNo;
	@FindBy(css="div[class='slider round']")
	WebElement sendEmailNotification;
	@FindBy(name="submit")
	WebElement addBtn;
	public void addBrandUser(String FirstName, String LastName, String Email, String MobileNo) {
		waitingForElementToBeVisible(addBrandUser);
		addBrandUser.click();
		waitingForElementToBeVisible(firstName);
		firstName.sendKeys(FirstName);
		lastName.sendKeys(LastName);
		email.sendKeys(Email);
		mobileNo.sendKeys(MobileNo);
		sendEmailNotification.click();
		addBtn.click();
	}
	
}
