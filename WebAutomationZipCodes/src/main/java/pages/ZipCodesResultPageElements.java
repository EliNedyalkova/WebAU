package pages;

import common.BaseElements;

import static java.lang.String.format;

public class ZipCodesResultPageElements extends BaseElements {
    public String getTableResultLocator() {
        return "//table[@class='statTable']";
    }

    public String getZipCodeTownButton(int rowIndex) {
        return format("//table[@class='statTable']/tbody/tr[%d]/td[1]/a", rowIndex);
    }
}


