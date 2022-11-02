package pages;

import common.BaseElements;

public class GoogleMapsTownPageElements extends BaseElements {
    public String getGoogleAcceptAllButtonLocator() {
        return "//button[@aria-label='Приемане на всички']";
    }

    public String getGoogleMapsSignButtonLocator() {
        return "//a[text()='Вход']";
    }

    public String getGoogleMapsSearchBoxLocator() {
        return "//*[@id='searchboxinput']";
    }
}