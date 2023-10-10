package Softude.Hyperlocology.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Softude.Hyperlocology.abstractComponents.AbstractComponents;

public class Brands extends AbstractComponents{

	WebDriver driver;
	public Brands(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	
	@FindBy(css="a[href$='brand/basic-information']")
	WebElement addBtn;
	@FindBy(css="input[name='brand_name']")
	WebElement brandName;
	@FindBy(name="first_name")
	WebElement firstName;
	@FindBy(name="last_name")
	WebElement lastName;
	@FindBy(name="email")
	WebElement email;
	@FindBy(name="mobile_no")
	WebElement mobileNo;
	@FindBy(name="start_date")
	WebElement startDate;
	@FindBy(css="button[data-id='period']")
	WebElement subscriptionMonths;
	@FindBy(id="endDate")
	WebElement endDate;
	
	public void fillBrandsDetails(String BrandName,String FirstName,String LastName,String Email,String MobileNo) {
		addBtn.click();
		waitingForElementToBeVisible(brandName);
		brandName.sendKeys(BrandName);
		firstName.sendKeys(FirstName);
		lastName.sendKeys(LastName);
		email.sendKeys(Email);
		mobileNo.sendKeys(MobileNo);
	}
	public void selectStartDate() {
		startDate.click();
	}

}
