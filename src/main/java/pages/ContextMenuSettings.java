package pages;

import framework.selenium.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Driver;

/**
 * Created by Silvia Coca on 3/23/2015.
 */
public class ContextMenuSettings {

    WebDriver driver;
    WebDriverWait wait;
    private By SettingBtn = By.xpath("//td/div[contains(.,'Todoist Settings')]");

    public ContextMenuSettings(WebDriver driver)
    {
        this.driver = driver;
        this.wait = DriverManager.getInstance().getWait();
        wait.until(ExpectedConditions.visibilityOfElementLocated(SettingBtn));

    }

    public SettingContainer clickSettingsMenu()
    {
        driver.findElement(SettingBtn).click();
        return new SettingContainer(driver);
    }

    public void clickLogoutMenu()
    {
        try{
         Thread.sleep(1000);
         driver.findElement(By.xpath("//td/div[contains(.,'Logout')]")).click();
            Thread.sleep(1000);
        }catch(Exception e)
        {
            System.out.print("Error on ClickLogoutMenu");
        }
    }

}
