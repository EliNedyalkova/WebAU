package pages;

import common.BaseElements;

public class ZipCodesSearchPageElements extends BaseElements {
    public String getConsentButton() {
        return "//p[text()='Consent']";
    }

    public String getAdvancedSearchButton() {
        return "//a[text()='Advanced Search']";
    }
}

