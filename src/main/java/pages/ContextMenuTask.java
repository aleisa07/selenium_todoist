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
    private By priority2 = By.cssSelector("img.cmp_priority2");
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
        try{
     driver.findElement(deleteTaskMenu).click();
     Thread.sleep(1000);


        }
        catch (Exception e){
            System.out.print("exception to click delete Task Menu");
        }
    }


}