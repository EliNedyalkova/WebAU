package pages;

import common.BaseAssertions;
import common.Driver;
import org.testng.Assert;

import static java.lang.String.format;

public class ZipCodesTownPageAssertions extends BaseAssertions<ZipCodesTownPageElements> {
    public void assertNavigatedToUrl(String zipCode) {
        String currentUrl = Driver.getBrowser().getCurrentUrl();
        Assert.assertEquals(currentUrl, format("https://www.zip-codes.com/zip-code/%s/zip-code-%s.asp", zipCode, zipCode),
                "Current URL is not as expected.");
    }
}

