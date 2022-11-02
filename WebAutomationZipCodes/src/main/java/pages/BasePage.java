package pages;

import org.openqa.selenium.WebDriver;

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
}
