package pages;

import common.BasePage;

import static common.Driver.getTextAndClick;
import static common.Driver.isVisible;
import static java.lang.String.format;

public class ZipCodesResultPage extends BasePage<ZipCodesResultPageElements, ZipCodesResultPageAssertions> {
    @Override
    protected String getUrl() {
        return format("https://www.zip-codes.com/search.asp?selectTab=3&fld-city=&fld-city=%s&fld-state=&fld-county=" +
                "&fld-areacode=&Submit=Find+ZIP+Codes");
    }

    public void isTableVisible() {
        isVisible(elements().getTableResultLocator());
    }

    public String getTextClick(int rowIndex) {
        return getTextAndClick(elements().getZipCodeTownButton(rowIndex));
    }
}