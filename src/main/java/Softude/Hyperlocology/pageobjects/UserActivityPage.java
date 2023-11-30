package Softude.Hyperlocology.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Softude.Hyperlocology.abstractComponents.AbstractComponents;

public class UserActivityPage extends AbstractComponents{

	WebDriver driver;
	public UserActivityPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(css="button[type='button']")
	WebElement brandsDropdown;
	@FindBy(css=".bs-searchbox input[type='search']")
	WebElement brandsSearchBox;
	@FindBy(css="ul[role='presentation'] li")
	List<WebElement> brandsOpt;
	@FindBy(css="#datatable tr td:nth-of-type(2)")
	List<WebElement> userNames;
	@FindBy(css="#datatable tr td:nth-of-type(3)")
	List<WebElement> userEmails;
	
	public void getTheUserNames(String BrandName) {
		waitingForElementToBeVisible(brandsDropdown);
		brandsDropdown.click();
		brandsSearchBox.sendKeys(BrandName);
		WebElement brand=brandsOpt.stream().filter(opt->opt.getText().equalsIgnoreCase(BrandName)).findFirst().orElse(null);
		brand.click();
		waitingForVisibilityOfAllTheElement(userNames);
		for(WebElement user:userNames) {
			System.out.println(user.getText());
		}
		
	}
	public void getTheUserEmail(String BrandName) {
		waitingForElementToBeVisible(brandsDropdown);
		brandsDropdown.click();
		brandsSearchBox.sendKeys(BrandName);
		WebElement brand=brandsOpt.stream().filter(opt->opt.getText().equalsIgnoreCase(BrandName)).findFirst().orElse(null);
		brand.click();
		waitingForVisibilityOfAllTheElement(userEmails);
		for(WebElement email:userEmails) {
			System.out.println(email.getText());
		}
		
		
	}

}
