package stepdefinition;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class InitialClass {
    public static AppiumDriver<WebElement> driver = null;
    public static DesiredCapabilities cap;

    public static AppiumDriver<WebElement> androidLaunchApp() throws MalformedURLException {
        cap = new DesiredCapabilities();
        cap.setCapability("platformName", "Android");
        cap.setCapability("deviceName", "pixel4");
        cap.setCapability("appPackage", "de.sevenmind.android");
        cap.setCapability("appActivity", "de.sevenmind.android.MainActivity");
        cap.setCapability("isHeadless", true);
        cap.setCapability("avdArgs", "-no-window");
        driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
        Assert.assertNotNull(driver);
        return driver;
    }

    public void closeApp() {
        driver.quit();
    }

    public InitialClass() {
    }
}
