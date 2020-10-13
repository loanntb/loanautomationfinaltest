package helper;

import common.Constant;
import common.Log;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class DriverHelper {

    private static WebDriver driver;

    public enum DriverType {
        CHROME, FIREFOX, EDGE;
    }

    /***
     * Start browser to init driver
     * @param type : Type of DriverType
     */
    public static void startBrowser(DriverType type) {
        switch (type) {
            case CHROME:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            default:
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Constant.TIME_OUT_SHORT, TimeUnit.SECONDS);
    }

    /***
     * Navigate to base URL
     */
    public static void navigateToUrl(String url) {
        driver.get(url);
    }

    /***
     * Quit driver
     */
    public static void quitWebDriver() {
        if (null != driver) {
            driver.quit();
            driver = null;
        }
    }

    /***
     * Close driver
     */
    public static void closeWebDriver() {
        if (driver != null) {
            driver.close();
            driver = null;
        }
    }

    /***
     * Get driver from outside
     * @return : driver
     */
    public static WebDriver getWebDriver() {
        return driver;
    }

    /***
     * JavascriptExecutor
     * @return
     */
    public static JavascriptExecutor initJs() {
        return (JavascriptExecutor) driver;
    }

    /***
     * Scroll till end of the page
     *
     */
    public static void scrollToPageView() {
        initJs().executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }
    // Accepting javascript alert
    public static void alertAccept() {
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
}