package Softude.Hyperlocology.pageobjects;

import java.util.List;

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
	List<WebElement> compaignType;
	
	public String getBrandName(String CampaignName) throws InterruptedException {
		waitingForElementToBeVisible(searchBox);
		searchBox.sendKeys(CampaignName);
		Thread.sleep(2000);
		return brandName.getText();
	}
	public String validateTheCampaignType(String CampaignName) throws InterruptedException {
		waitingForVisibilityOfAllTheElement(compaignType);
		searchBox.sendKeys(CampaignName);
		Thread.sleep(1000);
		String compType=compaignType.get(0).getText();
		return compType;
	}
	

}
