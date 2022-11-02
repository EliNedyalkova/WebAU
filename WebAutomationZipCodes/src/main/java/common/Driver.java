package common;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Driver {
    private static WebDriverWait browserWait;
    private static WebDriver browser;
    private Duration defaultDuration;
    private static int defaultElementTimeout =10;
    private static int defaultBrowserTimeout =30;

    public static WebDriver getBrowser() {
        if (browser == null) {
            throw new NullPointerException("The WebDriver browser instance was not initialized. " +
                    "You should first call the start() method.");
        }
        return browser;
    }

    public static void setBrowser(WebDriver browser) {
        Driver.browser = browser;
    }

    public static WebDriverWait getBrowserWait() {
        if (browserWait == null || browser == null) {
            throw new NullPointerException("The WebDriver browser wait instance was not initialized. " +
                    "You should first call the start() method.");
        }
        return browserWait;
    }

    public static void setBrowserWait(WebDriverWait browserWait) {
        Driver.browserWait = browserWait;
    }

    public static void startBrowser(Browser browserType, int defaultTimeout) {

        switch (browserType.browserName().toUpperCase()) {
            case "FIREFOX":
                WebDriverManager.firefoxdriver().setup();
                setBrowser(new FirefoxDriver());
                break;
            case "CHROME":
                WebDriverManager.chromedriver().setup();
                setBrowser(new ChromeDriver());
                break;
            case "EDGE":
                WebDriverManager.edgedriver().setup();
                setBrowser(new EdgeDriver());
                break;
            default:
                break;
        }

        setBrowserWait(new WebDriverWait(getBrowser(), Duration.ofSeconds(defaultTimeout)));
        browser.manage().window().maximize();
    }

    public static void startBrowser(Browser browserType) {
        startBrowser(browserType, defaultBrowserTimeout);
    }

    public static void startBrowser() {
        startBrowser(Browser.FIREFOX);
    }

    public static void stopBrowser() {
        getBrowser().quit();
        setBrowser(null);
        setBrowserWait(null);
    }

    public static void click(String locator) {
        WebElement element = new WebDriverWait(browser, Duration.ofSeconds(defaultElementTimeout))
                .until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
        element.click();
    }

    public static String getTextAndClick(String locator) {
        WebElement element = new WebDriverWait(browser, Duration.ofSeconds(defaultElementTimeout))
                .until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
        String text = element.getText();
        element.click();
        return text;
    }

    public static void sendKeys(String locator, String input) {
        WebElement element = new WebDriverWait(browser, Duration.ofSeconds(defaultElementTimeout))
                .until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
        element.sendKeys(input, Keys.ENTER);
    }

    public static void isVisible(String locator) {
        WebElement element = new WebDriverWait(browser, Duration.ofSeconds(defaultElementTimeout))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }

    public static WebElement findElementWithWait(String locator) {
        WebElement element = new WebDriverWait(browser, Duration.ofSeconds(defaultElementTimeout))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
        return element;
    }

    public static void navigateBack() {
        browser.navigate().back();
    }
}
