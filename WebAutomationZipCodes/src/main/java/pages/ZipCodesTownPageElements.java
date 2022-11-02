package pages;

import common.BaseElements;

public class ZipCodesTownPageElements extends BaseElements {
    public String getCityLocator() {
        return "//td[@class='label']/span[text()='City:']/following::td[1]";
    }

    public String getStateLocator() {
        return "//td[@class='label']/span[text()='State:']/following::td[1]";
    }

    public String getZipCodeLocator() {
        return "//td[@class='label']/span[text()='Zip Code:']/following::td[1]";
    }

    public String getLongitudeLocator() {
        return "//td[@class='label']/span[text()='Longitude:']/following::td[1]";
    }

    public String getLatitudeLocator() {
        return "//td[@class='label']/span[text()='Latitude:']/following::td[1]";
    }
}

