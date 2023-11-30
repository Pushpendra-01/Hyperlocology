package Softude.Hyperlocology.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Softude.Hyperlocology.abstractComponents.AbstractComponents;

public class ReportConfig extends AbstractComponents{
    WebDriver driver;
	public ReportConfig(WebDriver driver) {
		super(driver);
		this.driver=driver;
	 PageFactory.initElements(driver,this);
	}
	
	@FindBy(css="a[href*='campaign/create']")
	WebElement createNewTemplate;
	@FindBy(id="name")
	WebElement templateName;
	@FindBy(css="button[data-toggle='modal']")
	WebElement pickFromLibrary;
	@FindBy(css=".modal-content input[type='search']")
	WebElement search;
	@FindBy(css="a[title='Add to List']")
	WebElement addBtn;
	@FindBy(css="a[href*='report-config/brand']")
	WebElement brandDashboard;
	@FindBy(css="button:nth-of-type(2)")
	WebElement yesBtn;
	@FindBy(css="div[class='swal2-actions'] button:first-child")
	WebElement okBtn;
	
	public void pickTemplateFromLibrary(String TemplateName) throws InterruptedException {
		waitingForElementToBeVisible(pickFromLibrary);
		pickFromLibrary.click();
		search.sendKeys(TemplateName);
		Thread.sleep(2000);
		addBtn.click();
	}
	public void goToBrandDashboard(String BrandName) throws InterruptedException {
		waitingForElementToBeVisible(brandDashboard);
		brandDashboard.click();
		Thread.sleep(2000);
		pickFromLibrary.click();
		search.sendKeys(BrandName);
		Thread.sleep(2000);
		addBtn.click();
		waitingForElementToBeVisible(yesBtn);
		yesBtn.click();
		waitingForElementToBeVisible(okBtn);
		okBtn.click();
	}

}
