package Softude.Hyperlocology.pageobjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Softude.Hyperlocology.abstractComponents.AbstractComponents;

public class PageSetup extends AbstractComponents {

	WebDriver driver;
	public PageSetup(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(name="landing_page_description")
	WebElement description;
	@FindBy(css="a[href*='howItWorks']")
	WebElement howItworks;
	@FindBy(name="how_it_work_setup")
	WebElement theSetup;
	@FindBy(name="how_it_work_step1")
	WebElement ContributeYourLocalExpertise;
	@FindBy(name="how_it_work_step2")
	WebElement compaignStart;
	@FindBy(name="how_it_work_step3")
	WebElement insights;
	@FindBy(name="help_video_name")
	WebElement vedioName;
	@FindBy(name="video_urls")
	WebElement vedioUrl;
	@FindBy(css="button[type='submit']")
	WebElement saveBtn;
	@FindBy(css="a[href*='report-config']")
	WebElement reportConfigPage;
	
	public void loadingPageDescription(String Description) {
		waitingForElementToBeVisible(description);
		description.sendKeys(Description);
	}
	public void howItWorks(String TheSetup, String YourLocalExpertise, String CompaignStart, String Insights, String VedioName, String VedioUrl) throws InterruptedException {
		loadingPageDescription(VedioUrl);
		waitingForElementToBeClickable(howItworks);
		howItworks.click();
		waitingForElementToBeVisible(theSetup);
		theSetup.sendKeys(TheSetup);
		ContributeYourLocalExpertise.sendKeys(YourLocalExpertise);
		compaignStart.sendKeys(CompaignStart);
		insights.sendKeys(Insights);
		vedioName.sendKeys(VedioName);
		vedioUrl.sendKeys(VedioUrl);
//		waitingForElementToBeClickable(saveBtn);
//		saveBtn.click();
	}
	public ReportConfig goToReportConfigPage() {
		waitingForElementToBeClickable(reportConfigPage);
		ReportConfig reportConfig=new ReportConfig(driver);
		return reportConfig;
	}
	
 
	


}
