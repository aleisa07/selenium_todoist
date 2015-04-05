package framework.testng;

import framework.selenium.DriverManager;
import org.testng.ISuite;
import org.testng.ISuiteListener;

/**
 * Created by Carlos Gonzales on 3/27/2015.
 */
public class SuiteListener implements ISuiteListener{
    @Override
    public void onStart(ISuite suite) {
        System.out.println("Starting suite " + suite.getName());
        DriverManager.getInstance();
    }

    @Override
    public void onFinish(ISuite suite) {
        DriverManager.getInstance().quitDriver();
        System.out.println("Finishing suite " + suite.getName());
    }
}
