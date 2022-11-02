package pages;

import common.BaseAssertions;
import common.Driver;
import org.testng.Assert;

public class GoogleMapsTownPageAssertions extends BaseAssertions<GoogleMapsTownPageElements> {
    public void assertNavigatedToUrl() {
        String currentUrl = Driver.getBrowser().getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://www.zip-codes.com/search.asp?selectTab=3",
                "Current URL is not as expected.");
    }
}