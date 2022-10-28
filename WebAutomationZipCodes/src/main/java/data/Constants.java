package data;

public class Constants {

    public static final String BASE_URL="https://www.zip-codes.com/";
    public static final String SEARCH_URL="https://www.zip-codes.com/search.asp";
    public static final String ADVANCE_SEARCH_URL="https://www.zip-codes.com/search.asp?selectTab=3";
    public static final String RESULTS_PAGE_URL="https://www.zip-codes.com/search.asp?selectTab=3&fld-city=&fld-city=%s&fld-state=&fld-county=&fld-areacode=&Submit=Find+ZIP+Codes";
    public static final String SEARCH_BUTTON_LOCATOR="//a[@title='FREE ZIP Code Search']";
    public static final String CONSENT_BUTTON_LOCATOR="//p[text()='Consent']";
    public static final String ADVANCED_SEARCH_BUTTON_LOCATOR="//a[text()='Advanced Search']";
    public static final String TOWN_CITY_INPUT_LOCATOR="//label[text()='Town/City:']/following::input[@name='fld-city']";
    public static final String TABLE_RESULT="//table[@class='statTable']";
    public static final String ZIP_CODE_BUTTON_FOR_A_TOWN="//table[@class='statTable']/tbody/tr[%d]/td[1]/a";
    public static final String TABLE_WITH_DETAILS_FOR_A_TOWN ="//h2[contains(text(),'Details')]/following-sibling::table[@class='statTable']";
    public static final String STRING_TO_SEARCH_FOR="Eli";
    public static final String GOOGLE_MAPS_URL="https://maps.google.com/?q=%s,%s";
    public static final String GOOGLE_ACCEPT_ALL_BUTTON="//button[@aria-label='Приемане на всички']";
    public static final String GOOGLE_MAPS_SIGN_BUTTON="//a[text()='Вход']";
    public static final String GOOGLE_MAPS_SEARCH_BOX="//*[@id='searchboxinput']";
    public static final String OUTPUT_FILE_LOCATION_AND_NAME=".\\target\\%s- %s- %s.jpg";


}
