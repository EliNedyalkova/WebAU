package pages;

import common.BaseAssertions;
import common.Driver;
import org.testng.Assert;

import static java.lang.String.format;

public class ZipCodesResultPageAssertions extends BaseAssertions<ZipCodesResultPageElements> {
    public void assertNavigatedToUrl(String searchString) {
        String currentUrl = Driver.getBrowser().getCurrentUrl();
        Assert.assertEquals(currentUrl,
                format("https://www.zip-codes.com/search.asp?selectTab=3&fld-city=&fld-city=%s&fld-state=&fld-county=&fld-areacode=&Submit=Find+ZIP+Codes",
                        searchString),
                "Current URL is not as expected.");
    }
}

