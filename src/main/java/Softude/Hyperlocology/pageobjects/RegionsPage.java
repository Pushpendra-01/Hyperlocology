package Softude.Hyperlocology.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Softude.Hyperlocology.abstractComponents.AbstractComponents;

public class RegionsPage extends AbstractComponents{

	WebDriver driver;
	public RegionsPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(css="input[type='search']")
	WebElement search;
	@FindBy(css="#datatable tr td:nth-of-type(3) span")
	WebElement status;
	@FindBy(css="#datatable tr td:nth-of-type(4) a")
	WebElement actionBtn;
	@FindBy(css="div[for='customSwitchPrimary']")
	WebElement statusBtn;
	@FindBy(name="submit")
	WebElement submitBtn;
	@FindBy(css="a[href*='add']")
	WebElement addBtn;
	@FindBy(name="region_name")
	WebElement regionName;
	
	
	public void changeTheStatusOfRegion(String RegionName) {
		waitingForElementToBeVisible(search);
		search.sendKeys(RegionName);
		waitingForElementToBeVisible(actionBtn);
		actionBtn.click();
		waitingForElementToBeVisible(statusBtn);
		statusBtn.click();
//		submitBtn.click();
	}
	
	public String validationOfRegionStatusIsActive(String RegionName) {
		waitingForElementToBeVisible(search);
		search.sendKeys(RegionName);
		waitingForElementToBeVisible(status);
		return status.getText();
	}
	public void addNewRegion(String RegionName) {
		waitingForElementToBeVisible(addBtn);
		addBtn.click();
		waitingForElementToBeVisible(regionName);
		regionName.sendKeys(RegionName);
		statusBtn.click();
//		submitBtn.click();
	}
		
}
	
	


