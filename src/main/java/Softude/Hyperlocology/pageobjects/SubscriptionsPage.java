package Softude.Hyperlocology.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Softude.Hyperlocology.abstractComponents.AbstractComponents;

public class SubscriptionsPage extends AbstractComponents {

	public SubscriptionsPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(css="button[type='button']")
	WebElement brandsDropdown;
	@FindBy(css=".bs-searchbox input")
	WebElement brandsSearchBox;
	@FindBy(css="#bs-select-1 ul li")
	List<WebElement> brandsOptions;
	@FindBy(css="label input[type='search']")
	WebElement searchBox;
	@FindBy(css="tr[role='row'] td:nth-of-type(2)")
	List<WebElement> brandsOpt;
	@FindBy(css="tr[role='row'] td:nth-of-type(3) span")
	WebElement status; 
	@FindBy(css="a[href*='add']")
	WebElement addBtn;
	@FindBy(css="button[role='combobox']")
	WebElement brndsDropdown;
	@FindBy(css="div input[type='search']")
	WebElement brandSearchBox;
	@FindBy(css="ul[role='presentation'] li")
	List<WebElement> brandsOption;
	@FindBy(name="page_title")
	WebElement pageTitle;
	@FindBy(name="package_title")
	WebElement planTitle;
	@FindBy(name="location_list_title")
	WebElement locationListTitle;
	@FindBy(xpath="(//div[@role='textbox']/p)[1]")
	WebElement descriptonText;
	@FindBy(xpath="(//div[@role='textbox']/p)[2]")
	WebElement noteText;
	@FindBy(name="contact_email")
	WebElement contactEmail;
	@FindBy(css="button[type='submit']")
	WebElement saveBtn;
	
	public String ValidateTheStatusOfBrand(String BrandName) {
		waitingForElementToBeVisible(brandsDropdown);
		brandsDropdown.click();
		waitingForElementToBeVisible(brandsSearchBox);
		brandsSearchBox.sendKeys(BrandName);
		WebElement brand=brandsOptions.stream().filter(opt->opt.getText().equalsIgnoreCase(BrandName)).findFirst().orElse(null);
		brand.click();
		return status.getText();
	}
	
	public void addNewSubscriptionPage(String BrandName,String PageTitle,String PlanTitle,String LocationListTitle,String DescriptionText, String Note,String ContactEmail) {
		addBtn.click();
		waitingForElementToBeVisible(brndsDropdown);
		brndsDropdown.click();
		brandSearchBox.sendKeys(BrandName);
		WebElement brand=brandsOption.stream().filter(opt->opt.getText().equalsIgnoreCase(BrandName)).findFirst().orElse(null);
	    brand.click();
	    pageTitle.sendKeys(PageTitle);
	    planTitle.sendKeys(PlanTitle);
	    locationListTitle.sendKeys(LocationListTitle);
	    descriptonText.sendKeys(DescriptionText);
	    noteText.sendKeys(Note);
	    contactEmail.sendKeys(ContactEmail);
	    
	}
	

}
