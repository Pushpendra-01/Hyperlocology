package Softude.Hyperlocology.pageobjects;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Softude.Hyperlocology.abstractComponents.AbstractComponents;

public class Brands extends AbstractComponents{

	WebDriver driver;
	public Brands(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	
	@FindBy(css="a[href$='brand/basic-information']")
	WebElement addBtn;
	@FindBy(css="input[name='brand_name']")
	WebElement brandName;
	@FindBy(name="first_name")
	WebElement firstName;
	@FindBy(name="last_name")
	WebElement lastName;
	@FindBy(name="email")
	WebElement email;
	@FindBy(name="mobile_no")
	WebElement mobileNo;
	@FindBy(name="start_date")
	WebElement startDate;
	@FindBy(css="button[data-id='period']")
	WebElement subscriptionMonths;
	@FindBy(id="endDate")
	WebElement endDate;
	@FindBy(css=".ui-datepicker-month")
	WebElement month;
	@FindBy(css=".ui-datepicker-year")
	WebElement year;
	@FindBy(css="a[data-handler='next']")
	WebElement nextBtn;
	@FindBy(css=".ui-datepicker-calendar td")
	List<WebElement> dateOpt;
	@FindBy(css="button[data-id='period']")
	WebElement subscriptionMonth;
	@FindBy(css="#bs-select-2 li")
	List<WebElement> options;
	@FindBy(css="input[type='search']")
	WebElement searchBox;
	@FindBy(css="iframe[class='cke_wysiwyg_frame cke_reset']")
    WebElement frame1;
	@FindBy(css="html[dir='ltr'] body")
	WebElement textField;
	@FindBy(id="GUIDDE-JS-EXT-REC")
	WebElement frame2;
	@FindBy(css="label[for='is_all_specific_region_specific'] span")
	WebElement specificRegion;
	@FindBy(css="button[data-id='regionDD']")
	WebElement regionDropdown;
	@FindBy(css="#bs-select-1 li")
	List<WebElement> regions;
	@FindBy(css=".form-group.dropdownTest.mb-0 label span")
	WebElement hasparentCompany;
	@FindBy(css="button[data-id='parentCompany']")
	WebElement parentCompanyDropdown;
	@FindBy(css="#bs-select-3 li")
	List<WebElement> parentCompanies;
	@FindBy(xpath="(//label[@class='switch'])[1]")
	WebElement paymentBtn;
	@FindBy(xpath="(//label[@class='switch'])[2]")
	WebElement emailNotificationBtn;
    @FindBy(css="div[class='normal-slider round']")
    WebElement statusBtn;
    @FindBy(xpath="(//label[@class='switch'])[3]")
    WebElement autoRenewBtn;
    @FindBy(name="brand_logo")
    WebElement brandlogoBtn;  
    @FindBy(css=".swal2-confirm.swal2-styled")
    WebElement confirmBtn;   
    @FindBy(xpath="(//input[@placeholder='Please select date'])[3]")
    WebElement lastUpdate;
    @FindBy(css="button[value='Save & Next']")
    WebElement saveAndNextBtn;        
	public void fillBrandsDetails(String BrandName,String FirstName,String LastName,String Email,String MobileNo) {
		addBtn.click();
		waitingForElementToBeVisible(brandName);
		brandName.sendKeys(BrandName);
		firstName.sendKeys(FirstName);
		lastName.sendKeys(LastName);
		email.sendKeys(Email);
		mobileNo.sendKeys(MobileNo);
	}
	public void selectStartDate(String Month,String Year,String Date) {
		startDate.click();
		waitingForElementToBeVisible(month);
		
		while(true) {
			String selectedMonth=month.getText();
//	        System.out.println(selectedMonth);
			if(selectedMonth.equals(Month)) {
				break;
			}
			else {
				nextBtn.click();
			}
		}
        while(true) {
        	String selectedYear=year.getText();
        	if(selectedYear.equals(Year)) {
        		break;
        	}
        	else {
        		nextBtn.click();
        	}
        }
        WebElement optDate = dateOpt.stream()
         	    .filter(d -> d.getText().equalsIgnoreCase(Date))
         	    .findFirst()
         	    .orElseThrow(() -> new NoSuchElementException("Date option not found"));
         	optDate.click();
	}
     public void selectSubscriptionMonth(String SubscriptionMonths) throws InterruptedException {
    	 subscriptionMonth.click();
         searchBox.sendKeys(SubscriptionMonths);
         WebElement selectOption=options.stream().filter(opt->opt.getText().equalsIgnoreCase(SubscriptionMonths)).findFirst().orElse(null);
         selectOption.click();
         JavascriptExecutor js=(JavascriptExecutor)driver;
         js.executeScript("window.scrollBy(0,500)");

     }
     public void fillSubscriptionDeatils(String subscriptionDetails) {
    	 driver.switchTo().frame(frame1);
    	 textField.sendKeys(subscriptionDetails);
     }
     public void selectSpecificRegion(String regionName) throws InterruptedException {
    	 driver.switchTo().defaultContent();
    	 Thread.sleep(2000);
    	 specificRegion.click();
    	 regionDropdown.sendKeys(regionName);
    	 WebElement region=regions.stream().filter(opt->opt.getText().equalsIgnoreCase(regionName)).findFirst()
    			 .orElseThrow(()->new NoSuchElementException("This region is not available"));
    	 region.click();
     }
     public void selectParentComapny(String parentCompanyName) {
    	 driver.switchTo().defaultContent();
    	 hasparentCompany.click();
    	 parentCompanyDropdown.sendKeys(parentCompanyName);
    	 WebElement parentCompany=parentCompanies.stream().filter(p->p.getText().equalsIgnoreCase(parentCompanyName))
    	 .findFirst()
    	 .orElseThrow(()->new NoSuchElementException("No Such Parent Company Present"));
    	 parentCompany.click();
    	 
     }
     public void disablePaymentThroughPortal() {
    	 paymentBtn.click();
     }
     public void sendEmailNotification() {
    	 emailNotificationBtn.click();
     }
     public void ChangeStatus() {
    	 statusBtn.click();
     }
     public void activeAutoRenew() {
    	 autoRenewBtn.click();
    	 waitingForElementToBeVisible(confirmBtn);

    	 confirmBtn.click();
     }
     public void uploadBrandLogo(String brandLogoPath) {
    	 brandlogoBtn.sendKeys(brandLogoPath);
    	 
     }
     public void selectDashboardLastUpdate(String Month,String Year, String Date) throws InterruptedException  {
    	 Thread.sleep(1000);
    	 JavascriptExecutor js=(JavascriptExecutor)driver;
    	 js.executeScript("window.scrollBy(0,600);");
    	 Thread.sleep(1000);
    	 lastUpdate.click();
    	 
    	}

}
