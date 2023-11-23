package Softude.Hyperlocology.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import Softude.Hyperlocology.abstractComponents.AbstractComponents;
import dev.failsafe.internal.util.Assert;

public class LocationPage extends AbstractComponents {

	WebDriver driver;
	public LocationPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	@FindBy(css="#datatable tr td a")
	List<WebElement>brands;
	@FindBy(xpath="(//a[@href='javascript:void(0);'])[2]")
	WebElement locationBtn;
	@FindBy(name="participant_mass_upload")
	WebElement addFile;
	@FindBy(css="button[value='Upload']")
	WebElement uploadBtn;
	@FindBy(css="a[href*='subscription-mass-upload']")
	WebElement subscriptionPage;
	@FindBy(name="participant_sub_mass_upload")
	WebElement addSubscriptionFile;
	
	public void editBasicInformation(String BrandName) throws InterruptedException {
		Thread.sleep(2000);
		WebElement brandName=brands.stream().filter(b->b.getText().equalsIgnoreCase(BrandName)).findFirst().orElse(null);
		brandName.click();
	}
	public void addLocation(String filePath) {
		waitingForElementToBeClickable(locationBtn);
	    locationBtn.click();
	    waitingForElementToBeVisible(addFile);
	    addFile.sendKeys(filePath);
	    waitingForElementToBeClickable(uploadBtn);
	    uploadBtn.click();
	}
	public SubscriptionPage goToSubscriptionPage() {
		waitingForElementToBeClickable(subscriptionPage);
		SubscriptionPage subscriptionPage=new SubscriptionPage(driver);
		return subscriptionPage;
	}
	

}
