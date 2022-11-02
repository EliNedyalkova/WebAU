package pages;

import common.BasePage;
import common.Driver;
import org.openqa.selenium.WebElement;

import static common.Driver.*;

public class GoogleMapsTownPage extends BasePage<GoogleMapsTownPageElements, GoogleMapsTownPageAssertions> {
    @Override
    protected String getUrl() {
        return "https://maps.google.com/?q=%s,%s";
    }

    public void isVisibleSignButton() {
        isVisible(elements().getGoogleMapsSignButtonLocator());
    }

    public void navigateToTownPage(String townUrl) {
        Driver.getBrowser().navigate().to(townUrl);
    }

    public void clickAcceptAll() {
        click(elements().getGoogleAcceptAllButtonLocator());
    }

    public WebElement getSearchBox() {
        return findElementWithWait(elements().getGoogleMapsSearchBoxLocator());
    }
}