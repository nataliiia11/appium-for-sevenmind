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
import java.util.List;
import java.util.concurrent.TimeUnit;

public class LoginPositive {

    private static final String CORRECT_EMAIL = "";
    private static final String CORRECT_PASSWORD = "";
    InitialClass initialClass;
    LoginPage loginPage;
    AppiumDriver<WebElement> driver = null;

    @When("L1 - user open sevenmind app")
    public void userOpenSevenmindApp() throws MalformedURLException {
        initialClass = new InitialClass();
        driver = InitialClass.androidLaunchApp();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @And("L1 - user taps on continue button")
    public void userTapsOnContinueButton() {
        loginPage = new LoginPage(driver);
        loginPage.tapContinueButton(driver);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @And("L1 - user taps on log in button")
    public void userTapsOnLogInButton() {
        loginPage.tapLoginButton(driver);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @And("L1 - user taps email button")
    public void userTapsEmailButton() {
        loginPage.tapEmailLoginButton(driver);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @And("L1 - user enters email")
    public void userEntersEmail() {
        loginPage = new LoginPage(driver);
        loginPage.enterEmail(driver, CORRECT_EMAIL);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @And("L1 - user enters password")
    public void userEntersPassword() throws InterruptedException {
        loginPage.enterPassword(driver, CORRECT_PASSWORD);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Thread.sleep(1000);
    }

    @Then("L1 - user should see the screen with meditation programs")
    public void userShouldSeeTheScreenWithMeditationPrograms() {
        List<WebElement> txts = driver.findElements(By.id("de.sevenmind.android:id/cellChatPhraseTextView"));
        String firstExpectedPhrase = "Welcome back, you're now logged in and can continue your journey ✨";
        String secondExpectedPhrase = "Wonderful";
        String thirdExpectedPhrase = "Would you like to learn more about the features of the app or start your first meditation now?";
        Assert.assertTrue(txts.get(0).getText().contains(firstExpectedPhrase) || firstExpectedPhrase.contains(txts.get(0).getText()));
        Assert.assertTrue(txts.get(1).getText().contains(secondExpectedPhrase) || secondExpectedPhrase.contains(txts.get(1).getText()));
        Assert.assertTrue(txts.get(2).getText().contains(thirdExpectedPhrase) || thirdExpectedPhrase.contains(txts.get(2).getText()));
        initialClass.closeApp();
    }
}
