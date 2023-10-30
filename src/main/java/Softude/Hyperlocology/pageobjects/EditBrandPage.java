package Softude.Hyperlocology.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Softude.Hyperlocology.abstractComponents.AbstractComponents;

public class EditBrandPage extends AbstractComponents {

	WebDriver driver;
	public EditBrandPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	@FindBy(css="#datatable td a")
	List<WebElement>brands;
	@FindBy(css=".nav-tabs li:nth-child(2)")
	WebElement attachCollateral;
	@FindBy(name="file_name")
	WebElement fileNameInput;
	@FindBy(id="input-file-now")
	WebElement attachFile;
	@FindBy(css=".btn-primary")
	WebElement addBtn;
	@FindBy(css="input[name='brand_name']")
	WebElement brandNameInput;
	@FindBy(name="first_name")
	WebElement firstNameInput;
	@FindBy(name="last_name")
	WebElement lastNameInput;
	@FindBy(name="email")
	WebElement emailInput;
	@FindBy(name="mobile_no")
	WebElement mobileInput;
	
	public void editBasicInformation(String BrandName) {
		WebElement brandName=brands.stream().filter(b->b.getText().equalsIgnoreCase(BrandName)).findFirst().orElse(null);
		brandName.click();
	}
		public void editBrnadName(String newBrandName) {
			waitingForElementToBeVisible(brandNameInput);
			brandNameInput.clear();
			brandNameInput.sendKeys(newBrandName);	
		}
		public void editFirstName(String newFirstName) {
			waitingForElementToBeVisible(firstNameInput);
			firstNameInput.clear();
			firstNameInput.sendKeys(newFirstName);
		}
		public void editLastName(String newLastName) {
			waitingForElementToBeVisible(lastNameInput);
			lastNameInput.clear();
			lastNameInput.sendKeys(newLastName);
		}
		public void editEmail(String newEmail) {
			waitingForElementToBeVisible(emailInput);
			emailInput.clear();
			emailInput.sendKeys(newEmail);
		}
	
	public void attachCollateral(String fileName,String filePath) {
		waitingForElementToBeClickable(attachCollateral);
		attachCollateral.click();
		waitingForElementToBeClickable(fileNameInput);
		fileNameInput.sendKeys(fileName);
		attachFile.sendKeys(filePath);
		addBtn.click();
	}
	

}
