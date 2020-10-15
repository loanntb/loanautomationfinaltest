package helper;

import java.util.ArrayList;

public class ClientHelper {
    public static boolean verifyHelpPageTitle(String title) {
        // Get all Open Tabs
        ArrayList<String> tabHandles = new ArrayList<String>(DriverHelper.getWebDriver().getWindowHandles());
        for (String eachHandle : tabHandles) {
            DriverHelper.getWebDriver().switchTo().window(eachHandle);
            // Check Help Page Title
            if (DriverHelper.getWebDriver().getTitle().equals(title)) {
                return true;
            }
        }
        return false;
    }
}
