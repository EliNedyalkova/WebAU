package pages;

import common.BasePage;
import common.Driver;

import static common.Driver.findElementWithWait;

public class ZipCodesTownPage extends BasePage<ZipCodesTownPageElements, ZipCodesTownPageAssertions> {
    @Override
    protected String getUrl() {
        return "https://www.zip-codes.com/zip-code/%s/zip-code-%s.asp";
    }

    public String getCity() {
        return findElementWithWait(elements().getCityLocator()).getText();
    }

    public String getState() {
        return findElementWithWait(elements().getStateLocator()).getText();
    }

    public String getZipCode() {
        return findElementWithWait(elements().getZipCodeLocator()).getText();
    }

    public String getLongitude() {
        return findElementWithWait(elements().getLongitudeLocator()).getText();
    }

    public String getLatitude() {
        return findElementWithWait(elements().getLatitudeLocator()).getText();
    }

    public void navigateBack() {
        Driver.navigateBack();
    }
}