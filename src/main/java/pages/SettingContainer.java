package pages;

import framework.selenium.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Silvia Coca on 3/23/2015.
 */
public class SettingContainer {
    WebDriver driver;
    WebDriverWait wait;
    private By accountTab = By.linkText("Account");
    private By frameSettingsName = By.name("GB_frame");
    private By frameSettingsId = By.id("GB_frame");

    public SettingContainer(WebDriver driver) {
        this.driver = driver;
        this.wait = DriverManager.getInstance().getWait();
        try {
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameSettingsName));
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameSettingsId));
        } catch (WebDriverException e) {
            throw new WebDriverException(e);
        } finally {
            driver.switchTo().defaultContent();
        }
    }

    public AccountContainer clickAccountTab() {
        try {
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameSettingsName));
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameSettingsId));
            driver.findElement(accountTab).click();
        } catch (WebDriverException e) {
            throw new WebDriverException(e);
        } finally {
            driver.switchTo().defaultContent();
        }
        return new AccountContainer(driver);
    }
}
