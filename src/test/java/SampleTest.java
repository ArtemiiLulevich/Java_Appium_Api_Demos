
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.example.Listener;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;

public class SampleTest {

    private AndroidDriver driver;

    @BeforeEach
    public void setUp() throws IOException {
        UiAutomator2Options options = new UiAutomator2Options();

        options.setCapability("platformName", "Android");
        options.setCapability("appium:platformVersion", "10.0");
        options.setCapability("appium:deviceName", "Nokia 6.1");
        options.setCapability("appium:automationName", "UiAutomator2");
        options.setCapability("appium:udid", "192.168.0.185:5555");
//        options.setCapability("appium:udid", "PL2GAR9830101003");
        options.setCapability("appium:ensureWebviewsHavePages", true);
        options.setCapability("appium:nativeWebScreenshot", true);
        options.setCapability("appium:newCommandTimeout", 3600);
        options.setCapability("appium:connectHardwareKeyboard", true);

//        options.setCapability("appium:appPackage", "ua.aval.dbo.client.android");
////        options.setCapability("appium:appActivity", ".ui.MainActivity");
////        options.setCapability("appium:appWaitActivity", ".ui.LauncherActivity");
//        options.setCapability("appium:appActivity", ".ui.LauncherActivity");
//        options.setCapability("appium:appWaitActivity", ".ui.MainActivity");
//        options.setCapability("appium:autoGrantPermissions", true);

        URL remoteUrl = new URL("http://192.168.0.115:4723/wd/hub");

        driver = new AndroidDriver(remoteUrl, options);

//        Listener listener = new Listener();
//        driver = new EventFiringDecorator(listener).decorate(driver);

    }

    @Test
    public void sampleTest() throws InterruptedException {
//        WebElement el1 = driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Firefox\"]"));
//        el1.click();

//        driver.startActivity(new Activity("io.appium.android.apis", "io.appium.android.apis.ApiDemos"));

        try {
            driver.startActivity(new Activity("ua.aval.dbo.client.android", ".ui.LauncherActivity"));
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement el1 = driver.findElement(By.id("com.android.systemui:id/button2"));
        el1.click();
        WebElement el2 = driver.findElement(By.id("ua.aval.dbo.client.android:id/loginValue"));
        el2.sendKeys("ArtemiiLulewich");
        WebElement el3 = driver.findElement(By.id("ua.aval.dbo.client.android:id/passwordValue"));
        el3.sendKeys("XeoXSL65^^bK");
        WebElement el4 = driver.findElement(By.id("ua.aval.dbo.client.android:id/nextAction"));
        el4.click();

        Thread.sleep(10000);

        WebElement header = driver.findElement(By.id("ua.aval.dbo.client.android:id/title"));

        Assertions.assertEquals("Главная".toLowerCase(), header.getText().toLowerCase());

        driver.terminateApp("ua.aval.dbo.client.android");

    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
