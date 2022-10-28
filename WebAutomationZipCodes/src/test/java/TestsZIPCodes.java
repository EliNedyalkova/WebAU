import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePage;
import pages.SearchPage;
import pages.SearchResultsPage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.List;

import static data.Constants.*;
import static data.Utils.*;
import static java.lang.String.format;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestsZIPCodes {

    static WebDriver driver;
    static WebElement element;
    static String[][] listSelectedZipCodes;

    @BeforeClass
        public static void setup(){
            WebDriverManager.firefoxdriver().setup();

            driver = new FirefoxDriver();
            driver.manage().window().maximize();
    }
    @AfterClass
        public static void quit(){
        driver.quit();
    }

    @Test
    public void test_1_succefssfullyLoadedHomePage() {

        HomePage homePage=new HomePage(driver,BASE_URL);
        homePage.navigateToPage();
        homePage.assertNavigatedUrl();

    }

    @Test
    public void test_2_succefssfullyDisplayedListBySearchCriteria() {

        clickElement(driver, SEARCH_BUTTON_LOCATOR);
        SearchPage searchPage = new SearchPage(driver, SEARCH_URL);
        searchPage.assertNavigatedUrl();

        clickElement(driver, CONSENT_BUTTON_LOCATOR);

        clickElement(driver, ADVANCED_SEARCH_BUTTON_LOCATOR);
        searchPage = new SearchPage(driver, ADVANCE_SEARCH_URL);
        searchPage.assertNavigatedUrl();

        sendKeysElement(driver, TOWN_CITY_INPUT_LOCATOR, STRING_TO_SEARCH_FOR);

        element = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(TABLE_RESULT)));

        SearchResultsPage searchResultsPage = new SearchResultsPage(driver, format(RESULTS_PAGE_URL,STRING_TO_SEARCH_FOR));
        searchResultsPage.assertNavigatedUrl();

    }

    @Test
    public void test_3_successfullySavedDetailsForTenPositionsFromSearchList() {

        WebElement table;
        String currentZIPCode;
        listSelectedZipCodes = new String[10][6];
        for (int i = 0; i < 10; i++) {

            currentZIPCode = getTextAndClickElement(driver, format(ZIP_CODE_BUTTON_FOR_A_TOWN, i + 2));

            table = driver.findElement(By.xpath(TABLE_WITH_DETAILS_FOR_A_TOWN));

            List<WebElement> rowsList = table.findElements(By.tagName("tr"));

            String label;
            for (WebElement row : rowsList) {
                label = row.findElement(By.className("label")).getText();
                switch (label) {
                    case "City:":
                        listSelectedZipCodes[i][0] = row.findElement(By.className("info")).getText();
                        break;
                    case "State:":
                        listSelectedZipCodes[i][1] = row.findElement(By.className("info")).getText();
                        break;
                    case "Zip Code:":
                        listSelectedZipCodes[i][2] = row.findElement(By.className("info")).getText();
                        break;
                    case "Longitude:":
                        listSelectedZipCodes[i][3] = row.findElement(By.className("info")).getText();
                        break;
                    case "Latitude:":
                        listSelectedZipCodes[i][4] = row.findElement(By.className("info")).getText();
                        break;
                    default:
                        break;
                }
            }
            listSelectedZipCodes[i][5] = format(GOOGLE_MAPS_URL, listSelectedZipCodes[i][4],
                                         listSelectedZipCodes[i][3]);
            driver.navigate().back();
            Assert.assertTrue("Saved ZIP code is not correct", listSelectedZipCodes[i][2].
                              equals(currentZIPCode));
        }
    }

    @Test
    public void test_4_successfullyCreatedFilesWithGoogleMapsScreenshotsForSavedTowns() {

        for (int i=0; i<10; i++) {
            driver.navigate().to(listSelectedZipCodes[i][5]);
            if(i==0) {
                clickElement(driver,GOOGLE_ACCEPT_ALL_BUTTON);
            }
            WebElement signButton = new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.elementToBeClickable(By.xpath(GOOGLE_MAPS_SIGN_BUTTON)));

            element= driver.findElement(By.xpath(GOOGLE_MAPS_SEARCH_BOX));

            Assert.assertTrue("Located page does not correspond to the input Latitude and Longitude ",
                    element.getAttribute("value").equals(format("%s,%s",
                                        listSelectedZipCodes[i][4],listSelectedZipCodes[i][3])));

            TakesScreenshot scrShot = ((TakesScreenshot) driver);
            File srcFile = scrShot.getScreenshotAs(OutputType.FILE);

            String pathFile=format(OUTPUT_FILE_LOCATION_AND_NAME,listSelectedZipCodes[i][0],
                                   listSelectedZipCodes[i][1],listSelectedZipCodes[i][2]);
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


