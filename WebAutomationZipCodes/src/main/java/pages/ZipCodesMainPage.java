package pages;

import common.BasePage;

import static common.Driver.click;

public class ZipCodesMainPage extends BasePage<ZipCodesMainPageElements, ZipCodesMainPageAssertions> {
    @Override
    protected String getUrl() {
        return "https://www.zip-codes.com/";
    }

    public void navigateToSearch() {
        click(elements().getSearchButton());
    }
}