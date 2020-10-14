package pageobjects;

import common.Log;
import helper.DriverHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class BasePage {
    //Locators
    private String menuLevel1Tab = "//ul[@id='menu']/li/a[normalize-space(text())='%s']";
    private String menuLevel2Tab = "//ul[@id='menu']/li/a[normalize-space(text())='%s']/following-sibling::ul/li/a[normalize-space(text())='%s']";
    private By newButton = By.id("toolbar-new");
    private By saveAndCloseButton = By.xpath("//div[@id='toolbar-save']/button[@class='btn btn-small button-save']");
    private By publishButton = By.id("toolbar-publish");
    private By unpublishButton = By.id("toolbar-unpublish");
    private By archiveButton = By.id("toolbar-archive");
    private By cancelButton = By.cssSelector(".button-cancel");
    private By saveAndNewButton = By.cssSelector(".button-save-new");
    private By checkBox = By.cssSelector("tr:first-child input[name='cid[]']");
    private By status = By.cssSelector(".chzn-color-state.chzn-single");
    private String elementStatus = "//div[@class='chzn-drop']//li[contains(text(),'%s')]";
    private By category = By.cssSelector("#jform_catid_chzn .chzn-single");
    private String valueCategory = "//div[@id='jform_catid_chzn']//span[contains(text(), '%s')]";
    private By idCol = By.cssSelector("a[data-order='a.id']");
    private By arrowDown = By.cssSelector("icon-arrow-down-3");
    private By arrowUp = By.cssSelector(".icon-arrow-up-3");
    private String navMenu = "//ul[@id='nav-empty']//a[contains(text(), '%s')]";


    //Element
    private WebElement getMenuLevel1Tab(String value) {
        return DriverHelper.getWebDriver().findElement(By.xpath(String.format(menuLevel1Tab, value)));
    }
    private String getTextMenuLevel1Tab(String value) {
        Log.info("Menu Level 1" + getTextTrim(getMenuLevel1Tab(value)));
        return getTextTrim(getMenuLevel1Tab(value));
    }
    private WebElement getMenuLevel2Tab(String level1, String level2) {
        Log.info("Menu Level 2" + DriverHelper.getWebDriver().findElement(By.xpath(String.format(menuLevel2Tab, getTextMenuLevel1Tab(level1), level2))));
        return DriverHelper.getWebDriver().findElement(By.xpath(String.format(menuLevel2Tab, getTextMenuLevel1Tab(level1), level2)));
    }

    private WebElement getSaveAndCloseButton() {
        return DriverHelper.getWebDriver().findElement(saveAndCloseButton);
    }

    private WebElement getNewButton() {
        return DriverHelper.getWebDriver().findElement(newButton);
    }

    private WebElement getPublishButton() {
        return DriverHelper.getWebDriver().findElement(publishButton);
    }

    private WebElement getUnpublishButton() {
        return DriverHelper.getWebDriver().findElement(unpublishButton);
    }

    private WebElement getArchiveButton() {
        return DriverHelper.getWebDriver().findElement(archiveButton);
    }

    private WebElement getCancelButton() {
        return DriverHelper.getWebDriver().findElement(cancelButton);
    }

    private WebElement getSaveAndNewButton() {
        return DriverHelper.getWebDriver().findElement(saveAndNewButton);
    }
    private WebElement getCheckBox() {
        return DriverHelper.getWebDriver().findElement(checkBox);
    }

    private WebElement getStatus() {
        return DriverHelper.getWebDriver().findElement(status);
    }

    private WebElement getElementStatus(String status) {
        return DriverHelper.getWebDriver().findElement(By.xpath(String.format(elementStatus, status)));
    }

    private WebElement getCategory() {
        return DriverHelper.getWebDriver().findElement(category);
    }

    private WebElement getValueCategory(String value) {
        return DriverHelper.getWebDriver().findElement(By.xpath(String.format(valueCategory, value)));
    }

    private WebElement getIDColumn() {
        return DriverHelper.getWebDriver().findElement(idCol);
    }

    private WebElement getArrowUp() {
        return DriverHelper.getWebDriver().findElement(arrowUp);
    }

    private WebElement getArrowDown() {
        return DriverHelper.getWebDriver().findElement(arrowDown);
    }

    //Methods

    /***
     * Select on Menu Tabs
     * @param value
     */
    public void clickOnMenuLevel1Tab(String value) {
       getMenuLevel1Tab(value).click();
    }

    /***
     * Hover on menu
     * @param menu
     */
    public void hoverOnMenuLevel1Tab(String menu) {
        Actions actions = new Actions(DriverHelper.getWebDriver());
        actions.moveToElement(getMenuLevel1Tab(menu)).perform();
    }

    public void clickOnMenuLevel2Tab(String level1, String level2){
        clickOnMenuLevel1Tab(level1);
        getMenuLevel2Tab(level1, level2).click();
    }

    public void clickNewButton() {
        getNewButton().click();
    }

    public void clickSaveAndCloseButton() {
        getSaveAndCloseButton().click();
    }

    public void clickCheckbox() {
        getCheckBox().click();
    }

    public void clickPublishButton() {
        getPublishButton().click();
    }

    public void clickArchiveButton() {
        getArchiveButton().click();
    }

    public void clickUnpublishButton() {
        getUnpublishButton().click();
    }

    public void clickCancelButton() {
        getCancelButton().click();
    }

    public void clickSaveAndNewButton() {
        getSaveAndNewButton().click();
    }
    public void selectStatus(String status) {
        getStatus().click();
        getElementStatus(status).click();
    }

    public void selectValueCategory(String value) {
        getCategory().click();
        getValueCategory(value).click();
    }


    public void clickIDColumn() {
        getIDColumn().click();
    }

    public void selectArrow() {
        clickIDColumn();
        if (getArrowUp().isDisplayed()) {
            getArrowUp().click();
        } else {
            getArrowDown().click();
        }
    }

    /***
     * Get text and trim space
     * @param element
     * @return
     */
    public String getTextTrim(WebElement element) {
        return element.getText().trim();
    }


}
