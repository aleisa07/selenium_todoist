package pages;

import framework.selenium.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Silvia Coca on 3/22/2015.
 */
public class ContextMenuTask {

    WebDriver driver;
    WebDriverWait wait;
    private By priority2 = By.xpath("html/body/div[12]/table/tbody/tr[6]/td/ul/li[2]/a[3]/img");
    private By deleteTaskMenu = By.xpath("//td/div[contains(.,'Delete task')]");


    public ContextMenuTask(WebDriver driver)
    {
        this.driver = driver;
        this.wait = DriverManager.getInstance().getWait();
        wait.until(ExpectedConditions.visibilityOfElementLocated(priority2));
    }

    public void SelectPriority2()
    {
        driver.findElement(priority2).click();

    }

    public void ClickDeleteTaskMenu()
    {
     driver.findElement(deleteTaskMenu).click();


    }


}