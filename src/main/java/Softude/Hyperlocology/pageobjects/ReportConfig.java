package Softude.Hyperlocology.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Softude.Hyperlocology.abstractComponents.AbstractComponents;

public class ReportConfig extends AbstractComponents{
    WebDriver driver;
	public ReportConfig(WebDriver driver) {
		super(driver);
		this.driver=driver;
	 PageFactory.initElements(driver,this);
	}
	
	@FindBy(css="a[href*='/brand/49/report-config/campaign/create']")
	WebElement createNewTemplate;
	@FindBy(id="name")
	WebElement templateName;
	

}
