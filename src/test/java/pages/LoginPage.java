package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import java.util.List;

public class LoginPage {

    public static AppiumDriver<WebElement> driver=null;

    public LoginPage(AppiumDriver<WebElement> driver) {
        this.driver = driver;
    }

    public List<WebElement> enterText(AppiumDriver<WebElement> driver) {
        List<WebElement> textViews = driver.findElementsByClassName("android.widget.EditText");
        return textViews;
    }

    //Preparation for the best time when each element will have a separate id
    @AndroidFindBy(id = "")
    WebElement btn_continue;

    @AndroidFindBy(id = "")
    private WebElement btn_login;

    @AndroidFindBy(id = "")
    WebElement field_email_login;

    @AndroidFindBy(id = "")
    @CacheLookup
    WebElement field_password_login;

    @AndroidFindBy(id = "")
    @CacheLookup
    WebElement btn_login_email;

    public void tapContinueButton(AppiumDriver<WebElement> driver) {
        WebElement button = driver.findElement(By.id("de.sevenmind.android:id/actionButton"));
        button.click();
    }

    public void tapLoginButton(AppiumDriver<WebElement> driver) {
        WebElement button = driver.findElement(By.id("de.sevenmind.android:id/actionButton"));
        button.click();
    }

    public void tapEmailLoginButton(AppiumDriver<WebElement> driver) {
        WebElement button = driver.findElement(By.id("de.sevenmind.android:id/actionButton"));
        button.click();
    }

    public void enterEmail(AppiumDriver<WebElement> driver, String email) {
        List<WebElement> textViews = enterText(driver);
        textViews.get(0).sendKeys(email);
        driver.getKeyboard().sendKeys(Keys.ENTER);
    }

    public void enterPassword(AppiumDriver<WebElement> driver, String password) {
        List<WebElement> textViews = enterText(driver);
        textViews.get(0).sendKeys(password);
        driver.getKeyboard().sendKeys(Keys.ENTER);
    }
}

