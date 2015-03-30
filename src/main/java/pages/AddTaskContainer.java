package pages;

import com.sun.org.apache.xml.internal.utils.Constants;
import framework.selenium.Commons;
import framework.selenium.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;


/**
 * Created by Silvia Coca on 3/22/2015.
 */
public class AddTaskContainer {

    WebDriver driver;
    WebDriverWait wait;
    private By AddTaskLink = By.xpath("//a[contains(text(),'Add Task')]");


    public AddTaskContainer(WebDriver driver)
    {
        this.driver = driver;
        this.wait = DriverManager.getInstance().getWait();
        wait.until(ExpectedConditions.visibilityOfElementLocated(AddTaskLink));
    }

    public void ClickAddTask()
    {
        driver.findElement(AddTaskLink).click();

    }

    public void setNameTask(String taskName)
    {
        driver.findElement(By.xpath("//textarea[@name='ta']")).sendKeys(taskName);
    }

    public void clickSaveBtn()
    {
        driver.findElement(By.xpath("//span[contains(.,'Add Task')]")).click();

    }

    public ContextMenuTask clickSubMenu(String tasKName)
    {

        WebElement taskElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr[contains(.,'" + tasKName + "')]")));

            Action action = new Actions(driver).moveToElement(taskElement).build();
            action.perform();
            taskElement.findElement(By.xpath("//li[contains(@id, 'item')]/descendant::td[@class='menu']/div[contains(@class, 'cmp_menu')]")).click();

        return new ContextMenuTask(driver);
    }


    public boolean isTaskDisplayed(String taskName) {
        return Commons.isElementPresent(By.xpath("//tr[contains(.,'" + taskName + "')]"));
    }



}