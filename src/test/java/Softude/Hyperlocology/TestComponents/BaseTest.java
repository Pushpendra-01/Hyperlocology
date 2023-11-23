package Softude.Hyperlocology.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import Softude.Hyperlocology.pageobjects.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	public LandingPage loginPage;
	public WebDriver driver;

	public WebDriver initializeBrowser() throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
				+ "\\src\\main\\java\\Softude\\Hyperlocology\\resources\\GlobalData.properties");
		prop.load(fis);
//	    String browserName=prop.getProperty("browser");
		String browserName = System.getProperty("browser") != null ? System.getProperty("browser")
				: prop.getProperty("browser");

		if (browserName.contains("chrome")) {
			ChromeOptions options=new ChromeOptions();
			WebDriverManager.chromedriver().setup();
			if(browserName.contains("headless")) {
				options.addArguments("headless");
			}
			driver = new ChromeDriver(options);
			driver.manage().window().setSize(new Dimension(1440,900));//full screen
			
		} else if (browserName.equalsIgnoreCase("firefox")) {
			try {
				WebDriverManager.firefoxdriver().setup();
			} catch (Exception ex) {
				ex.printStackTrace();
			}

			driver = new FirefoxDriver();

		}
		driver.manage().window().maximize();
		return driver;
	}

	public static String takeScreenshot(String testCaseName,WebDriver driver) throws IOException {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File file=new File(System.getProperty("user.dir")+"//Reports//"+testCaseName+".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir")+"//Reports//"+testCaseName+".png";
		
	}
	public List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException {
//		read json to string
			String jsonContent=FileUtils.readFileToString(new File(filePath),
					StandardCharsets.UTF_8);
//			String to HasMap jackson --> databind
			ObjectMapper mapper=new ObjectMapper();
			List<HashMap<String, String>>data=mapper.readValue(jsonContent,new TypeReference<List<HashMap<String, String>>>(){
			});
			return data;
			
		}
	@BeforeMethod(alwaysRun = true)
	public LandingPage lauchApplication() throws IOException {
		driver = initializeBrowser();
		loginPage = new LandingPage(driver);
		loginPage.goTO();
		return loginPage;
	}
	

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		driver.close();
	}

}
