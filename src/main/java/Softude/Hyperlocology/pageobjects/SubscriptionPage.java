package Softude.Hyperlocology.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Softude.Hyperlocology.abstractComponents.AbstractComponents;

public class SubscriptionPage extends AbstractComponents {

	WebDriver driver;
	public SubscriptionPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	@FindBy(css="a[href*='/subscriptions/pages']")
	WebElement subscriptionBtn;
	@FindBy(css="a[href*='subscription-mass-upload']")
	WebElement subscriptionPage;
	@FindBy(name="participant_sub_mass_upload")
	WebElement addSubscriptionFile;
	@FindBy(css="button[value='Upload']")
	WebElement uploadBtn;
	@FindBy(css="a[href*='page-setup']")
	WebElement pageSetup_Page;
	
	public void fillSubcriptionDetails(String filePath) {
		waitingForElementToBeClickable(subscriptionPage);
		subscriptionPage.click();
		waitingForElementToBeVisible(addSubscriptionFile);
		addSubscriptionFile.sendKeys(filePath);
		waitingForElementToBeClickable(uploadBtn);
		uploadBtn.click();
	}
	public PageSetup goToPageSetup() {
		waitingForElementToBeClickable(pageSetup_Page);
		PageSetup pageSetup=new PageSetup(driver);
		pageSetup_Page.click();
		return pageSetup;
	}
}
