import common.Driver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.lang.String.format;

public class TestsZIPCodes {
    public static final String STRING_TO_SEARCH_FOR = "Eli";
    public static final String OUTPUT_FILE_LOCATION_AND_NAME = ".\\target\\%s- %s- %s.jpg";

    @BeforeMethod
    public void testInit() {
        Driver.startBrowser();
    }

    @AfterMethod
    public void testCleanup() {
        Driver.stopBrowser();
    }

    @Test
    public void test_ZipCodes() {

        ZipCodesMainPage zipCodesMainPage = new ZipCodesMainPage();
        zipCodesMainPage.navigate();
        zipCodesMainPage.assertions().assertNavigatedToUrl();
        zipCodesMainPage.navigateToSearch();

        ZipCodesSearchPage zipCodesSearchPage = new ZipCodesSearchPage();
        zipCodesSearchPage.assertions().assertNavigatedToUrl();
        zipCodesSearchPage.confirmConsentToSearch();
        zipCodesSearchPage.clickAdvancedSearch();

        ZipCodesAdvancedSearchPage zipCodesAdvancedSearchPage = new ZipCodesAdvancedSearchPage();
        zipCodesAdvancedSearchPage.assertions().assertNavigatedToUrl();
        zipCodesAdvancedSearchPage.searchTown(STRING_TO_SEARCH_FOR);

        ZipCodesResultPage zipCodesResultPage = new ZipCodesResultPage();
        zipCodesResultPage.isTableVisible();
        zipCodesResultPage.assertions().assertNavigatedToUrl(STRING_TO_SEARCH_FOR);

        String[][] listSelectedZipCodes;
        String currentZIPCode;
        listSelectedZipCodes = new String[10][6];

        for (int i = 0; i < 10; i++) {
            currentZIPCode = zipCodesResultPage.getTextClick(i + 2);
            ZipCodesTownPage zipCodesTownPage = new ZipCodesTownPage();
            zipCodesTownPage.assertions().assertNavigatedToUrl(currentZIPCode);

            listSelectedZipCodes[i][0] = zipCodesTownPage.getCity();
            listSelectedZipCodes[i][1] = zipCodesTownPage.getState();
            listSelectedZipCodes[i][2] = zipCodesTownPage.getZipCode();
            listSelectedZipCodes[i][3] = zipCodesTownPage.getLongitude();
            listSelectedZipCodes[i][4] = zipCodesTownPage.getLatitude();
            listSelectedZipCodes[i][5] = format("https://maps.google.com/?q=%s,%s", listSelectedZipCodes[i][4],
                    listSelectedZipCodes[i][3]);
            zipCodesTownPage.navigateBack();
            Assert.assertTrue(listSelectedZipCodes[i][2].equals(currentZIPCode),
                    "Saved ZIP code is not correct");
        }

        GoogleMapsTownPage googleMapsTownPage = new GoogleMapsTownPage();
        for (int i = 0; i < 10; i++) {
            googleMapsTownPage.navigateToTownPage(listSelectedZipCodes[i][5]);
            if (i == 0) {
                googleMapsTownPage.clickAcceptAll();
            }
            googleMapsTownPage.isVisibleSignButton();

            Assert.assertTrue(googleMapsTownPage.getSearchBox().getAttribute("value").equals(format("%s,%s",
                    listSelectedZipCodes[i][4], listSelectedZipCodes[i][3])),
                    "Located page does not correspond to the input Latitude and Longitude ");

            TakesScreenshot scrShot = ((TakesScreenshot) Driver.getBrowser());
            File srcFile = scrShot.getScreenshotAs(OutputType.FILE);

            String pathFile = format(OUTPUT_FILE_LOCATION_AND_NAME, listSelectedZipCodes[i][0],
                    listSelectedZipCodes[i][1], listSelectedZipCodes[i][2]);
            try {
                FileUtils.copyFile(srcFile, new File(pathFile));
            } catch (IOException exception) {
                System.out.println("Error with File");
            }

            Path path = Paths.get(pathFile);
            Assert.assertTrue(Files.exists(path));
        }
    }
}