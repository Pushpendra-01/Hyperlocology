package Softude.Hyperlocology.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Softude.Hyperlocology.abstractComponents.AbstractComponents;

public class ParentCompanies extends AbstractComponents {
   
	WebDriver driver;
	public ParentCompanies(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	@FindBy(id="companyLink")
	WebElement parentCompanies;
	@FindBy(css="a[href='company/add']")
	WebElement addBtn;
	
	public void addParentCompany() {
		parentCompanies.click();
		waitingForElementToBeVisible(addBtn);
		addBtn.click();
	}
}
