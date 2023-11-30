package Softude.Hyperlocology.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Softude.Hyperlocology.abstractComponents.AbstractComponents;

public class LocationsPage extends AbstractComponents{

	WebDriver driver;
	public LocationsPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(css="input[type='search']")
	WebElement search;
	@FindBy(css="#datatable tr td:nth-of-type(3)")
	List<WebElement> brandId;
	@FindBy(css="#datatable tr td:nth-of-type(5)")
	List<WebElement>cityName;
	@FindBy(css="a[href*='add']")
	WebElement addBtn;
	@FindBy(css="input[name='location_name']")
	WebElement locationName;
	@FindBy(xpath="(//input[@name='location_name'])[2]")
	WebElement streetAddress;
	@FindBy(name="city")
	WebElement cityNameInput;
	@FindBy(name="state")
	WebElement stateName;
	@FindBy(name="zip_code")
	WebElement zipCode;
	@FindBy(name="country")
	WebElement countryName;
	@FindBy(name="landing_page_url")
	WebElement landingPageUrl;
	@FindBy(name="radius")
	WebElement radius;
	@FindBy(xpath="(//span[@class='mr-2'])[1]")
	WebElement hasBrandDefinedEmail;
	@FindBy(id="brandEmail")
	WebElement emailId;
	@FindBy(xpath="(//span[@class='mr-2'])[2]")
	WebElement hasBrandDefinedUniqueId;
	@FindBy(id="definedUniqueId")
	WebElement definedId;
	@FindBy(name="submit")
	WebElement submitBtn;
	
	
	
	public void getBrandId(String location) {
		waitingForElementToBeVisible(search);
		search.sendKeys(location);
		waitingForVisibilityOfAllTheElement(brandId);
		for(WebElement id:brandId) {
			System.out.println(id.getText());
		}
	}
	public void getCityName(String location)  {
		waitingForElementToBeVisible(search);
		search.sendKeys(location);
		waitingForVisibilityOfAllTheElement(cityName);
		for(WebElement city:cityName) {
			System.out.println(city.getText());
		}
	}
	public void addNewLocation(String LocationName,String StreetAddress,String CityName,String StateName,String ZipCode,String CountryName,
			String LandingPageUrl,String Radius,String EmailId,String DefinedUniqueId) {
		waitingForElementToBeVisible(addBtn);
		addBtn.click();
		waitingForElementToBeVisible(locationName);
		locationName.sendKeys(LocationName);
		streetAddress.sendKeys(StreetAddress);
		cityNameInput.sendKeys(CityName);
		stateName.sendKeys(StateName);
		zipCode.sendKeys(ZipCode);
		countryName.sendKeys(CountryName);
		landingPageUrl.sendKeys(LandingPageUrl);
		radius.sendKeys(Radius);
		hasBrandDefinedEmail.click();
		waitingForElementToBeClickable(emailId);
		emailId.sendKeys(EmailId);
		hasBrandDefinedUniqueId.click();
		waitingForElementToBeClickable(definedId);
		definedId.sendKeys(DefinedUniqueId);
//		submitBtn.click();
	}

}
