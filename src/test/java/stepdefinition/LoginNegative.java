package stepdefinition;

import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.LoginPage;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class LoginNegative {

    InitialClass initialClass;
    LoginPage loginPage;
    AppiumDriver<WebElement> driver = null;

    @When("L2 - user open sevenmind app")
    public void lUserOpenSevenmindApp() throws MalformedURLException {
        initialClass = new InitialClass();
        driver = InitialClass.androidLaunchApp();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }

    @And("L2 - user taps on continue button")
    public void lUserTapsOnContinueButton() {
        loginPage = new LoginPage(driver);
        loginPage.tapContinueButton(driver);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }

    @And("L2 - user taps on log in button")
    public void lUserTapsOnLogInButton() {
        loginPage.tapLoginButton(driver);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @And("L2 - user taps email button")
    public void lUserTapsEmailButton() {
        loginPage.tapEmailLoginButton(driver);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @And("L2 - user enters valid email")
    public void lUserEntersValidEmail() {
        loginPage.enterEmail(driver, "borshiq111@gmail.com");
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }

    @And("L2 - user enters invalid password")
    public void lUserEntersInvalidPassword() throws InterruptedException {
        loginPage.enterPassword(driver, "InvalidPassword");
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        Thread.sleep(15000);
    }

    @Then("L2 - user should see the screen with meditation programs")
    public void lUserShouldSeeTheScreenWithMeditationPrograms() {
        String errorPhrase = "Sorry, that";
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        String actualPhrase = driver.findElement(By.id("de.sevenmind.android:id/cellChatPhraseTextView")).getText();
        System.out.println(actualPhrase);
        Assert.assertTrue(actualPhrase.contains(errorPhrase));
        initialClass.closeApp();
    }
}
