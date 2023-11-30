package Softude.Hyperlocology.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Softude.Hyperlocology.abstractComponents.AbstractComponents;

public class ParticipantsPage extends AbstractComponents {

	WebDriver driver;
	public ParticipantsPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(css="a[href*='advanceSearch']")
	WebElement advanceSearch;
	@FindBy(id="participantName")
	WebElement participantName;
	@FindBy(id="participantId")
	WebElement participantId;
	@FindBy(id="status")
	WebElement statusDropdown;
	@FindBy(id="searchFilter")
	WebElement searchFilterBtn;
	@FindBy(id="brandsDropdown")
	WebElement brands;
	@FindBy(css="#datatable tr td:nth-of-type(3)")
	List<WebElement> participantsName;
	public void advanceSearchValidation(String ParticipantsName,String ParticipantsId,String Status) {
		waitingForElementToBeVisible(advanceSearch);
		advanceSearch.click();
		waitingForElementToBeVisible(participantName);
		participantName.sendKeys(ParticipantsName);
		participantId.sendKeys(ParticipantsId);
		selectElementByVisibleText(statusDropdown,Status);
		searchFilterBtn.click();
		
	}
	public void getParticipantsNameOfTheBrand(String BrandsName) {
		waitingForElementToBeClickable(brands);
		selectElementByVisibleText(brands,BrandsName);
		waitingForVisibilityOfAllTheElement(participantsName);
		for(WebElement participant:participantsName) {
			System.out.println(participant.getText());
		}
		
		
	}
	
	

}
