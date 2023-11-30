package Softude.Hyperlocology.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import Softude.Hyperlocology.abstractComponents.AbstractComponents;
import dev.failsafe.internal.util.Assert;

public class EditBrandPage extends AbstractComponents {

	WebDriver driver;
	public EditBrandPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	@FindBy(css="#datatable tr td a")
	List<WebElement>brands;
	@FindBy(css=".nav-tabs li:nth-child(2)")
	WebElement attachCollateral;
	@FindBy(name="file_name")
	WebElement fileNameInput;
	@FindBy(id="input-file-now")
	WebElement attachFile;
	@FindBy(css=".btn-primary")
	WebElement addBtn;
	@FindBy(css="input[name='brand_name']")
	WebElement brandNameInput;
	@FindBy(name="first_name")
	WebElement firstNameInput;
	@FindBy(name="last_name")
	WebElement lastNameInput;
	@FindBy(name="email")
	WebElement emailInput;
	@FindBy(name="mobile_no")
	WebElement mobileInput;
	@FindBy(name="submit")
	WebElement updateBtn;
	@FindBy(css=".toast-message")
	WebElement successMsg;
	@FindBy(css="a[href*='participant-mass-upload']")
	WebElement locationBtn;
	@FindBy(name="participant_mass_upload")
	WebElement addFile;
	@FindBy(css="button[value='Upload']")
	WebElement uploadBtn;
	@FindBy(css="a[href*='subscription-mass-upload']")
	WebElement subscriptionPage;
	@FindBy(name="participant_sub_mass_upload")
	WebElement addSubscriptionFile;
	@FindBy(xpath="(//input[@type='search'])[2]")
	WebElement search;
	@FindBy(css="a[href*='page-setup']")
	WebElement pageSetup_Page;
	@FindBy(css="a[href*='report-config/campaign']")
	WebElement reportConfigPage;
	@FindBy(css="ul[role='tablist'] li:nth-of-type(7)")
	WebElement brandUser;
	@FindBy(css="a[href*='resource-center']")
	WebElement resourceCenter;
	@FindBy(css="a[href*='master-login']")
	WebElement masterLoginPage;
	
	
	
    	public void editBasicInformation(String BrandName) throws InterruptedException {
		Thread.sleep(2000);
		search.sendKeys(BrandName);
        Thread.sleep(1000);
		WebElement brandName=brands.stream().filter(b->b.getText().equalsIgnoreCase(BrandName)).findFirst().orElse(null);
		waitingForElementToBeVisible(brandName);
		waitingForElementToBeClickable(brandName);
		brandName.click();
	}
		public void editBrnadName(String newBrandName) {
			waitingForElementToBeVisible(brandNameInput);
			brandNameInput.clear();
			brandNameInput.sendKeys(newBrandName);	
		}
		public void editFirstName(String newFirstName) {
			waitingForElementToBeVisible(firstNameInput);
			firstNameInput.clear();
			firstNameInput.sendKeys(newFirstName);
		}
		public void editLastName(String newLastName) {
			waitingForElementToBeVisible(lastNameInput);
			lastNameInput.clear();
			lastNameInput.sendKeys(newLastName);
		}
		public void editEmail(String newEmail) {
			waitingForElementToBeVisible(emailInput);
			emailInput.clear();
			emailInput.sendKeys(newEmail);
		}
		public void editPhoneNo(String newMobileNo) {
			mobileInput.click();
			mobileInput.sendKeys(newMobileNo);
		}
		public void updateTheDetails() {
			updateBtn.click();
		}
	
	public void attachCollateral(String fileName,String filePath) {
		waitingForElementToBeClickable(attachCollateral);
		attachCollateral.click();
		waitingForElementToBeClickable(fileNameInput);
		fileNameInput.sendKeys(fileName);
		attachFile.sendKeys(filePath);
		addBtn.click();
//        System.out.println(successMsg.getText());
	}
	public String successMessage() {
		String successmsg=successMsg.getText();
		return successmsg;
	}
	public void addLocation(String filePath) {
		waitingForElementToBeClickable(locationBtn);
	    locationBtn.click();
	    waitingForElementToBeVisible(addFile);
	    addFile.sendKeys(filePath);
	    waitingForElementToBeClickable(uploadBtn);
	    uploadBtn.click();
	}
	public void goToSubscriptionPage(String filePath) {
		waitingForElementToBeClickable(subscriptionPage);
		subscriptionPage.click();
		waitingForElementToBeVisible(addSubscriptionFile);
		addSubscriptionFile.sendKeys(filePath);
		waitingForElementToBeClickable(uploadBtn);
		uploadBtn.click();
		
	}
	public AttachCollateral goToAttachCollateralPage() {
		waitingForElementToBeClickable(attachCollateral);
		AttachCollateral attachCollatreal=new AttachCollateral(driver);
		attachCollateral.click();
		return attachCollatreal;
	}
	public SubscriptionPage goToSubscriptionPage() {
		waitingForElementToBeClickable(subscriptionPage);
		SubscriptionPage subscriptionPage=new SubscriptionPage(driver);
		return subscriptionPage;
	}
	public LocationPage goToLocationPage() {
		waitingForElementToBeClickable(locationBtn);
		LocationPage locationPage=new LocationPage(driver);
		locationBtn.click();
		return locationPage;
	}
	public PageSetup goToPageSetup() {
		waitingForElementToBeClickable(pageSetup_Page);
		PageSetup pageSetup=new PageSetup(driver);
		pageSetup_Page.click();
		return pageSetup;
	}
	public ReportConfig goToReportConfigPage() {
		waitingForElementToBeClickable(reportConfigPage);
		reportConfigPage.click();
		ReportConfig reportConfig=new ReportConfig(driver);
		return reportConfig;
	}
	public BrandUserPage goToBrandUserPage() {
		waitingForElementToBeClickable(brandUser);
		brandUser.click();
		BrandUserPage brandUserPage=new BrandUserPage(driver);
		return brandUserPage;
	}
	public ResourceCenterPage goToResourceCenterPage() {
		waitingForElementToBeVisible(resourceCenter);
		resourceCenter.click();
		ResourceCenterPage resourceCenterPage=new ResourceCenterPage(driver);
		return resourceCenterPage;
	}
	public MasterLoginPage goToMasterLoginPage() {
		waitingForElementToBeVisible(masterLoginPage);
		masterLoginPage.click();
		MasterLoginPage masterLogin=new MasterLoginPage(driver);
		return masterLogin;
	}
    
}
