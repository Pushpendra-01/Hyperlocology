package Softude.Hyperlocology.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Softude.Hyperlocology.abstractComponents.AbstractComponents;

public class ParentCompanies extends AbstractComponents {
   
	WebDriver driver;
	public ParentCompanies(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	@FindBy(id="companyLink")
	WebElement parentCompanies;
	@FindBy(css="a[href='company/add']")
	WebElement addBtn;
	@FindBy(name="company_name")
	WebElement companyName;
	@FindBy(name="first_name")
	WebElement fristName;
	@FindBy(name="last_name")
	WebElement lastName;
	@FindBy(name="email")
	WebElement compEmail;
	@FindBy(name="mobile_no")
	WebElement mobileNo;
	@FindBy(css=".slider.round")
	WebElement emailNotification;
	@FindBy(id="input-file-now")
	WebElement attachlogo;
	@FindBy(css="div[class='normal-slider round']")
	WebElement status;
	@FindBy(css="button[value='Save']")
	WebElement saveBtn; 
	@FindBy(css="button[value='Save & Add Brands']")
	WebElement saveAndAddBrands;
	@FindBy(id="brandLink")
	WebElement brandsPage;
	@FindBy(id="parsley-id-11")
	WebElement errorMessage;
	
	public void addParentCompany(String CompanyName,String FirstName,String LastName,String email, String MobileNo) {
		parentCompanies.click();
		waitingForElementToBeVisible(addBtn);
		addBtn.click();
		companyName.sendKeys(CompanyName);
		fristName.sendKeys(FirstName);
		lastName.sendKeys(LastName);
		compEmail.sendKeys(email);
		mobileNo.sendKeys(MobileNo);
	}
	public void sendEmailNotification() {
		emailNotification.click();
	}
	public void setStatusAsInactive() {
		status.click();
	}
	public void attachCompanyLogo(String logopath) {
		attachlogo.sendKeys(logopath);
	}
	public void saveParentCompany() {
		saveBtn.click();
	}
	public void saveAndAddBrands() {
		saveAndAddBrands.click();
	}
	public Brands goToBrandsPage() {
		waitingForElementToBeVisible(brandsPage);
		Brands brands=new Brands(driver);
		brandsPage.click();
		return brands;
	}
	public String getErrorMessage() {
		return errorMessage.getText();
		
	}
	
}
