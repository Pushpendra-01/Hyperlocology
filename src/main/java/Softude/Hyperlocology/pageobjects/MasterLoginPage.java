package Softude.Hyperlocology.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Softude.Hyperlocology.abstractComponents.AbstractComponents;

public class MasterLoginPage extends AbstractComponents{

	WebDriver driver;
	public MasterLoginPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(css=".slider.round")
	WebElement masterPasswordSlider;
	@FindBy(name="master_password")
	WebElement passwordInput;
	@FindBy(css=".cbx")
	WebElement checkBox;
	@FindBy(id="cancleBtn")
	WebElement cancelBtn;
	@FindBy(id="SavePassword")
	WebElement saveBtn;
	
	public void addMasterPassword(String Password) {
		waitingForElementToBeVisible(masterPasswordSlider);
		masterPasswordSlider.click();
		waitingForElementToBeVisible(passwordInput);
		passwordInput.sendKeys(Password);
		cancelBtn.click();
	}

}
