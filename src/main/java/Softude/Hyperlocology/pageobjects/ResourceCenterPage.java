package Softude.Hyperlocology.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Softude.Hyperlocology.abstractComponents.AbstractComponents;

public class ResourceCenterPage extends AbstractComponents {

	WebDriver driver;
	public ResourceCenterPage(WebDriver driver) {
		super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
        
	}
	@FindBy(name="video[0][video_title]")
	WebElement vedioTitle;
	@FindBy(name="video[0][video_url]")
	WebElement vedioUrl;
	@FindBy(id="SavePassword")
	WebElement saveBtn;
	@FindBy(id="cancleBtn")
	WebElement cancelBtn;
	
	public void addEducationalVedios(String VedioTitle, String VedioUrl) {
		waitingForElementToBeVisible(vedioTitle);
		vedioTitle.sendKeys(VedioTitle);
		vedioUrl.sendKeys(VedioUrl);
		cancelBtn.click();
	}
}
