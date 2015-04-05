package framework.testng;

import framework.selenium.DriverManager;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

/**
 * Created by Carlos Gonzales on 3/27/2015.
 */
public class TestListener implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        long time = result.getEndMillis() - result.getStartMillis();
        System.out.println("Time execution : " + time/1000 + " sec");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        DriverManager.getInstance().takeScreenShot(result.getName());
        Reporter.log("<a href='screenshot/" + result.getName() + ".png' >ScreenShot</a>");
    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {

    }
}
