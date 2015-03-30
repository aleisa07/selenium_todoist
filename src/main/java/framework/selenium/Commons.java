package framework.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import java.util.LinkedList;
import java.util.Set;

public class Commons {

    public static boolean isElementPresent(By by) {
        try {
            DriverManager.getInstance().getWebDriver().findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }


    public static void  swithTo(WebDriver driver) throws InterruptedException {
        try {
        Thread.sleep(5000);
        Set<String> listWindows = driver.getWindowHandles();
        System.out.println("size" + listWindows.size());
        for (String windows : listWindows) {
            System.out.println(windows);
        }
        LinkedList<String> windows = new LinkedList(listWindows);
        String nameModalDialog = windows.getLast();
       // System.out.println("el nombre del modal" + nameModalDialog);
        driver.switchTo().frame(nameModalDialog);

        }
        catch (WebDriverException e) {
            //System.out.print("Something happended for Try ");
            throw new WebDriverException(e);

        } finally {
            driver.switchTo().defaultContent();
        }
    }
}
