package Softude.Hyperlocology.TestComponents;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


import Softude.Hyperlocology.pageobjects.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
    public LandingPage loginPage;
	public WebDriver driver;
	public WebDriver initializeBrowser() throws IOException {
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Softude\\Hyperlocology\\resources\\GlobalData.properties");
	    prop.load(fis);
//	    String browserName=prop.getProperty("browser");
	    String browserName=System.getProperty("browser")!=null ? System.getProperty("browser"):prop.getProperty("browser");
	
	    if(browserName.equalsIgnoreCase("chrome")) {
	    	WebDriverManager.chromedriver().setup();
	    	driver=new ChromeDriver();
	    }
	    else if(browserName.equalsIgnoreCase("firefox")) {
	    	try {
	    	WebDriverManager.firefoxdriver().setup();
	    	}
	    	catch(Exception ex){
	    	ex.printStackTrace();	
	    	}
	    	
	    	driver=new FirefoxDriver();
	    	
	    }
	    driver.manage().window().maximize();
	    return driver;
	}
	@BeforeMethod(alwaysRun=true)
	public LandingPage lauchApplication() throws IOException {
		driver=initializeBrowser();
        loginPage=new LandingPage(driver);
        loginPage.goTO();
        return loginPage;
	}
	@AfterMethod(alwaysRun=true)
	public void tearDown() {
		driver.close();
	}
	
}
