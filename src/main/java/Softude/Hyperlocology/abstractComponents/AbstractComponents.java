package Softude.Hyperlocology.abstractComponents;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponents {

	public WebDriver driver;

	public AbstractComponents(WebDriver driver) {
		this.driver=driver;
	}
	public void waitingForElementToBeVisible(WebElement webelement) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(webelement));
	}
	public void waitingForElementToBeInvisible(WebElement webelement) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOf(webelement));
	}
	public void waitingForElementToBeClickable(WebElement webelement) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(webelement));
	}
}
