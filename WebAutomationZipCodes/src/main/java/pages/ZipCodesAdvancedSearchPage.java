package pages;

import common.BasePage;

import static common.Driver.sendKeys;

public class ZipCodesAdvancedSearchPage extends BasePage<ZipCodesAdvancedSearchPageElements,
        ZipCodesAdvancedSearchPageAssertions> {
    @Override
    protected String getUrl() {
        return "https://www.zip-codes.com/search.asp?selectTab=3";
    }

    public void searchTown(String searchString) {
        sendKeys(elements().getTownCityInputLocator(), searchString);
    }
}