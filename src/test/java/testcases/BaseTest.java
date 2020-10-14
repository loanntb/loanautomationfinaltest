package testcases;

import common.Constant;
import helper.DriverHelper;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import static org.openqa.selenium.remote.BrowserType.CHROME;
import static org.openqa.selenium.remote.BrowserType.FIREFOX;


public class BaseTest extends DriverHelper {

    @BeforeMethod
    @Parameters("browser")
    public void setUpBrowser(String browser) {
        //start browser using DriverManager
        if (CHROME.equals(browser)) {
            startBrowser(DriverType.CHROME);
            navigateToUrl(Constant.JOOMLA_URL);
        } else if (FIREFOX.equals(browser)) {
            startBrowser(DriverType.FIREFOX);
            navigateToUrl(Constant.JOOMLA_URL);
        } else {
            startBrowser(DriverType.EDGE);
            navigateToUrl(Constant.JOOMLA_URL);
        }
    }

    @AfterMethod
    public void closeBrowser() {
        closeWebDriver();
    }

    @AfterTest
    public void cleanUpAll() {
        quitWebDriver();
    }


}
