package Softude.Hyperlocology.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Softude.Hyperlocology.abstractComponents.AbstractComponents;

public class GroupsPage extends AbstractComponents{

	WebDriver driver;
	public GroupsPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(css="#datatable tr td:nth-of-type(3) a")
	WebElement brandName;
	@FindBy(css="#datatable_filter input[type='search']")
	WebElement search;
	@FindBy(css="#datatable tr td:nth-of-type(5) span")
	WebElement status;
	@FindBy(css=".sg-search")
	WebElement advanceSearch;
	@FindBy(name="group_name")
	WebElement groupName;
	@FindBy(id="status")
	WebElement statusDropdown;
	@FindBy(id="searchFilter")
	WebElement searchBtn;
	@FindBy(css="a[href*='group/add']")
	WebElement addNewBtn;
	@FindBy(id="fkBrandId")
	WebElement brandDropdown;
	@FindBy(id="regionDD")
	WebElement regionDropdown;
	@FindBy(xpath="(//button[.='Select All'])[2]")
	WebElement selectAllBtn;
	@FindBy(xpath="(//button[@type='button'])[5]")
	WebElement brandAndLocation;
	@FindBy(css=".normal-slider")
	WebElement statusBtn;
	@FindBy(name="submit")
	WebElement submitBtn;
	
	public String validateTheBrandName(String GroupName) throws InterruptedException {
		waitingForElementToBeVisible(search);
		search.sendKeys(GroupName);
		Thread.sleep(1000);
	    return brandName.getText();
	}
	public String validateTheStatus(String GroupName) throws InterruptedException {
		waitingForElementToBeVisible(search);
		search.sendKeys(GroupName);
		Thread.sleep(1000);
		return status.getText();
	}
	
	public void advanceSearchValidation(String GroupName, String Status) {
		waitingForElementToBeVisible(advanceSearch);
		advanceSearch.click();
		waitingForElementToBeVisible(groupName);
		groupName.sendKeys(GroupName);
		selectElementByVisibleText(statusDropdown, Status);
		searchBtn.click();
	}
	public void addNewGroup(String GroupName,String BrandName, String Region) {
		waitingForElementToBeVisible(addNewBtn);
		addNewBtn.click();
		waitingForElementToBeVisible(groupName);
		groupName.sendKeys(GroupName);
		selectElementByVisibleText(brandDropdown, BrandName);
		selectElementByVisibleText(regionDropdown,Region);
		waitingForElementToBeVisible(brandAndLocation);
		waitingForElementToBeClickable(brandAndLocation);
		brandAndLocation.click();
		waitingForElementToBeVisible(selectAllBtn);
		selectAllBtn.click();
		statusBtn.click();
	}
	

}
