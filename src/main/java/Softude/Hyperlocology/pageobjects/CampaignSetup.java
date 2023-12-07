package Softude.Hyperlocology.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Softude.Hyperlocology.abstractComponents.AbstractComponents;

public class CampaignSetup extends AbstractComponents{

	WebDriver driver;
	public CampaignSetup(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(css="label input[type='search']")
	WebElement searchBox;
	@FindBy(css="#datatable tr td:nth-of-type(3) a")
	WebElement brandName;
	@FindBy(css="#datatable tr td:nth-of-type(2) a")
	WebElement campaignName;
	@FindBy(css="#datatable tr td:nth-of-type(9) span")
	WebElement status;
	@FindBy(css="#datatable tr td:nth-of-type(5)")
	WebElement compaignType;
	
	public void getBrandName(String CampaignName) throws InterruptedException {
		waitingForElementToBeVisible(searchBox);
		searchBox.sendKeys();
		Thread.sleep(1000);
		brandName.getText();
		
	}

}
