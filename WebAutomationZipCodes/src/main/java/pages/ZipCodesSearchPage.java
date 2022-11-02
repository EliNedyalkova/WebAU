package pages;

import common.BasePage;

import static common.Driver.click;

public class ZipCodesSearchPage extends BasePage<ZipCodesSearchPageElements, ZipCodesSearchPageAssertions> {
    @Override
    protected String getUrl() {
        return "https://www.zip-codes.com/search.asp";
    }

    public void confirmConsentToSearch() {
        click(elements().getConsentButton());
    }

    public void clickAdvancedSearch() {
        click(elements().getAdvancedSearchButton());
    }
}
