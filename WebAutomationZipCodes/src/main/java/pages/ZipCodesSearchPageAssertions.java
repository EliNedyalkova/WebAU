package pages;

import common.BaseAssertions;
import common.Driver;
import org.testng.Assert;

public class ZipCodesSearchPageAssertions extends BaseAssertions<ZipCodesSearchPageElements> {
    public void assertNavigatedToUrl() {
        String currentUrl = Driver.getBrowser().getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://www.zip-codes.com/search.asp",
                "Current URL is not as expected.");
    }
}
