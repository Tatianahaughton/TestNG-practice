package class03;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenersDemo implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Test passed");
    }
    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test failed");
    }

}
