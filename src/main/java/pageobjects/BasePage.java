package pageobjects;

import helper.DriverHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;

import java.util.List;

public class BasePage {
    //Locators
    private String menuLevel1Tab = "//ul[@id='menu']/li/a[normalize-space(text())='%s']";
    private String menuLevel2Tab = "//ul[@id='menu']/li/a[normalize-space(text())='%s']/following-sibling::ul/li/a[normalize-space(text())='%s']";
    private String menuLevel3Tab = "//ul[@id='menu']/li/a[normalize-space(text())='%s']/following-sibling::ul/li/a[normalize-space(text())='%s']/../../../following::ul[@id='nav-empty']//a[normalize-space(text())='%s']";
    private String sideBarNav = "//ul[@id='submenu']//a[contains(text(), '%s')]";
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
    private String contentNavTab = "//ul[@id='myTabTabs']/li/a[contains(text(),'%s')]";
    private String valueCategory = "//ul[@class='chzn-results']/li[contains(text(), '%s')]";
    private By idColLink = By.cssSelector("a[data-order='a.id']");
    private By idColumn = By.xpath("//table//td[count(//th[contains(.,'ID')]/preceding-sibling::th)+1]");
    private By arrowDown = By.cssSelector("icon-arrow-down-3");
    private By arrowUp = By.cssSelector(".icon-arrow-up-3");
    private String titleClientHelp = "//h1[.='%s']";
    private By pagingControl = By.id("list_limit_chzn");
    private String valuePagingControl = "//div[@id='list_limit_chzn']//ul['chzn-results']/li[contains(text(), '%s')]";

    //Element
    private WebElement getSideBarNav(String value) {
        return DriverHelper.getWebDriver().findElement(By.xpath(String.format(sideBarNav, value)));
    }

    private WebElement getMenuLevel2Tab(String level1, String level2) {
        return DriverHelper.getWebDriver().findElement(By.xpath(String.format(menuLevel2Tab, level1, level2)));
    }

    private WebElement getMenuLevel3Tab(String level1, String level2, String level3) {
        return DriverHelper.getWebDriver().findElement(By.xpath(String.format(menuLevel3Tab, level1, level2, level3)));
    }

    private WebElement getMenuLevel1Tab(String value) {
        return DriverHelper.getWebDriver().findElement(By.xpath(String.format(menuLevel1Tab, value)));
    }

    private WebElement getContentNavTab(String value) {
        return DriverHelper.getWebDriver().findElement(By.xpath(String.format(contentNavTab, value)));
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
        return DriverHelper.getWebDriver().findElement(idColLink);
    }

    private List<WebElement> elements() {
        return DriverHelper.getWebDriver().findElements(idColumn);
    }

    private WebElement getArrowUp() {
        return DriverHelper.getWebDriver().findElement(arrowUp);
    }

    private WebElement getArrowDown() {
        return DriverHelper.getWebDriver().findElement(arrowDown);
    }

    private WebElement getTitleClientHelper(String value) {
        return DriverHelper.getWebDriver().findElement(By.xpath(String.format(titleClientHelp, value)));
    }

    private WebElement getPagingControl() {
        return DriverHelper.getWebDriver().findElement(pagingControl);
    }

    private WebElement getValuePagingControl(String value) {
        return DriverHelper.getWebDriver().findElement(By.xpath(String.format(valuePagingControl, value)));
    }

    //Methods

    /***
     * Select on Menu Level 1 Tabs
     * @param value
     */
    public void clickOnMenuLevel1Tab(String value) {
        getMenuLevel1Tab(value).click();
    }

    /***
     * Select on Menu Level 2 Tabs
     * @param level1
     * @param level2
     */
    public void clickOnMenuLevel2Tab(String level1, String level2) {
        clickOnMenuLevel1Tab(level1);
        getMenuLevel2Tab(level1, level2).click();
    }

    /***
     * Hover on Menu Level 2
     * @param level1
     *  @param level2
     */
    public void hoverOnMenuLevel2Tab(String level1, String level2) {
        Actions actions = new Actions(DriverHelper.getWebDriver());
        actions.moveToElement(getMenuLevel2Tab(level1, level2)).perform();
    }

    /***
     * Select on Menu Level 3 Tabs
     * @param level1
     * @param level2
     * @param level3
     */
    public void clickOnMenuLevel3Tab(String level1, String level2, String level3) {
        clickOnMenuLevel1Tab(level1);
        hoverOnMenuLevel2Tab(level1, level2);
        getMenuLevel3Tab(level1, level2, level3).click();
    }

    /***
     * Select on side bar Nav - sub menu
     * @param level1
     * @param level2
     * @param navBar
     */
    public void clickOnSideBarNav(String level1, String level2, String navBar) {
        clickOnMenuLevel2Tab(level1, level2);
        getSideBarNav(navBar).click();
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

    public void selectValuePagingControl(String value) {
        getPagingControl().click();
        getValuePagingControl(value).click();
    }

    public void selectContentNavTab(String value) {
        getContentNavTab(value).click();
    }

    /***
     * Click on the ID column
     */
    public void clickIDColumn() {
        getIDColumn().click();
    }

    /***
     * Select Arrow
     *
     */
    public void selectArrow() {
        clickIDColumn();
        if (getArrowUp().isDisplayed()) {
            getArrowUp().click();
        } else {
            getArrowDown().click();
        }
    }

    /***
     * Verify the table  by ID column
     */

    public boolean verifyIdAscending() {
        boolean boo = true;
        for (int i = 0; i < elements().size() - 1; i++) {
            if (Integer.parseInt(getTextTrim(elements().get(i))) > Integer.parseInt(getTextTrim(elements().get(i + 1)))) {
                boo = false;
                break;
            }
        }
        return boo;
    }

    public boolean verifyIdReverse() {
        boolean boo = true;
        for (int i = 0; i < elements().size() - 1; i++) {
            if (Integer.parseInt(getTextTrim(elements().get(i))) < Integer.parseInt(getTextTrim(elements().get(i + 1)))) {
                boo = false;
                break;
            }
        }
        return boo;
    }

    /***
     * Get text and trim space
     * @param element
     * @return
     */
    public String getTextTrim(WebElement element) {
        return element.getText().trim();
    }

    /***
     * Get title Client Helper page
     * @param value
     * @return
     */
    public String getTextTitleClientHelper(String value) {
        return getTextTrim(getTitleClientHelper(value));
    }

    /***
     *  Converted Into HexFormat
     * @param color
     * @return
     */
    public String getColorMessage(String color) {
        String hexColor = Color.fromString(color).asHex();
        return hexColor;
    }

}
