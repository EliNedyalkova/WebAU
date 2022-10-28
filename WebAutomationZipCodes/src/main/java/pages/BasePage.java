package pages;


import org.junit.*;
import org.openqa.selenium.*;

public class BasePage {

    protected WebDriver driver;
    protected String url;

    public BasePage(WebDriver driver, String url) {
        this.driver = driver;
        this.url = url;
    }

     public String getUrl() {
            return url;
     }

     public void navigateToPage() {
        this.driver.get(url);
    }

    public void assertNavigatedUrl() {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals("Current URL is not as expected.", url, currentUrl);

    }
}
