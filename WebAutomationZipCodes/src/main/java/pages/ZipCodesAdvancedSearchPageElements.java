package pages;

import common.BaseElements;

public class ZipCodesAdvancedSearchPageElements extends BaseElements {
    public String getTownCityInputLocator() {
        return "//label[text()='Town/City:']/following::input[@name='fld-city']";
    }
}