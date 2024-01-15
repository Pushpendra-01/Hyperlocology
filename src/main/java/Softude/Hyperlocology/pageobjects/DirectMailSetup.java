package Softude.Hyperlocology.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Softude.Hyperlocology.abstractComponents.AbstractComponents;

public class DirectMailSetup extends AbstractComponents {

	WebDriver driver;
	public DirectMailSetup(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="(//input[@type='search'])[3]")
	WebElement searchbar;
	@FindBy(css="tr td:nth-of-type(3)")
	List<WebElement> campaignList;
	@FindBy(css="tr td:nth-of-type(2) a")
	List<WebElement> brandsList; 
	@FindBy(css="tr td:nth-of-type(6) span")
	List<WebElement> statusList;
	
	public WebElement validateTheCampaignType(String CampaignName) throws InterruptedException {
		waitingForVisibilityOfAllTheElement(campaignList);
		Thread.sleep(2000);
		WebElement campaignType=campaignList.stream().filter(c->c.getText().equalsIgnoreCase(CampaignName)).findFirst().orElse(null);
		return campaignType;
	}
	public void validateTheBrandName(String CampaignName) {
		waitingForVisibilityOfAllTheElement(brandsList);
		WebElement brandName=brandsList.stream().filter(b->b.getText().equalsIgnoreCase(CampaignName)).findFirst().orElse(null);
	}

}
