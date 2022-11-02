package common;

import org.openqa.selenium.WebDriver;

public abstract class BaseElements {
    protected WebDriver browser;

    public BaseElements() {
        browser = Driver.getBrowser();
    }
}