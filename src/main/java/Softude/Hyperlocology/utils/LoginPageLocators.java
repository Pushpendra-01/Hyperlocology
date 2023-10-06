package Softude.Hyperlocology.utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageLocators {
    @FindBy(name="username")
    public static WebElement userName;
    @FindBy(id="password")
    public static WebElement userPassword;
    @FindBy(tagName="button")
    public static WebElement loginButton;
}
