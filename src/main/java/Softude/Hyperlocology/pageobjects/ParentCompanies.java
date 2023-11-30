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
	@FindBy(css="#datatable_filter input[type='search']")
	WebElement searchBar;
	@FindBy(css=".odd td:nth-of-type(3)")
	WebElement companyNames;
	@FindBy(css=".odd td:nth-of-type(4)")
	WebElement companyOwner;
	@FindBy(css="#metismenu li:nth-of-type(5)")
	WebElement userActivity;
	@FindBy(css="#metismenu li:nth-of-type(7)")
	WebElement participantsPage;
	@FindBy(css="#metismenu li:nth-of-type(8)")
	WebElement locationsPage;
	@FindBy(css="#metismenu li:nth-of-type(9)")
	WebElement regionsPage;
	@FindBy(css="#metismenu li:nth-of-type(10)")
	WebElement groupsPage;
	
	public void addParentCompany(String CompanyName,String FirstName,String LastName,String email, String MobileNo) {
		parentCompanies.click();
		waitingForElementToBeClickable(addBtn);
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
	public String searchParentCompany(String CompanyName) throws InterruptedException {
		waitingForElementToBeClickable(parentCompanies);
		parentCompanies.click();
		waitingForElementToBeVisible(searchBar);
		searchBar.sendKeys(CompanyName);
		Thread.sleep(2000);
		String expectedCompany=companyNames.getText();
		return expectedCompany;
	}
	public String OwnerName(String CompanyName) throws InterruptedException {
		waitingForElementToBeClickable(parentCompanies);
		parentCompanies.click();
		waitingForElementToBeVisible(searchBar);
		searchBar.sendKeys(CompanyName);
		Thread.sleep(2000);
        return companyOwner.getText();		
	}
	public UserActivityPage goToUserActivityPage() {
		waitingForElementToBeVisible(userActivity);
		userActivity.click();
		UserActivityPage useract=new UserActivityPage(driver);
		return useract;
	}
	public ParticipantsPage goToParticipantPage() {
		waitingForElementToBeVisible(participantsPage);
		participantsPage.click();
		ParticipantsPage participant=new ParticipantsPage(driver);
		return participant;
	}
	public LocationsPage goToLocationsPage() {
		waitingForElementToBeVisible(locationsPage);
		locationsPage.click();
		LocationsPage locations=new LocationsPage(driver);
		return locations;
	}
	public RegionsPage goToRegionsPage() {
		waitingForElementToBeClickable(regionsPage);
		regionsPage.click();
		RegionsPage region=new RegionsPage(driver);
		return region;
	}
	public GroupsPage goToGroupsPage() {
		waitingForElementToBeClickable(groupsPage);
		groupsPage.click();
		GroupsPage groups=new GroupsPage(driver);
		return groups;
	}
}
