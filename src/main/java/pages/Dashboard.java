package pages;

import framework.selenium.Commons;
import framework.selenium.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by Silvia Coca on 3/18/2015.
 */
public class Dashboard {

    WebDriver driver;
    WebDriverWait wait;
    private By AddProjectlbl = By.xpath("//a[contains(.,'Add Project')]");


    public Dashboard(WebDriver driver)
    {

        driver.switchTo().defaultContent();
        driver.switchTo().defaultContent();
        this.driver = driver;
        this.wait = DriverManager.getInstance().getWait();
        wait.until(ExpectedConditions.visibilityOfElementLocated(AddProjectlbl));

    }

   public ContainerAddProject ClickAddProjectLbl()
   {
       driver.findElement(AddProjectlbl).click();
       return new ContainerAddProject(driver);

   }

    public ContainerEditProject ClickEditProject(String projectName)
    {

       try
       {
           WebElement webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr[contains(., '" + projectName+ "')]")));
           Action action = new Actions(driver).moveToElement(webElement).build();
           action.perform();

            webElement.findElement(By.xpath("//tr[contains(., '"+ projectName +"')]/descendant::td[@class='menu']/div[contains(@class, 'cmp_menu')]")).click();

        Thread.sleep(1000);

        driver.findElement(By.xpath("//td/div[contains(.,'Edit project')]")).click();

        return new ContainerEditProject(driver);
    } catch (Exception e)
       {
           System.out.print("edit error");
       }
       return new ContainerEditProject(driver);

    }

    public ModalDeleteProject ClickDeleteProject(String nameProject)
    {

        try
        {
            WebElement webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr[contains(., '"+ nameProject +"')]")));
            Action action = new Actions(driver).moveToElement(webElement).build();
            action.perform();

            webElement.findElement(By.xpath("//tr[contains(., '"+ nameProject +"')]/descendant::td[@class='menu']/div[contains(@class, 'cmp_menu')]")).click();

            Thread.sleep(1000);

            driver.findElement(By.id("menu_delete_text")).click();
            return new ModalDeleteProject(driver);
        } catch (Exception e)
        {
            System.out.print("delete error");
        }
        return new ModalDeleteProject(driver);

    }

    public ContextMenuSettings clickSettings()
    {
        driver.findElement(By.xpath("//*[@id='top_icons']/img[2]")).click();
        return new ContextMenuSettings(driver);
    }



    public boolean isLblProjectDisplayed() {
        return Commons.isElementPresent(AddProjectlbl);
    }


    public boolean isProjectDisplayed(String projectName) {
        return Commons.isElementPresent(By.xpath("//tr[contains(., '"+ projectName +"')]"));
    }

}
