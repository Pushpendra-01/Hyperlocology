package Softude.Hyperlocology.abstractComponents;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
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
	public void waitingForInvisibilityofOverlappingElement() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("overlay")));
	}
	public void waitingForVisibilityOfAllTheElement(List<WebElement>element) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfAllElements(element));
	}
	public void selectElementByVisibleText(WebElement webElement, String VisibleText) {
		Select select=new Select(webElement);
		select.selectByVisibleText(VisibleText);
	}
}
