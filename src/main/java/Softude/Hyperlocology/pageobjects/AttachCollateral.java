package Softude.Hyperlocology.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import Softude.Hyperlocology.abstractComponents.AbstractComponents;
import dev.failsafe.internal.util.Assert;

public class AttachCollateral extends AbstractComponents {

	WebDriver driver;
	public AttachCollateral(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	@FindBy(css="#datatable tr td a")
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
	@FindBy(name="submit")
	WebElement updateBtn;
	@FindBy(css=".toast-message")
	WebElement successMsg;
	@FindBy(css="a[href*='participant-mass-upload']")
	WebElement locationBtn;
	
	public void selectBrand(String BrandName) throws InterruptedException {
		Thread.sleep(2000);
		WebElement brandName=brands.stream().filter(b->b.getText().equalsIgnoreCase(BrandName)).findFirst().orElse(null);
		brandName.click();
	}
	
	public void attachCollateral(String fileName,String filePath) {
		waitingForElementToBeClickable(attachCollateral);
		attachCollateral.click();
		waitingForElementToBeClickable(fileNameInput);
		fileNameInput.sendKeys(fileName);
		attachFile.sendKeys(filePath);
		addBtn.click();
        System.out.println(successMsg.getText());
	}
	
	
   

}
