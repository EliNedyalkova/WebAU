package pages;

import common.BaseAssertions;
import common.Driver;
import org.testng.Assert;

public class ZipCodesMainPageAssertions extends BaseAssertions<ZipCodesMainPageElements> {
    public void assertNavigatedToUrl() {
        String currentUrl = Driver.getBrowser().getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://www.zip-codes.com/",
                "Current URL is not as expected.");
    }
}