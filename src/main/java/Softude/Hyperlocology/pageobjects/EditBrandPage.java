package Softude.Hyperlocology.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
	
	public void editBasicInformation(String BrandName) {
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
	}
	

}
